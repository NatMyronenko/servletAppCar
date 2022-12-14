package com.example.car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

      //List<Car> list = CarRepository.getAllCars();
      // List<Car> list = CarRepository.getCarByCode();
        List<Car> list = CarRepository.showDeletedCar();


        for (Car car : list) {
            out.print(car);
        }
        out.close();
    }
}