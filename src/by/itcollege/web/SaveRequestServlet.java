package by.itcollege.web;

import by.itcollege.entity.Car;
import by.itcollege.entity.Request;
import by.itcollege.entity.User;
import by.itcollege.service.CarService;
import by.itcollege.service.Cost;
import by.itcollege.service.RequestService;
import by.itcollege.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet(urlPatterns = "/request/save", name = "SaveRequestServlet")
public class SaveRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars", CarService.getInstance().getAllCars());
        req.getRequestDispatcher("/WEB-INF/jsp/save-request.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int beginTimeYear = Integer.parseInt(req.getParameter("beginTimeYear"));
        int beginTimeMonth = Integer.parseInt(req.getParameter("beginTimeMonth"));
        int beginTimeDay = Integer.parseInt(req.getParameter("beginTimeDay"));
        Date date = new Date(beginTimeYear, beginTimeMonth, beginTimeDay);
        int id = Integer.parseInt(req.getParameter("car"));
        Car car = CarService.getInstance().findById(id);
        int numberOfDays = Integer.parseInt(req.getParameter("numberOfDays"));
        double price = Cost.count(numberOfDays, car.getCarType());
        User user = (User) req.getSession().getAttribute("user");
        User driver = UserService.getInstance().getFreeDrivers().get(0);
        Request request = new Request(price, false, numberOfDays, car, date, user, driver);
        if (RequestService.getInstance().createRequest(request) && user != null) {
            req.setAttribute("cost", price);
            req.setAttribute("driver", driver);
            req.getRequestDispatcher("/WEB-INF/jsp/request-accepted.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/request/save").forward(req, resp);
        }
    }
}
