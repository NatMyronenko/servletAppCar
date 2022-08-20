//package com.example.car.session;
//
//import com.example.car.Car;
//import com.example.car.CarRepository;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet("/saveServletColor")
//
//public class SaveServletColor extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("UTF-8");
//
//        PrintWriter out = response.getWriter();
//
//        String color = request.getParameter("color");
//
//        Car car = new Car();
//
//        car.setColor(color);
//
//
//        int status = CarRepository.saveOrderIfColor(car);
//
//        if (status > 0) {
//            out.print("Record saved successfully!");
//        } else {
//            out.println("Sorry! unable to save record");
//        }
//        out.close();
//    }
//}
//
