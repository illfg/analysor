package servlet;

import entity.Temperature;
import service.DaoProvider;
import service.ResultHolder;
import service.TemperatureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/tembyday")
public class TemByDayServlet extends HttpServlet {
    TemperatureService service = new TemperatureService();
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
            //计算分数
            Double ave = 0.0;
            for (Double value:values) {
                ave += value;
            }
            ave = ave/values.size();
            score = 0;
            //根据得分获取评价
            String comment = getComment(ave);
            //跳转到结果页
            req.setAttribute("title","按时段查询舒适度评价");
            req.setAttribute("ave",ave);
            req.setAttribute("score",score);
            req.setAttribute("comment",comment);
            req.setAttribute("keys",keys);
            req.setAttribute("values",values);
            req.getRequestDispatcher("temresult.jsp").forward(req,resp);

        }else {
            //跳回输入界面
            req.getRequestDispatcher("tembyday.jsp").forward(req,resp);
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
