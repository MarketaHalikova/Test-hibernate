package com.marketahalikova.hibernatetest.model;

import org.hibernate.annotations.Cascade;

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
    // bez fetchType eager je type Lazy, pri tom se nenacte list fontu pokud si o nej pred ukoncenim session nerekneme
    @OneToMany (mappedBy = "project", fetch = FetchType.EAGER)
    private List<Font> listFonts;

    @OneToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Maven maven;

    @OneToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Info info;


    public Project() {
        listFonts = new ArrayList<>();
    }

    public Project(String name, String gitURL) {
        this();
        this.name = name;
        this.gitURL = gitURL;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
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

    public List<Font> getListFonts() {
        return listFonts;
    }

    public void setListFonts(List<Font> listFonts) {
        this.listFonts = listFonts;
    }

    public Maven getMaven() {
        return maven;
    }

    public void setMaven(Maven maven) {
        this.maven = maven;
    }

    public void addFont(Font font){
        listFonts.add(font);
        font.setProject(this);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", gitURL='" + gitURL + '\'' +
                ", listFonts=" + listFonts +
                ", maven=" + maven +
                ", info=" + info +
                '}';
    }
}
