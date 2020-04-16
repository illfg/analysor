package servlet;

import entity.Weekc;
import service.CommonService;
import service.ResultHolder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/sudubyweek")
public class SuduByWeekServlet extends HttpServlet {
    Integer score = 0;
    CommonService service = new CommonService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String year = req.getParameter("year");
        String number = req.getParameter("number");
        String week = req.getParameter("week");
        String month = req.getParameter("month");
        if (isvalid(req)){
            int yeari = Integer.parseInt(year);
            int monthi = Integer.parseInt(month);
            int weeki = Integer.parseInt(week);
            //查询到该周的数据
            ResultHolder resultHolder = service.queryByWeek(yeari, monthi, weeki, number);
            List<Integer> keys = resultHolder.getKeys();
            List<Weekc> values = resultHolder.getValues();
            ArrayList<Double> valuesD = new ArrayList<>();
            //获取平均加速度
            Double N_ave = 0.0;
            Double P_ave = 0.0;
            int p_size =0,n_size = 0;
            score = 0;
            for (Weekc w : values) {
                double v = w.getAcc40();
                if (v > 0){
                    P_ave += v;
                    p_size++;
                }else {
                    N_ave += v;
                    n_size++;
                }
                valuesD.add(v);
            }
            P_ave = P_ave/p_size;
            N_ave = N_ave/n_size;
            //根据得分获取评价
            String comment = getComment(N_ave,P_ave);
            //跳转到结果页
            req.setAttribute("title","按周查询舒适度评价");
            req.setAttribute("pave",P_ave);
            req.setAttribute("nave",N_ave);
            req.setAttribute("score",score);
            req.setAttribute("comment",comment);
            req.setAttribute("keys",keys);
            req.setAttribute("values",valuesD);
            req.getRequestDispatcher("accresult.jsp").forward(req,resp);

        }else {

            //跳回输入界面
            req.getRequestDispatcher("accbyweek.jsp").forward(req,resp);
        }

    }

    private String getComment(Double N_ave,Double P_ave) {
        double abs = Math.abs(N_ave);
        if (2.646<=abs&&abs<=3.332){
            score -= 10;
        }else if (abs>4.214){
            score -= 20;
        }
        if (P_ave >= 0.315&&P_ave<=2.0){
            score = (int)((1.187-0.59*P_ave)*100);
        }else if (P_ave < 0.315){
            score = 100;
            return "舒适";
        }else {
            score = 0;
            return "及其不舒适";
        }
        if (0.315<=P_ave && P_ave < 0.5){
            return "有点不舒适";
        }else if (0.5<=P_ave && P_ave < 1){
            return "不舒适";
        }else if (1<=P_ave && P_ave < 1.6){
            return "相当不舒适";
        }else{
            return "非常不舒适";
        }
    }
    //验证必须非空的输入
    private boolean isvalid(HttpServletRequest req){
        String year = req.getParameter("year");
        String number = req.getParameter("number");
        boolean notnull = assetVertify(year)&&assetVertify(number);
        if (notnull){
            try{
                Integer.parseInt(year);
                return true;
            }catch (Exception e){
                req.setAttribute("info","请输入正确的年份");
                return false;
            }
        }else {
            req.setAttribute("info","必须填入数据");
            return false;
        }
    }

    //验证字符串是否为空的方法
    private boolean assetVertify(String str){
        if (str == null || str == "")
            return false;
        return true;
    }
}
