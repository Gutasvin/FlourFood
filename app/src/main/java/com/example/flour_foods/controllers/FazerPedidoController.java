package com.example.flour_foods.controllers;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.flour_foods.views.Home;
import com.example.flour_foods.views.Mesas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class FazerPedidoController {

    public void statusMesas(int numero_mesa,int status, Context context) {
        String URL = "http://18.228.212.154:3000/mesas";

            try {
                JSONObject json = new JSONObject();
                json.put("numero_mesa", numero_mesa);
                json.put("status", status);
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.PATCH, URL, json,
                        response -> {
                            try {
                                JSONObject jsonObject = response.getJSONObject("mensagem");
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
            } catch (JSONException ignored) {
            }
        }



}
