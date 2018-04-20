package org.brunoeleodoro.com.seriesapp.MVPVisualizarFilmes;

import android.content.Context;

import org.brunoeleodoro.com.seriesapp.Filme;

import java.util.List;

public interface MVPVisualizarFilmes {
    interface Model
    {
        public void getFilmes(String genero);
    }
    interface Presenter
    {
        public void getFilmes(String genero);

        public void setView(MVPVisualizarFilmes.View view);
        public Context getContext();

        public void error(String msg);
        public void setFilmes(List<Filme> filmes);
    }
    interface View
    {
        public void error(String msg);
        public void setFilmes(List<Filme> filmes);
    }
}
