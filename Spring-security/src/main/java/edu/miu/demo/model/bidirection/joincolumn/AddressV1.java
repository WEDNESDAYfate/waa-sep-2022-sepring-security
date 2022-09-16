package edu.miu.demo.model.bidirection.joincolumn;

import javax.persistence.*;

@Entity
public class AddressV1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private int zip;
    private String city;


    //  Create UserV1 and AddressV1 oneToOne mapping with JoinColumn
    @OneToOne(mappedBy = "address")
    private UserV1 user;

}
