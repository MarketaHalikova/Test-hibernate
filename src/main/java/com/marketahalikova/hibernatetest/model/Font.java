package com.marketahalikova.hibernatetest.model;

public class Font {

    private Long id;
    private String fontName;
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
