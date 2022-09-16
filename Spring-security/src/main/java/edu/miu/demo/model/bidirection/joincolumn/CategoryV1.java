package edu.miu.demo.model.bidirection.joincolumn;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CategoryV1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<ProductV1> products;
}
