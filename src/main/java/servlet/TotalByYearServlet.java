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
import java.util.List;

@WebServlet("/totalbyyear")
public class TotalByYearServlet extends HttpServlet {
    //各类分数
    Integer humscore = 0;
    Integer suduscore = 0;
    Integer temscore = 0;
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


            List<Weekc> values = resultHolder.getValues();

            //获取平均值
            Double N_ave = 0.0;
            Double P_ave = 0.0;
            Double H_ave = 0.0;
            Double T_ave = 0.0;
            //加速度
            int p_size =0,n_size = 0;
            for (Weekc w : values) {
                double v = w.getAcc40();
                if (v > 0){
                    P_ave += v;
                    p_size++;
                }else {
                    N_ave += v;
                    n_size++;
                }
            }
            P_ave = P_ave/p_size;
            N_ave = N_ave/n_size;

            //温度
            for (Weekc w : values) {
                String tem = w.getTem();
                double v = 0.0;
                if (!"".equals(tem)){
                    v = Double.parseDouble(tem);
                }
                T_ave += v;
            }
            T_ave = T_ave/values.size();

            //湿度
            for (Weekc w : values) {
                String hum = w.getHum();
                double v = 0.0;
                if (!"".equals(hum)){
                    v = Double.parseDouble(hum);
                }
                H_ave += v;
            }
            H_ave = H_ave/values.size();


            //重置分数
            suduscore = 0;
            temscore = 0;
            humscore = 0;

            //根据得分获取评价
            String suduComment = getSuduComment(N_ave,P_ave);

            //获取月份(按年查询的平均数值没有指定月数，故这里指定7月)
            String humComment = getHumComment("7", H_ave);
            String temComment = getTemComment(T_ave);

            //总评价
            int totalscore = (int) (suduscore*0.6 +temscore*0.3+humscore*0.1);


            //跳转到结果页
            req.setAttribute("title","按月查询舒适度评价");
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
            req.getRequestDispatcher("totalbyyear.jsp").forward(req,resp);
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
