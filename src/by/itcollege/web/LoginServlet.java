package by.itcollege.web;

import by.itcollege.entity.User;
import by.itcollege.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/authorizing-page.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("login"));
        String password = req.getParameter("password");
        User user = UserService.getInstance().findById(id);
        if (user != null && user.getPassword().equals(password)){
            req.setAttribute("name", user.getName());
            req.setAttribute("surname", user.getLastName());
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            if (!user.getRole().toString().equals("CLIENT")) req.getRequestDispatcher("/WEB-INF/jsp/workers-main-page.jsp").include(req, resp);
            else req.getRequestDispatcher("/WEB-INF/jsp/client-main-page.jsp").include(req, resp);
        }
        else {
            req.setAttribute("passwordMatch", false);
            req.getRequestDispatcher("/WEB-INF/jsp/authorizing-page.jsp").include(req, resp);
        }
    }
}
