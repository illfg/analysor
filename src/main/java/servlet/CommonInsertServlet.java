package servlet;

import entity.Weekc;
import service.CommonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/commonInsert")
public class CommonInsertServlet extends HttpServlet {
    CommonService service = new CommonService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码，获取参数
        req.setCharacterEncoding("utf-8");
        String number = req.getParameter("number");
        String hum = req.getParameter("hum");
        String tem = req.getParameter("tem");
        String acc = req.getParameter("acc");
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String week = req.getParameter("week");
        String day = req.getParameter("day");
        //需要先验证数据的有效性
        if (isvalid(req)){
            double accd = Double.parseDouble(acc);
            int weekd = Integer.parseInt(week);
            int monthd = Integer.parseInt(month);
            //数据有效，插入数据即可
            Weekc weekc = new Weekc(0, year, weekd, monthd, day, hum, accd, tem, number);
            service.insert(weekc);
            req.setAttribute("info","数据插入成功");
            //跳转回输入界面
            req.getRequestDispatcher("commonInsert.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("commonInsert.jsp").forward(req,resp);
        }

    }

    //验证必须非空的输入
    private boolean isvalid(HttpServletRequest req){
        String number = req.getParameter("number");
        String hum = req.getParameter("hum");
        String tem = req.getParameter("tem");
        String acc = req.getParameter("acc");
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String week = req.getParameter("week");
        String day = req.getParameter("day");
        //验证是否有空值
        boolean notnull = assetVertify(number)&&assetVertify(hum)&&assetVertify(tem)
                &&assetVertify(acc)&&assetVertify(year)&&assetVertify(month)&&
                assetVertify(week)&&assetVertify(day);
        if (notnull){
            try {
                //检查传入的数值是否符合规范，如果报错则说明格式不对，返回false并提示
                Double.parseDouble(hum);
                Double.parseDouble(tem);
                Double.parseDouble(acc);
                Integer.parseInt(day);
                int inw = Integer.parseInt(week);
                //判断周数是否符合规范
                if (inw >4||inw<1){
                    throw new Exception();
                }
                //检查输入的时间
                String time = year+"/"+month+"/"+day;
                Date date = new Date(time);
                return true;
            }catch (Exception e){
                req.setAttribute("info","请检查时间格式");
                return false;
            }
        }else {
            req.setAttribute("info","请填写所有的信息");
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
