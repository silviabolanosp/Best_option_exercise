package com.example.dhl.entity;

import com.example.dhl.entity.enums.CAPACITY;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Machine")
public class Machine {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private CAPACITY capacity;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="output_id",referencedColumnName = "id")
    private Output output;
    @Transient
    private Integer quantity;

    public void addQuantity(){
        quantity++;
    }

}
