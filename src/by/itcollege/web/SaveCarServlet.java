package by.itcollege.web;

import by.itcollege.dao.CarDaoImpl;
import by.itcollege.entity.Car;
import by.itcollege.entity.CarType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/car/save", name = "SaveCarServlet")
public class SaveCarServlet extends HttpServlet {

    private CarDaoImpl carDao = CarDaoImpl.newInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/save-car.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String model = req.getParameter("model");
        String brand = req.getParameter("brand");
        String number = req.getParameter("number");
        CarType carType = CarType.valueOf(req.getParameter("carType"));
        Car car = new Car(model, brand, carType, number);
        if (carDao.save(car)) {
            req.getRequestDispatcher("/WEB-INF/jsp/after-adding-car.jsp").forward(req,resp);
        } else {
            resp.sendRedirect("/car/save");
        }
    }
}
