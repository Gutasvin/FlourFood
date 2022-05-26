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

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class Autenticacao {



    public void auth(String usuario, String senha, Context context, TextView erro) {
        String URL = "http://18.228.212.154:3000/usuarios/login";

        if (usuario.isEmpty() || senha.isEmpty()) {
            erro.setText("Campos Obrigatórios!");
        } else {
            try {
                JSONObject json = new JSONObject();
                json.put("usuario", usuario);
                json.put("senha", senha);
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URL, json,
                        response -> {
                            try {
                                JSONObject jsonObject = response.getJSONObject("response");
                                String msg = jsonObject.getString("token");

                                Intent it = new Intent(context, Home.class);
                                it.putExtra("user",usuario);
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
                                erro.setText("Usuario e/ou senha incorretas!");
                            } catch (JSONException e) {
                            }

                        });
                RequestQueue queue = Volley.newRequestQueue(context);
                queue.add(request);
            } catch (JSONException ignored) {
            }
        }

    }
}
