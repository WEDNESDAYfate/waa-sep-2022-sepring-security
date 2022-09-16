package edu.miu.demo.model.unidirection.joincolumn;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CategoryV3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //    UNI-DIRECTIONAL
    @OneToMany
    @JoinColumn(name = "id_category")
    private List<ProductV3> product;
}
