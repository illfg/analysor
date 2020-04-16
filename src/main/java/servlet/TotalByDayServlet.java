package servlet;

import service.HumidityService;
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

@WebServlet("/totalbyday")
public class TotalByDayServlet extends HttpServlet {
    //实例化服务类
    Sudu40Service sudu40service = new Sudu40Service();
    TemperatureService temservice = new TemperatureService();
    HumidityService humservice = new HumidityService();
    //各类分数
    Integer humscore = 0;
    Integer suduscore = 0;
    Integer temscore = 0;
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
            //获取该时段的所有数据
            ResultHolder suduholder = sudu40service.calculateDataByDay(start, end, number);
            ResultHolder temholder = temservice.calculateDataByDay(start, end, number);
            ResultHolder humholder = humservice.calculateDataByDay(start, end, number);
            //将时间和结果分开
            List<Double> suduvalues = suduholder.getValues();
            List<Double> temvalues = temholder.getValues();
            List<Double> humvalues = humholder.getValues();
            //计算分数,分别统计加速与减速
            //加速度
            Double N_ave = 0.0;
            Double P_ave = 0.0;
            int n_size = 0,p_size = 0;
            for (Double value:suduvalues) {
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
            //温度
            Double T_ave = 0.0;
            for (Double value:temvalues) {
                T_ave += value;
            }
            T_ave = T_ave/temvalues.size();
            //湿度
            Double H_ave = 0.0;
            for (Double value:humvalues) {
                H_ave += value;
            }
            H_ave = H_ave/humvalues.size();
            suduscore = 0;
            temscore = 0;
            humscore = 0;
            //根据得分获取评价
            String suduComment = getSuduComment(N_ave,P_ave);
            //获取月份
            String month = time.split("-")[1];
            String humComment = getHumComment(month, H_ave);
            String temComment = getTemComment(T_ave);

            //总评价
            int totalscore = (int) (suduscore*0.6 +temscore*0.3+humscore*0.1);

            //跳转到结果页
            req.setAttribute("title","按时段查询舒适度评价");
            req.setAttribute("nave",N_ave);
            req.setAttribute("pave",P_ave);
            req.setAttribute("tave",T_ave);
            req.setAttribute("have",H_ave);
            req.setAttribute("temscore",temscore);
            req.setAttribute("humscore",humscore);
            req.setAttribute("suduscore",suduscore);
            req.setAttribute("totalscore",totalscore);
            req.setAttribute("temcomment",temComment);
            req.setAttribute("humcomment",humComment);
            req.setAttribute("suducomment",suduComment);

            req.getRequestDispatcher("totalresult.jsp").forward(req,resp);

        }else {
            //跳回输入界面
            req.getRequestDispatcher("totalbyday.jsp").forward(req,resp);
        }

    }


    private String getSuduComment(Double N_ave,Double P_ave) {
        double abs = Math.abs(N_ave);
        if (2.646<=abs&&abs<=3.332){
            suduscore -= 10;
        }else if (abs>4.214){
            suduscore -= 20;
        }
        if (P_ave >= 0.315&&P_ave<=2.0){
            suduscore = (int)((1.187-0.59*P_ave)*100);
        }else if (P_ave < 0.315){
            suduscore = 100;
            return "舒适";
        }else {
            suduscore = 0;
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
    private String getHumComment(String month,Double ave) {
        int mon = Integer.parseInt(month);
        if (mon>=6&&mon<7){
            if (ave>=30&&ave<=60){
                humscore = 100;
                return "舒适";
            }else if (ave < 30){
                humscore = 0;
                return "过分干燥";
            }else {
                humscore = 0;
                return "湿度过大";
            }
        }else if (mon == 11||mon == 12||mon == 1){
            if (ave >= 30&&ave<=80){
                humscore = 100;
                return "舒适";
            }else if (ave < 30){
                humscore = 0;
                return "过分干燥";
            }else {
                humscore = 0;
                return "湿度过大";
            }
        }else {
            if (ave >=40&&ave<60){
                humscore = 100;
                return "舒适";
            }else if (ave < 40){
                humscore = 0;
                return "过分干燥";
            }else {
                humscore = 0;
                return "湿度过大";
            }
        }

    }
    private String getTemComment(Double ave) {
        if (ave < 10){
            temscore = 0;
            return "非常冷，极不可接受";
        }
        else if (10<=ave&&ave<14.5){
            temscore = 20;
            return "非常冷，极不可接受";
        }
        else if (14.5<=ave&&ave<17.5){
            temscore = 60;
            return "冷，不可接受";
        }
        else if (17.5<=ave&&ave < 22.2){
            temscore = 80;
            return "稍冷，稍不可接受";
        }
        else if (22.2<=ave&&ave < 25.6){
            temscore = 100;
            return "舒适";
        }
        else if (ave <= 25.6&&ave<30){
            temscore = 60;
            return "稍热，稍不可接受";
        }
        else if (30 <= ave&&ave<34.5){
            temscore = 40;
            return "热，不舒适，不可接受";
        }
        else if (34.5<= ave&&ave<37.5){
            temscore = 20;
            return "热，极其不可接受";
        }
        else if (37.5<ave){
            temscore = 0;
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
