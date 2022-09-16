package edu.miu.demo.model.bidirection.jointable;

import javax.persistence.*;

@Entity
public class ReviewV2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    @ManyToOne
    private UserV2 userV2;
}
