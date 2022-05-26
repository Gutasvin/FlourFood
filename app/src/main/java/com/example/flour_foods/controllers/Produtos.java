package com.example.flour_foods.controllers;

import android.content.Context;
import android.content.Intent;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.flour_foods.Produto;
import com.example.flour_foods.ListViewClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Produtos {

    public void produtos(Context context) {
        String URL = "http://18.228.212.154:3000/produtos";

        JSONObject json = new JSONObject();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, json,
                response -> {
                    try {
                        JSONObject jsonObject = response.getJSONObject("response");
                        JSONArray msg = jsonObject.getJSONArray("produtos");

                        ArrayList<String> produtoNome = new ArrayList<>();
                        ArrayList<String> produtoPreco = new ArrayList<>();
                        ArrayList<String> produtoId = new ArrayList<>();

                        for(int i=0; i< msg.length(); i++){

                           produtoNome.add(msg.getJSONObject(i).getString("nome"));
                            produtoPreco.add(msg.getJSONObject(i).getString("preco"));
                           produtoId.add(msg.getJSONObject(i).getString("id_produto"));
                        }

                        Intent it = new Intent(context, ListViewClass.class);
                        it.putStringArrayListExtra("produtosNome", produtoNome);
                        it.putStringArrayListExtra("produtosPreco", produtoPreco);
                        it.putStringArrayListExtra("produtosId", produtoId);
                        context.startActivity(it);

                    } catch (JSONException e) {
                    }

                },
                error -> {
                    NetworkResponse res = error.networkResponse;
                    try {
                        String msg = new String(res.data, StandardCharsets.UTF_8);
                        JSONObject jsonObject = new JSONObject(msg);
                        msg = jsonObject.getString("mensagem");
                    } catch (JSONException e) {
                    }

                });
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }


}
