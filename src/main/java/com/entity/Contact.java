package com.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data   // ye getters + setters auto bana deta hai
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String message;
}