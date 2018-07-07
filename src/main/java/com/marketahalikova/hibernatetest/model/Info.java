package com.marketahalikova.hibernatetest.model;

import javax.persistence.*;

@Entity
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String txt;
    @OneToOne (mappedBy = "info")
    private Project project;

    public Info(String txt) {
        this.txt = txt;
    }

    public Info() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", txt='" + txt + '\'' +
                '}';
    }
}
