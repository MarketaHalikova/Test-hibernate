package com.marketahalikova.hibernatetest.model;


import javax.persistence.*;

@Entity
public class Triplet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "triplet_id")
    private Long id;

    @Column(name = "triplet_name")
    private String name;

    public Triplet() {
    }

    public Triplet(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}