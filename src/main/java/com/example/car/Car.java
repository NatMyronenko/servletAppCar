package com.example.car;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Car {

    private int code;
    private String name_client;
    private String model;
    private String color;
    private Boolean isDeleted = Boolean.FALSE;
    private String date_order;

}