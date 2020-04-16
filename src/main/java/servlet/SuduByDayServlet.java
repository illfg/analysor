package servlet;

import service.ResultHolder;
import service.Sudu40Service;
import service.TemperatureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/sudubyday")
public class SuduByDayServlet extends HttpServlet {
    Sudu40Service service = new Sudu40Service();
    Integer score = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String number = req.getParameter("number");
        String time = req.getParameter("time");
        String start = req.getParameter("start");
        String end = req.getParameter("end");

        if (isvalid(req)){
            //格式化时间
            start = time + " " +start + ":00";
            end = time + " " + end + ":00";
            //将数据带到结果页面
            ResultHolder holder = service.calculateDataByDay(start, end, number);
            //将时间和结果分开
            List<Integer> keys = holder.getKeys();
            List<Double> values = holder.getValues();
            //计算分数,分别统计加速与减速
            Double N_ave = 0.0;
            Double P_ave = 0.0;
            int n_size = 0,p_size = 0;
            for (Double value:values) {
                if (value>0){
                    P_ave += value;
                    p_size++;
                }else {
                    N_ave += value;
                    n_size++;
                }
            }
            P_ave = P_ave/p_size;
            N_ave = N_ave/n_size;
            score = 0;
            //根据得分获取评价
            String comment = getComment(N_ave,P_ave);
            //跳转到结果页
            req.setAttribute("title","按时段查询舒适度评价");
            req.setAttribute("nave",N_ave);
            req.setAttribute("pave",P_ave);
            req.setAttribute("score",score);
            req.setAttribute("comment",comment);
            req.setAttribute("keys",keys);
            req.setAttribute("values",values);
            req.getRequestDispatcher("accresult.jsp").forward(req,resp);

        }else {
            //跳回输入界面
            req.getRequestDispatcher("accbyday.jsp").forward(req,resp);
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
        String number = req.getParameter("number");
        String time = req.getParameter("time");
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        boolean notnull = assetVertify(number)&&assetVertify(time);

        if (notnull){
            //验证选择的开始时间是否小于结束时间
            try{
                //格式化时间
                start = time + " " +start + ":00";
                end = time + " " + end + " :00";

                Date startd = new Date(start.replace("-","/"));
                Date endd = new Date(end.replace("-","/"));
                if (startd.before(endd)){
                    return true;
                }else {
                    req.setAttribute("info","结束时间不能早于开始时间");
                    return false;
                }
            }catch (Exception e){
                req.setAttribute("info","请输入正确的时间格式");
                return false;
            }
        }
        req.setAttribute("info","请输入正确的数据");
        return false;
    }

    //验证字符串是否为空的方法
    private boolean assetVertify(String str){
        if (str == null || str == "")
            return false;
        return true;
    }
}
