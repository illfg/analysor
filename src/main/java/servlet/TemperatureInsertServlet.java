package servlet;

import entity.Temperature;
import service.TemperatureService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/temInsert")
public class TemperatureInsertServlet extends HttpServlet {
    TemperatureService service = new TemperatureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String number = req.getParameter("number");
        String name = req.getParameter("name");
        String time = req.getParameter("time");
        String now = req.getParameter("now");
        String tem = req.getParameter("tem");

        if (isvalid(req)){
            Date nowDate = new Date(time +" "+ now);
            Date timeDate = new Date(time);
            Temperature temperature = new Temperature(nowDate, tem, timeDate, name, number);
            service.insert(temperature);
            req.setAttribute("tem","数据插入成功！");
        }
        //跳回输入界面
        req.getRequestDispatcher("temInsert.jsp").forward(req,resp);
    }

    //验证必须非空的输入
    private boolean isvalid(HttpServletRequest req){
        String number = req.getParameter("number");
        String tem = req.getParameter("tem");
        String time = req.getParameter("time");
        String now = req.getParameter("now");
        boolean notnull = assetVertify(number)&&assetVertify(time)&&assetVertify(now)&&assetVertify(tem);
        if (notnull){
            //尝试转换格式
            try {
                double temd = Double.parseDouble(tem);
                Date date = new Date(time +" "+ now);
                if (service.queryByKey(date) != null){
                    req.setAttribute("tem","该时间点数据已存在");
                    return false;
                }
                return true;
            }catch (Exception e){
                //转化失败，不插入数据
                req.setAttribute("tem","数据转化失败，请检查数据格式");
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
