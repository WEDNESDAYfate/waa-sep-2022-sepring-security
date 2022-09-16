package edu.miu.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

//    UNI-DIRECTIONAL JOIN COLUMN
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> product;
}
