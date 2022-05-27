package com.example.flour_foods.controllers;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.Request;
import com.android.volley.toolbox.Volley;
import com.example.flour_foods.views.Login;
import com.example.flour_foods.views.Mesas;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MesasController {

    public void buscarMesas(Context context) {
        String URL = "http://18.228.212.154:3000/mesas";

        JSONObject json = new JSONObject();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, json,
                response -> {

                    try {
                        JSONObject jsonObject = response.getJSONObject("response");
                        JSONArray msg = jsonObject.getJSONArray("mesas");

                        ArrayList<Integer> numeroMesas = new ArrayList<>();
                        ArrayList<Integer> status = new ArrayList<>();

                        for (int i = 0; i < msg.length(); i++) {
                            numeroMesas.add(msg.getJSONObject(i).getInt("numero_mesa"));
                            status.add(msg.getJSONObject(i).getInt("status"));
                        }

                        Intent it = new Intent(context, Mesas.class);
                        it.putIntegerArrayListExtra("numero_mesa", numeroMesas);
                        it.putIntegerArrayListExtra("status", status);
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