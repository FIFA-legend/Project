package by.itcollege.web;

import by.itcollege.dao.UserDaoImpl;
import by.itcollege.entity.Role;
import by.itcollege.entity.User;
import by.itcollege.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/save", name = "SaveUserServlet")
public class SaveUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/save-user.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("surname");
        String password = req.getParameter("password");
        String repPassword = req.getParameter("repPassword");
        Role role = Role.valueOf(req.getParameter("role"));
        if (!repPassword.equals(password) || lastName.isEmpty() || name.isEmpty() || password.isEmpty()) {
            resp.sendRedirect("/user/save");
        } else {
            User user = new User(false, name, lastName, password, role);
            int id = UserService.getInstance().createNewUser(user);
            if (id != 0) {
                req.setAttribute("id", id);
                req.setAttribute("User", user);
                req.getRequestDispatcher("/WEB-INF/jsp/registration-success.jsp").include(req, resp);
            } else {
                resp.sendRedirect("/user/save");
            }
        }
    }
}
