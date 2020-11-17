package com.example.professor_allocation;

public class Professor {

    private String name;
    private String courseName;
    private String cpf;
    private String urlImage;

    public Professor() {
    }

    public Professor(String name, String courseName, String cpf, String urlImage) {
        this.name = name;
        this.courseName = courseName;
        this.cpf = cpf;
        this.urlImage = urlImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return name;
    }
}
