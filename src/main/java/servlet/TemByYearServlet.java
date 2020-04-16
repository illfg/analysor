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

@WebServlet("/tembyyear")
public class TemByYearServlet extends HttpServlet {
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
        if (isvalid(req)){
            int yeari = Integer.parseInt(year);
            //查询到该周的数据
            ResultHolder resultHolder = service.queryByYear(yeari, number);
            List<Integer> keys = resultHolder.getKeys();
            List<Weekc> values = resultHolder.getValues();
            ArrayList<Double> valuesD = new ArrayList<>();
            //获取平均温度,并将weekc中的温度值拿出
            Double ave = 0.0;
             score = 0;
            for (Weekc w : values) {
                String tem = w.getTem();
                double v = 0.0;
                if (!"".equals(tem)){
                    v = Double.parseDouble(tem);
                }
                ave += v;
                valuesD.add(v);
            }
            ave = ave/values.size();
            //根据得分获取评价
            String comment = getComment(ave);
            //跳转到结果页
            req.setAttribute("title","按年查询舒适度评价");
            req.setAttribute("ave",ave);
            req.setAttribute("score",score);
            req.setAttribute("comment",comment);
            req.setAttribute("keys",keys);
            req.setAttribute("values",valuesD);
            req.getRequestDispatcher("temresult.jsp").forward(req,resp);

        }else {

            //跳回输入界面
            req.getRequestDispatcher("tembyyear.jsp").forward(req,resp);
        }

    }

    private String getComment(Double ave) {
        if (ave < 10){
            score = 0;
            return "非常冷，极不可接受";
        }
        else if (10<=ave&&ave<14.5){
            score = 20;
            return "非常冷，极不可接受";
        }
        else if (14.5<=ave&&ave<17.5){
            score = 60;
            return "冷，不可接受";
        }
        else if (17.5<=ave&&ave < 22.2){
            score = 80;
            return "稍冷，稍不可接受";
        }
        else if (22.2<=ave&&ave < 25.6){
            score = 100;
            return "舒适";
        }
        else if (ave <= 25.6&&ave<30){
            score = 60;
            return "稍热，稍不可接受";
        }
        else if (30 <= ave&&ave<34.5){
            score = 40;
            return "热，不舒适，不可接受";
        }
        else if (34.5<= ave&&ave<37.5){
            score = 20;
            return "热，极其不可接受";
        }
        else if (37.5<ave){
            score = 0;
            return "非常热，极其不舒适";
        }
        else
            return "";
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
