package servlet;

import entity.Mes;
import entity.User;
import service.MesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/mesInsert")
public class MesInsertServlet extends HttpServlet {

    MesService service = new MesService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String type = req.getParameter("type");
        String sex = req.getParameter("sex");
        String realName = req.getParameter("realName");
        String description = req.getParameter("description");
        String mobile = req.getParameter("mobile");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");

        if (isvalid(req)){
            Mes mes = new Mes(mobile, type, sex, realName, description, tel, email);
            service.insertMes(mes);
            req.setAttribute("info","您的反馈已提交");
        }else {
            req.setAttribute("info","请至少填写内容,类型,以及手机号");
        }
        req.getRequestDispatcher("comment.jsp").forward(req,resp);
    }

    //验证必须非空的输入
    private boolean isvalid(HttpServletRequest req){
        String description = req.getParameter("description");
        String type = req.getParameter("type");
        String mobile = req.getParameter("mobile");

        boolean notnull = assetVertify(description)&&assetVertify(type)&&assetVertify(mobile);
        if (notnull){
          return true;
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
