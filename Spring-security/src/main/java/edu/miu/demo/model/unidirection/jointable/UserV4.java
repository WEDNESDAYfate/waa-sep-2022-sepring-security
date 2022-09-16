package edu.miu.demo.model.unidirection.jointable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserV4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

//  Create UserV1 and AddressV1 oneToOne mapping with JoinTable
    @OneToOne
    @JoinTable(name = "join_table5",
            joinColumns = {
                @JoinColumn(name = "user_fk", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "address_fk", referencedColumnName = "id",
                unique = true)
            }
    )
    private AddressV4 address;

    //  Create UserV1 and ReviewV1 mapping with Join Table
    @OneToMany
    @JoinTable(name = "join_table6",
            joinColumns = {
                    @JoinColumn(name = "user_fk", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "review_fk", referencedColumnName = "id",
                            unique = true)
            }
    )
    private List<ProductV4> products;
}