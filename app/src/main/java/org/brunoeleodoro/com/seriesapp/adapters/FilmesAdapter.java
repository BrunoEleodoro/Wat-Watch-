package org.brunoeleodoro.com.seriesapp.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.brunoeleodoro.com.seriesapp.DetalhesFilme;
import org.brunoeleodoro.com.seriesapp.Filme;
import org.brunoeleodoro.com.seriesapp.R;

import java.util.ArrayList;
import java.util.List;

public class FilmesAdapter  extends RecyclerView.Adapter<FilmesAdapter.FilmesHolder>{
    LayoutInflater inflater;
    List<Filme> filmes = new ArrayList<>();
    Context context;
    public FilmesAdapter(Context context, List<Filme> filmes) {
        this.context = context;
        this.filmes = filmes;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FilmesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilmesHolder(inflater.inflate(R.layout.linha_filmes,null));
    }

    @Override
    public void onBindViewHolder(@NonNull final FilmesHolder holder, int position) {
        final Filme filme = filmes.get(position);
        holder.txt_nome.setText(filme.getNome());
        holder.txt_genero.setText(filme.getGenero());
        Picasso.get().load(filme.getImg()).into(holder.txt_img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Intent intent = new Intent(context, DetalhesFilme.class);
                    intent.putExtra("filme",filme);
                    holder.txt_img.setTransitionName("example_transition");
                    Pair<View, String> pair1 = Pair.create((View) holder.txt_img, holder.txt_img.getTransitionName());
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, pair1);
                    context.startActivity(intent, optionsCompat.toBundle());
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    class FilmesHolder extends RecyclerView.ViewHolder{
        ImageView txt_img;
        TextView txt_nome;
        TextView txt_genero;
        public FilmesHolder(View itemView) {
            super(itemView);
            txt_img = itemView.findViewById(R.id.txt_img);
            txt_nome = itemView.findViewById(R.id.txt_nome);
            txt_genero = itemView.findViewById(R.id.txt_genero);
        }
    }
}
