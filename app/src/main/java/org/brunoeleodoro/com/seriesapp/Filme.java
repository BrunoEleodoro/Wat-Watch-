package org.brunoeleodoro.com.seriesapp;

import java.io.Serializable;

public class Filme implements Serializable{
    String id;
    String nome;
    String language;
    String img;
    String summary;
    String genero;


    public Filme(String id, String nome, String language, String img, String summary, String genero) {
        this.id = id;
        this.nome = nome;
        this.language = language;
        this.img = img;
        this.summary = summary;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
