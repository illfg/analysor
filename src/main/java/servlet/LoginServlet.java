package servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        //查询数据库中是否有这个人，有的话看看密码对不对
        User user = service.queryUser(username);
        if (user!=null&&user.getPassword().equals(password)){
            //将username保存到session域中，表示已经登录
            session.setAttribute("username",username);
        }else {
            //没有该用户或者密码不对
            req.setAttribute("error","用户名或密码错误!");
        }
        //跳转
        req.getRequestDispatcher("/mes").forward(req,resp);
    }
}
