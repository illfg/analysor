package servlet;

import entity.Humidity;
import service.HumidityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@WebServlet("/humidityInsert")
public class HumidityInsertServlet extends HttpServlet {

    HumidityService service = new HumidityService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String number = req.getParameter("number");
        String name = req.getParameter("name");
        String hum = req.getParameter("hum");
        String time = req.getParameter("time");
        String now = req.getParameter("now");
        //数据验证通过时 插入输入到数据库
        if (isvalid(req)){
            Date nowDate = new Date(time +" "+ now);
            Date timeDate = new Date(time);
            Humidity humidity = new Humidity(nowDate, hum, name, number, timeDate);
            service.insert(humidity);
            req.setAttribute("hum","数据插入成功！");
        }
        //跳回输入界面
        req.getRequestDispatcher("humInsert.jsp").forward(req,resp);
    }

    //验证必须非空的输入
    private boolean isvalid(HttpServletRequest req){
        String number = req.getParameter("number");
        String hum = req.getParameter("hum");
        String time = req.getParameter("time");
        String now = req.getParameter("now");
        boolean notnull = assetVertify(number)&&assetVertify(time)&&assetVertify(now)&&assetVertify(hum);
        if (notnull){
            //尝试转换格式
            try {
                double humd = Double.parseDouble(hum);
                Date date = new Date(time +" "+ now);
                if (service.querybykey(date) != null){
                    req.setAttribute("hum","该时间数据已记录");
                    return false;
                }
                return true;
            }catch (Exception e){
                //转化失败，不插入数据
                req.setAttribute("hum","数据转化失败，请检查数据格式");
                return false;
            }
        }
        return false;
    }

    //验证字符串是否为空的方法
    private boolean assetVertify(String str){
        if (str == null || str == "")
            return false;
        return true;
    }
}
