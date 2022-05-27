package com.example.flour_foods.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flour_foods.ListViewClass;
import com.example.flour_foods.R;
import com.example.flour_foods.controllers.MesasController;
import com.example.flour_foods.controllers.Produtos;

public class Home extends AppCompatActivity {

    private TextView user;
    private LinearLayout cardapio;
    private TextView sair;
    private LinearLayout reservas;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        sair = findViewById(R.id.sair);
        user = findViewById(R.id.user);
        cardapio = findViewById(R.id.cardapio);
        reservas = findViewById(R.id.reservas);
        listView = findViewById(R.id.listView);

        Intent it = getIntent();
        String pega = it.getStringExtra("user");
        user.setText(pega);


        cardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, Cardapio.class);
                startActivity(it);
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, Login.class);
                startActivity(it);
            }
        });

        reservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MesasController mc = new MesasController();

                mc.buscarMesas(Home.this);
            }
        });
    }
}
