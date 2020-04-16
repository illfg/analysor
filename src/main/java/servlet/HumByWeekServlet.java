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

@WebServlet("/humbyweek")
public class HumByWeekServlet extends HttpServlet {
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
            //获取平均温度,并将weekc中的温度值拿出
            Double ave = 0.0;
            score = 0;
            for (Weekc w : values) {
                String hum = w.getHum();
                double v = 0.0;
                if (!"".equals(hum)){
                    v = Double.parseDouble(hum);
                }
                ave += v;
                valuesD.add(v);
            }
            ave = ave/values.size();

            //根据得分获取评价
            String comment = getComment(month,ave);
            //跳转到结果页
            req.setAttribute("title","按周查询舒适度评价");
            req.setAttribute("ave",ave);
            req.setAttribute("score",score);
            req.setAttribute("comment",comment);
            req.setAttribute("keys",keys);
            req.setAttribute("values",valuesD);
            req.getRequestDispatcher("temresult.jsp").forward(req,resp);

        }else {

            //跳回输入界面
            req.getRequestDispatcher("tembyweek.jsp").forward(req,resp);
        }

    }

    private String getComment(String month,Double ave) {
        int mon = Integer.parseInt(month);
        if (mon>=6&&mon<7){
            if (ave>=30&&ave<=60){
                score = 100;
                return "舒适";
            }else if (ave < 30){
                score = 0;
                return "过分干燥";
            }else {
                score = 0;
                return "湿度过大";
            }
        }else if (mon == 11||mon == 12||mon == 1){
            if (ave >= 30&&ave<=80){
                score = 100;
                return "舒适";
            }else if (ave < 30){
                score = 0;
                return "过分干燥";
            }else {
                score = 0;
                return "湿度过大";
            }
        }else {
            if (ave >=40&&ave<60){
                score = 100;
                return "舒适";
            }else if (ave < 40){
                score = 0;
                return "过分干燥";
            }else {
                score = 0;
                return "湿度过大";
            }
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
