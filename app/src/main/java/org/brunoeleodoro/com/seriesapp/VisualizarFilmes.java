package org.brunoeleodoro.com.seriesapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import org.brunoeleodoro.com.seriesapp.MVPVisualizarFilmes.MVPVisualizarFilmes;
import org.brunoeleodoro.com.seriesapp.MVPVisualizarFilmes.PresenterVisualizarFilmes;
import org.brunoeleodoro.com.seriesapp.adapters.FilmesAdapter;

import java.util.List;

public class VisualizarFilmes extends AppCompatActivity implements MVPVisualizarFilmes.View{
    RecyclerView recyclerView;
    MVPVisualizarFilmes.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_filmes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);

        presenter = new PresenterVisualizarFilmes();
        presenter.setView(this);
        presenter.getFilmes("dsadsafdsa");

    }

    @Override
    public void error(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFilmes(List<Filme> filmes) {
        FilmesAdapter adapter = new FilmesAdapter(this,filmes);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
