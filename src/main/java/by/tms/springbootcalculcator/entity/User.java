package by.tms.springbootcalculcator.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private String name;
    private String username;
    private String password;
    private LocalDate registred;
}
