package org.brunoeleodoro.com.seriesapp.MVPVisualizarFilmes;

import android.content.Context;

import org.brunoeleodoro.com.seriesapp.Filme;

import java.util.List;

public class PresenterVisualizarFilmes implements MVPVisualizarFilmes.Presenter {
    MVPVisualizarFilmes.View view;
    MVPVisualizarFilmes.Model model;

    public PresenterVisualizarFilmes() {
        model = new ModelVisualizarFilmes(this);
    }

    @Override
    public void getFilmes(String genero) {
        model.getFilmes(genero);
    }

    @Override
    public void setView(MVPVisualizarFilmes.View view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return (Context) view;
    }

    @Override
    public void error(String msg) {
        view.error(msg);
    }

    @Override
    public void setFilmes(List<Filme> filmes) {
        view.setFilmes(filmes);
    }
}
