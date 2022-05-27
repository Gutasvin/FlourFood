package com.example.flour_foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.flour_foods.controllers.FazerPedidoController;
import com.example.flour_foods.views.Home;
import com.example.flour_foods.views.Mesas;

public class FazerPedido extends AppCompatActivity {

    private TextView mesaTal;
    private TextView pedidoStatus;
    private Button fazerPedido;
    private Button voltar;
    private Button terminarDeComer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_pedido);

        mesaTal = findViewById(R.id.mesaTal);
        fazerPedido = findViewById(R.id.fazerPedido);
        pedidoStatus = findViewById(R.id.pedidoStatus);
        voltar = findViewById(R.id.voltar);
        terminarDeComer = findViewById(R.id.terminarDeComer);

        Intent it = getIntent();
        int numeroMesa = it.getIntExtra("numerosMesa",2);
        int numeroMesa1 = it.getIntExtra("numerosMesas",2);

        mesaTal.setText("Mesa: "+ numeroMesa);



            fazerPedido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FazerPedidoController fpc = new FazerPedidoController();

                    fpc.statusMesas(numeroMesa,1,FazerPedido.this);

                    pedidoStatus.setText("Pedido feito com Sucesso!");
                }
            });


        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FazerPedidoController fpc = new FazerPedidoController();

                //Intent it = new Intent(FazerPedido.this, Home.class);
                //startActivity(it);

                FazerPedidoController fpc = new FazerPedidoController();

                Intent it = new Intent(FazerPedido.this, Mesas.class);
                it.putExtra("retornou",numeroMesa);
                startActivity(it);
            }
        });




        terminarDeComer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FazerPedidoController fpc = new FazerPedidoController();

                fpc.statusMesas(numeroMesa,0,FazerPedido.this);

                Intent it = new Intent(FazerPedido.this, Mesas.class);
                it.putExtra("retornou",numeroMesa);
                startActivity(it);
            }
        });

    }
}