package edu.miu.demo.model.unidirection.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CategoryV4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //  UNI-DIRECTIONAL
    //  Create CategoryV1 and Products mapping with Join Table
    @OneToMany
    @JoinTable(name = "join_table4",
            joinColumns = {
                    @JoinColumn(name = "category_fk", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "product_fk", referencedColumnName = "id",
                            unique = true)
            }
    )
    private List<ProductV4> products;
}
