package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CLIENTS")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "idSeq",
            name = "ID", allocationSize = 1, initialValue = 1)
    private long id;

    @NotNull
    @Column(name= "NAME")
    private String name;
}