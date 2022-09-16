package edu.miu.demo.model.bidirection.joincolumn;

import javax.persistence.*;

@Entity
public class ReviewV1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    //  Create UserV1 and review oneToOne mapping with JoinColumn
    @ManyToOne
    private UserV1 user;
}
