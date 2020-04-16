package servlet;

import service.HumidityService;
import service.ResultHolder;
import service.TemperatureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/humbyday")
public class HumByDayServlet extends HttpServlet {
    HumidityService service = new HumidityService();
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
            //获取到该时段的数据
            ResultHolder holder = service.calculateDataByDay(start, end, number);
            //将时间和结果分开
            List<Integer> keys = holder.getKeys();
            List<Double> values = holder.getValues();
            //计算平均值
            Double ave = 0.0;
            for (Double value:values) {
                ave += value;
            }
            ave = ave/values.size();
            //重置分数
            score = 0;
            //获取月份
            String month = time.split("-")[1];
            //根据月份与湿度获取评价
            String comment = getComment(month, ave);
            //跳转到结果页
            req.setAttribute("title","按时段查询舒适度评价");
            req.setAttribute("ave",ave);
            req.setAttribute("comment",comment);
            req.setAttribute("score",score);
            req.setAttribute("keys",keys);
            req.setAttribute("values",values);
            req.getRequestDispatcher("humresult.jsp").forward(req,resp);

        }else {
            //跳回输入界面
            req.getRequestDispatcher("humresult.jsp").forward(req,resp);
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
