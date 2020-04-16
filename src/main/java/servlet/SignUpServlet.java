package servlet;

import entity.User;
import mapper.UserMapper;
import service.DaoProvider;
import service.UserService;

import javax.imageio.ImageReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符编码
        req.setCharacterEncoding("utf-8");
        //获取用户参数
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String sex = req.getParameter("sex");
        //验证参数是否为空
        if (isvalid(req)){
            User user = new User(0, username, password1, sex);
            service.insertUser(user);
            //跳转
            req.getRequestDispatcher("/mes").forward(req,resp);
        }else {
            //如果有空值，就携带错误信息回到注册页面
            req.setAttribute("error","信息填写不正确或用户名已存在");
            req.getRequestDispatcher("signup.jsp").forward(req,resp);
        }

    }

    //验证传入的数据是否有效
    private boolean isvalid(HttpServletRequest req){
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String sex = req.getParameter("sex");

        boolean notnull = assetVertify(username) && assetVertify(password1)
                &&assetVertify(password2) && assetVertify(sex);
        //验证是否为空且两次输入的密码是否相同
        if (notnull&&password1.equals(password2)){
            //如果能在数据库中找到数据，则说明改用户名已被注册
            User user = service.queryUser(username);
            if (user != null){
                return false;
            }
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
