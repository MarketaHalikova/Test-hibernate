package com.marketahalikova.hibernatetest.model;

import javax.persistence.*;

@Entity
public class Font {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private Long id;
    @Column(name = "font_name", nullable = false)
    private String fontName;
    @Column(name = "project_id")
    private Long projectId;

    public Font() {
    }

    public Font(String fontName) {
        this.fontName = fontName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "Font{" +
                "id=" + id +
                ", fontName='" + fontName + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
