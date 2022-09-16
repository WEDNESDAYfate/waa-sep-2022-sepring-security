package edu.miu.demo.model.bidirection.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CategoryV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //  Create CategoryV1 and Products mapping with Join Table
    @OneToMany
    @JoinTable(name = "join_table1",
            joinColumns = {
                    @JoinColumn(name = "category_fk", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "product_fk", referencedColumnName = "id",
                            unique = true)
            }
    )
    private List<ProductV2> products;
}
