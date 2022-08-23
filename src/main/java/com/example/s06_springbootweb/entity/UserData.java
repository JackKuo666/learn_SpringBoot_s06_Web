package com.example.s06_springbootweb.entity;

import lombok.Data;

@Data
public class UserData {
    int id;
    String name;
    String password;
    String role;
}
