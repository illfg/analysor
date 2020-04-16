package servlet;

import entity.Mes;
import service.MesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mes")
public class MesServlet extends HttpServlet {
    MesService service = new MesService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Mes> mesList = service.queryallMes();
        req.setAttribute("mes",mesList);
        req.getRequestDispatcher("backstage.jsp").forward(req,resp);
    }
}
