package com.example.car.session;

import com.example.car.CarRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/isDeleted")
public class IsDeleted extends HttpServlet {
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//doGet

        String sid = request.getParameter("code"); //id
        int code = Integer.parseInt(sid);
        CarRepository.isDeleted(code);
        response.sendRedirect("viewServlet");






    }
}