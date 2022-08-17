package com.example.car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String name_client = request.getParameter("name_client");
        String model = request.getParameter("model");
        String color = request.getParameter("color");

        Car car = new Car();

        car.setName_client(name_client);
        car.setModel(model);
        car.setColor(color);

        //out.println(employee.toString());
        //out.println(EmployeeRepository.getConnection());

        int status = CarRepository.save(car);
        //out.println(status);

        if (status > 0) {
            out.print("Record saved successfully!");
        } else {
            out.println("Sorry! unable to save record");
        }
        out.close();
    }
}