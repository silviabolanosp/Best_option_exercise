package com.example.dhl.entity;

import com.example.dhl.entity.enums.CAPACITY;
import com.example.dhl.entity.enums.REGION;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Output")
public class Output {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private REGION region;

    @Column(nullable = false)
    private double totalCosts;

    @Column(nullable = false)
    @OneToMany(mappedBy="output", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    private List<Machine> machines;

    public static double calculateRatio(CAPACITY type, double money){
        return money/type.units;
    }
}
