package org.technosoft.businesscard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String middleName;
    private String lastName;
    private LocalDate birthday;
    private String gender;
    private String phone;
    private String email;
    private String city;
    private String specialization;
    private String education;
    private String languages;
    private String skills;
    private String auto;
    private String additionalInformation;
    private String hobby;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PlaceOfWork> placeOfWork;
}
