package edu.miu.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

//  Create UserV1 and AddressV1 mapping with Join Column
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

//  Create UserV1 and AddressV1 mapping with Join Column
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Review> review;
}
