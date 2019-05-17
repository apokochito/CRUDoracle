package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity implements Serializable {
    // "clients_seq" is Oracle sequence name.

    @Id @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
    strategy = "uuid")
    @NotNull
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "BRAND")
    private String brand;

    @NotNull
    @Column(name= "QUANTITY")
    private int quantity;
}