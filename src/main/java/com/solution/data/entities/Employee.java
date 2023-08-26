package com.solution.data.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table( name ="employee")
@Builder(toBuilder = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private int age;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    private Long salary;

    @Override
    public String toString() {
        return name + " " + email + " " + phone + " " + address + " " + age + " " + city + " " + state + " " + country + " " + zipCode;
    }
}
