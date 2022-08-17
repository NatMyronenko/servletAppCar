package com.example.car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/putServlet")
public class PutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("code");
        int code = Integer.parseInt(sid);

        String name_client = request.getParameter("name_client");
        String model = request.getParameter("price");

        Car car = new Car();
        car.setCode(code);
        car.setName_client(name_client);
        car.setModel(model);
        car.setColor(request.getParameter("color"));

        int status = CarRepository.update(car);

        if (status > 0) {
            response.sendRedirect("viewServlet");
        } else {
            out.println("Sorry! unable to update record");
        }
        out.close();
    }
}