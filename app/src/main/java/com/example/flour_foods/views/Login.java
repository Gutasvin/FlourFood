package com.example.flour_foods.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flour_foods.R;
import com.example.flour_foods.controllers.Autenticacao;
import com.example.flour_foods.controllers.Produtos;

public class Login extends AppCompatActivity {

    private TextView erroAut;
    private EditText usuario;
    private EditText senha;
    private Button logar;
    private Button telaRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);
        logar = findViewById(R.id.logar);
        erroAut = findViewById(R.id.erroAut);
        telaRegistro = findViewById(R.id.telaRegistro);

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Autenticacao autenticacao = new Autenticacao();

                autenticacao.auth(usuario.getText().toString(),senha.getText().toString(), Login.this,erroAut);

            }
        });

        telaRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Login.this, Cadastro.class);
                Login.this.startActivity(it);
            }
        });
    }
}
