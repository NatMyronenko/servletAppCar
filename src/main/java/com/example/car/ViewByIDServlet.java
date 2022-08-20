package com.example.car;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/viewByIDServlet")
public class ViewByIDServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("code");
        int code = Integer.parseInt(sid);

        Car car = CarRepository.getCarByCode(code);

        out.print(car);
        out.close();
    }
}