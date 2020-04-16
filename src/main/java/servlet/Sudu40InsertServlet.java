package servlet;

import entity.Sudu40;
import service.Sudu40Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/suduInsert")
public class Sudu40InsertServlet extends HttpServlet {
    Sudu40Service service = new Sudu40Service();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String number = req.getParameter("number");
        String name = req.getParameter("name");
        String acc40 = req.getParameter("acc40");
        String time = req.getParameter("time");
        String now = req.getParameter("now");
        //若数据验证通过，则插入数据
        if (isvalid(req)) {
            Date nowDate = new Date(time + " " + now);
            Date timeDate = new Date(time);
            double acc = Double.parseDouble(acc40);
            Sudu40 sudu40 = new Sudu40(nowDate, acc, timeDate, number, name);
            service.insertSudu40(sudu40);
            req.setAttribute("sudu", "数据插入成功！");
        }
        //跳回输入界面
        req.getRequestDispatcher("accInput.jsp").forward(req,resp);
    }
    //验证必须非空的输入
    private boolean isvalid(HttpServletRequest req){
        String number = req.getParameter("number");
        String acc40 = req.getParameter("acc40");
        String time = req.getParameter("time");
        String now = req.getParameter("now");
        boolean notnull = assetVertify(acc40)&&assetVertify(time)&&assetVertify(now)&&assetVertify(number);
        if (notnull){
            //尝试转换格式
            try {
                double acc = Double.parseDouble(acc40);
                Date date = new Date(time +" "+ now);
                if (service.queryByKey(date) != null){
                    req.setAttribute("sudu","该时间数据已记录");
                    return false;
                }
                return true;
            }catch (Exception e){
                //转化失败，不插入数据
                req.setAttribute("sudu","数据转化失败，请检查数据格式");
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
