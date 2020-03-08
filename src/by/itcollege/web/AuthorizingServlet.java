package by.itcollege.web;

import by.itcollege.dao.UserDaoImpl;
import by.itcollege.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/authorizing", name = "Authorizing servlet")
public class AuthorizingServlet extends HttpServlet {

    private UserDaoImpl userDao = UserDaoImpl.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/authorizing-page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("login"));
        String password = req.getParameter("password");
        User user = userDao.findById(id);
        if (user.getPassword().equals(password)){
            req.setAttribute("name", user.getName());
            req.setAttribute("surname", user.getLastName());
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            if (!user.getRole().toString().equals("CLIENT")) req.getRequestDispatcher("/WEB-INF/jsp/after-authorizing-driver-disp.jsp").forward(req, resp);
            else req.getRequestDispatcher("/WEB-INF/jsp/after-authorizing-client.jsp").forward(req, resp);
        }
        else resp.sendRedirect("/authorizing");
    }
}
