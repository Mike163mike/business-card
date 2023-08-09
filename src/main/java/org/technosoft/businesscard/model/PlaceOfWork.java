package org.technosoft.businesscard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "places_of_work")
public class PlaceOfWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate start;
    private LocalDate finish;
    private String duration;
    private String name;
    private String city;
    private String position;
    private String description;

//    public String getDuration() {
//        Period period = null;
//        try {
//            period = Period.between(start, finish);
//        } catch (Exception e) {
//            return "неопределено";
//        }
//        return  String.format("%d года(лет) и %d месяц(а, ев)", period.getYears(), period.getMonths());
//    }
}
