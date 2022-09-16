package edu.miu.demo.model.bidirection.jointable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

//  Create UserV1 and AddressV1 oneToOne mapping with JoinTable
    @OneToOne
    @JoinTable(name = "join_table2",
            joinColumns = {
                @JoinColumn(name = "user_fk", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "address_fk", referencedColumnName = "id",
                unique = true)
            }
    )
    private AddressV2 address;

    //  Create UserV1 and ReviewV1 mapping with Join Table
    @OneToMany
    @JoinTable(name = "join_table3",
            joinColumns = {
                    @JoinColumn(name = "user_fk", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "review_fk", referencedColumnName = "id",
                            unique = true)
            }
    )
    private List<ReviewV2> review;
}