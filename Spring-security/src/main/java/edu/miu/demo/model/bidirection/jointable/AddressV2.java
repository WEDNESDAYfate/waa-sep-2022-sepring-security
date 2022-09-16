package edu.miu.demo.model.bidirection.jointable;

import javax.persistence.*;

@Entity
public class AddressV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private int zip;
    private String city;

    @OneToOne
    private UserV2 userV2;
}
