package com.example.car;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Logged
public class CarRepository {

    /*public static void main(String[] args) {
        getConnection();
        Employee employee = new Employee();
        employee.setName("oleg");
        employee.setEmail(" ");
        employee.setCountry(" ");
        save(employee);
    }*/

    @Logged
    public static Connection getConnection() {
        log.info("getConnection() is Ok");
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/employee";
        String user = "postgres";
        String password = "1234";

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection == null) {
                System.out.println("Failed to make connection!");
            } else {
                System.out.println("Connected to the PostgreSQL server successfully.");
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
        return connection;
    }

    @Logged
    public static int save(Car car) {
        log.info("added new data car - start: car = {}", car);
        int status = 0;
        try {
            Connection connection = CarRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into data_cars(name_client,model,color) values (?,?,?)");
            ps.setString(1, car.getName_client());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getColor());

            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        log.info("added new data car - end: status = {}", status);
        return status;
    }

    @Logged
    public static int update(Car car) {
        log.info("update data car - start: car = {}", car);
        int status = 0;

        try {
            Connection connection = CarRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("update data_cars set name_client=?,model=?,color=? where code=?");
            ps.setString(1, car.getName_client());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getColor());
            ps.setInt(4, car.getCode());

            status = ps.executeUpdate();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        log.info("update data car - end: status = {}", status);
        return status;
    }

    @Logged
    public static int delete(int code) {
        log.info("data car deleted - start: code = {}", code);
        int status = 0;

        try {
            Connection connection = CarRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("delete from data_cars where code=?");
            ps.setInt(1, code);
            status = ps.executeUpdate();

            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        log.info("data car deleted - end: status = {}", status);
        return status;
    }

    @Logged
    public static Car getCarshopByCode(int code) {
        log.info("get data car by code - start: code = {}", code);
        Car car = new Car();

        try {
            Connection connection = CarRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from data_cars where code=?");
            ps.setInt(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car.setCode(rs.getInt(1));
                car.setName_client(rs.getString(2));
                car.setModel(rs.getString(3));
                car.setColor(rs.getString(4));
            }
            connection.close();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        log.info("get data car by code - end: carshop = {}", car);
        return car;
    }

    @Logged
    public static List<Car> getAllCarshops() {
        log.info("get all data cars - start");
        List<Car> listCars = new ArrayList<>();

        try {
            Connection connection = CarRepository.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from data_cars");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Car car = new Car();

                car.setCode(rs.getInt(1));
                car.setName_client(rs.getString(2));
                car.setModel(rs.getString(3));
                car.setColor(rs.getString(4));

                listCars.add(car);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("get all data cars - end");
        return listCars;
    }
}