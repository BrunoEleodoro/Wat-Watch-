package org.brunoeleodoro.com.seriesapp.MVPVisualizarFilmes;

import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.brunoeleodoro.com.seriesapp.Filme;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ModelVisualizarFilmes implements MVPVisualizarFilmes.Model{
    MVPVisualizarFilmes.Presenter presenter;

    public ModelVisualizarFilmes(MVPVisualizarFilmes.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getFilmes(String genero) {
        RequestQueue queue = Volley.newRequestQueue(presenter.getContext());
        StringRequest request = new StringRequest(Request.Method.GET, "http://api.tvmaze.com/shows?language=english", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try
                {
                    List<Filme> filmes = new ArrayList<>();

                    JSONArray array = new JSONArray(response);
                    int i = 0;
                    Log.i("script","quantidade="+array.length());
                    while(i < array.length()) {
                        JSONObject object = array.getJSONObject(i);
                        String id = object.getString("id");
                        String nome = object.getString("name");
                        String language = object.getString("language");
                        String img = object.getJSONObject("image").getString("medium");
                        String summary = object.getString("summary");
                        String genero = object.getJSONArray("genres").toString();

                        Filme filme = new Filme(id,nome,language,img,summary,genero);

                        filmes.add(filme);

                        i++;

                    }
                    presenter.setFilmes(filmes);


                }
                catch (Exception e)
                {
                    presenter.error("json errror="+e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                presenter.error("volley error="+error);
            }
        });
        queue.add(request);
    }
}
