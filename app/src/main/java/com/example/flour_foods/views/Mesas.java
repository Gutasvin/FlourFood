package com.example.flour_foods.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.flour_foods.FazerPedido;
import com.example.flour_foods.R;
import com.example.flour_foods.controllers.MesasController;

import java.util.ArrayList;

public class Mesas extends AppCompatActivity {

    private LinearLayout mesa1;
    private LinearLayout mesa2;
    private LinearLayout mesa3;
    private LinearLayout mesa4;
    private LinearLayout mesa5;
    private LinearLayout mesa6;
    private LinearLayout mesa7;
    private LinearLayout mesa8;
    private LinearLayout mesa9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesas);

        mesa1 = findViewById(R.id.mesa1);
        mesa2 = findViewById(R.id.mesa2);
        mesa3 = findViewById(R.id.mesa3);
        mesa4 = findViewById(R.id.mesa4);
        mesa5 = findViewById(R.id.mesa5);
        mesa6 = findViewById(R.id.mesa6);
        mesa7 = findViewById(R.id.mesa7);
        mesa8 = findViewById(R.id.mesa8);
        mesa9 = findViewById(R.id.mesa9);

        Intent it = getIntent();
        ArrayList<Integer> numero_mesa = it.getIntegerArrayListExtra("numero_mesa");
        ArrayList<Integer> status = it.getIntegerArrayListExtra("status");

        int retornou = it.getIntExtra("retornou",0);

        if(status.get(0) == 1){
            mesa1.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.vermelho));
        }else{
            mesa1.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.verde));
            mesa1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Mesas.this, FazerPedido.class);
                    intent.putExtra("numerosMesa", numero_mesa.get(0));
                    intent.putExtra("statusMesa", status.get(0));
                    startActivity(intent);
                }
            });
        }
        if(status.get(1) == 1){
            mesa2.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.vermelho));
        }else{
            mesa2.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.verde));
            mesa2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Mesas.this, FazerPedido.class);
                    intent.putExtra("numerosMesa", numero_mesa.get(1));
                    intent.putExtra("statusMesa", status.get(1));
                    startActivity(intent);
                }
            });
        }
        if(status.get(2) == 1){
            mesa3.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.vermelho));
        }else{
            mesa3.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.verde));
            mesa3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Mesas.this, FazerPedido.class);
                    intent.putExtra("numerosMesa", numero_mesa.get(2));
                    intent.putExtra("statusMesa", status.get(2));
                    startActivity(intent);
                }
            });
        }
        if(status.get(3) == 1){
            mesa4.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.vermelho));
        }else{
            mesa4.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.verde));
            mesa4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Mesas.this, FazerPedido.class);
                    intent.putExtra("numerosMesa", numero_mesa.get(3));
                    intent.putExtra("statusMesa", status.get(3));
                    startActivity(intent);
                }
            });
        }
        if(status.get(4) == 1){
            mesa5.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.vermelho));
        }else{
            mesa5.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.verde));
            mesa5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Mesas.this, FazerPedido.class);
                    intent.putExtra("numerosMesa", numero_mesa.get(4));
                    intent.putExtra("statusMesa", status.get(4));
                    startActivity(intent);
                }
            });
        }
        if(status.get(5) == 1){
            mesa6.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.vermelho));
        }else{
            mesa6.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.verde));
            mesa6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Mesas.this, FazerPedido.class);
                    intent.putExtra("numerosMesa", numero_mesa.get(5));
                    intent.putExtra("statusMesa", status.get(5));
                    startActivity(intent);
                }
            });
        }
        if(status.get(6) == 1){
            mesa7.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.vermelho));
        }else{
            mesa7.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.verde));
            mesa7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Mesas.this, FazerPedido.class);
                    intent.putExtra("numerosMesa", numero_mesa.get(6));
                    intent.putExtra("statusMesa", status.get(6));
                    startActivity(intent);
                }
            });
        }
        if(status.get(7) == 1){
            mesa8.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.vermelho));
        }else{
            mesa8.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.verde));
            mesa8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Mesas.this, FazerPedido.class);
                    intent.putExtra("numerosMesa", numero_mesa.get(7));
                    intent.putExtra("statusMesa", status.get(7));
                    startActivity(intent);
                }
            });
        }
        if(status.get(8) == 1){
            mesa9.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.vermelho));
        }else{
            mesa9.setBackgroundColor(ContextCompat.getColor(Mesas.this, R.color.verde));
            mesa9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Mesas.this, FazerPedido.class);
                    intent.putExtra("numerosMesa", numero_mesa.get(8));
                    intent.putExtra("statusMesa", status.get(8));
                    startActivity(intent);
                }
            });
        }
    }
}