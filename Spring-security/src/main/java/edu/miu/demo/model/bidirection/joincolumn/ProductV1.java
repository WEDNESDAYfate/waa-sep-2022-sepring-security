package edu.miu.demo.model.bidirection.joincolumn;

import javax.persistence.*;

@Entity
public class ProductV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int rating;


    @ManyToOne
    private CategoryV1 category;

}
