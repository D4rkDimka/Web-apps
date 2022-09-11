package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        resp.getWriter().write("URL: 127.0.0.1:8080" + requestURI + '\n');

        String parameterMap = req.getParameterMap()
                .entrySet()
                .stream()
                .map(entryParam -> {
                    String param = String.join(" ", entryParam.getValue());
                    return "Car model:  " + entryParam.getKey() + " = " + param + '\n';
                })
                .collect(Collectors.joining());
        resp.getWriter().write(parameterMap);

        //127.0.0.1:8080/ServletApp/page?BMW X5=12&Mazda R1=122&AUDI A8=67
        String carId = "10";

        String parameterMap2 = req.getParameterMap()
                .entrySet()
                .stream()
                .filter(car->car.getValue().equals(carId))
                .map(car -> {
                    String cars = String.join(" ", car.getValue());
                    return "Car model:  " + car.getKey() + " = " + cars + '\n';
                })
                .collect(Collectors.joining());
        resp.getWriter().write("\nCars with id 10\n" + parameterMap2);

        //127.0.0.1:8080/ServletApp/page?BMW X5=12&Mazda R1=122&AUDI A8=67 Honda Civic=10
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        resp.getWriter().write("URL: 127.0.0.1:8080" + requestURI + '\n');

        String parameterMap = req.getParameterMap()
                .entrySet()
                .stream()
                .map(entryParam -> {
                    String param = String.join(" ", entryParam.getValue());
                    return "Car model:  " + entryParam.getKey() + " = " + param + '\n';
                })
                .collect(Collectors.joining());
        resp.getWriter().write(parameterMap);

        String model = req.getParameter("Model");
        String id = req.getParameter("ID");
        resp.getWriter().write("Car model: " + model + " = " + id);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        resp.getWriter().write("URL: 127.0.0.1:8080" + requestURI + '\n');

        String model = req.getParameter("Model");
        String id = req.getParameter("ID");
        Map<String, String[]> map = req.getParameterMap();

        displayCars(req,resp);

        resp.getWriter().write("Cars after delete\n");
        resp.getWriter().write("Hello");

        String parameterMap = req.getParameterMap()
                .entrySet()
                .stream()
                .filter(car->!car.getKey().equals("BMW X5"))
                .map(entryParam -> {
                    String param = String.join(" ", entryParam.getValue());
                    return "\nCar model:  " + entryParam.getKey() + " = " + param + '\n';
                })
                .collect(Collectors.joining());
        resp.getWriter().write(parameterMap);
    }

    public void displayCars(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String parameterMap = req.getParameterMap()
                .entrySet()
                .stream()
                .map(entryParam -> {
                    String param = String.join(" ", entryParam.getValue());
                    return "Car model:  " + entryParam.getKey() + " = " + param + '\n';
                })
                .collect(Collectors.joining());
        resp.getWriter().write(parameterMap);
    }
}
