package com.marketahalikova.hibernatetest.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private Long id;
    @Column(name = "project_name", nullable = false, unique = true, length = 200)
    private String name;
    private String description;
    @Column(name = "url", nullable = false, length = 500)
    private String gitURL;

//    private List<Font> listFonts;
//
//    public Project() {
//        listFonts = new ArrayList<>();
//    }

    public Project(String name, String gitURL) {
//        this();
        this.name = name;
        this.gitURL = gitURL;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGitURL() {
        return gitURL;
    }

    public void setGitURL(String gitURL) {
        this.gitURL = gitURL;
    }

//    public List<Font> getListFonts() {
//        return listFonts;
//    }
//
//    public void setListFonts(List<Font> listFonts) {
//        this.listFonts = listFonts;
//    }
//
//    @Override
//    public String toString() {
//        return "Project{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", gitURL='" + gitURL + '\'' +
//                ", listFonts=" + listFonts +
//                '}';
//    }
}
