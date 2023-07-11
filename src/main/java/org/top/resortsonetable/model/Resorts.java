package org.top.resortsonetable.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resorts_t")
@Getter
@Setter
public class Resorts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_f", length = 100, nullable = false)
    private String name;

    @Column(name = "city_f", length = 50, nullable = false)
    private String city;

    @Column(name = "country_f", length = 50, nullable = false)
    private String country;

    @Column(name = "rate_f", length = 30)
    private String rate;

}
