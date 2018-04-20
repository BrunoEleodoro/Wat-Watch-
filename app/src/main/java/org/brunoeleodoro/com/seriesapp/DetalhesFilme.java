package org.brunoeleodoro.com.seriesapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalhesFilme extends AppCompatActivity {
    ImageView txt_img;
    TextView txt_titulo, txt_descricao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Filme filme = (Filme) getIntent().getSerializableExtra("filme");

        getWindow().setEnterTransition(new Fade());
        getWindow().setExitTransition(new Fade());

        setTitle(filme.getNome());
        txt_descricao = findViewById(R.id.txt_descricao);
        txt_img = findViewById(R.id.txt_img);

        txt_descricao.setText(Html.fromHtml(filme.getSummary()));
        Picasso.get().load(filme.getImg()).into(txt_img);
    }
}
