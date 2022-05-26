package com.example.flour_foods.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.flour_foods.R;

public class Cadastro extends AppCompatActivity {

    private Button cadastrar;
    private EditText usuario;
    private EditText senha;
    private TextView erroCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        cadastrar = findViewById(R.id.cadastrar);
        usuario = findViewById(R.id.usuario);
        senha = findViewById(R.id.senha);
        erroCadastro = findViewById(R.id.erroCadastro);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.example.flour_foods.controllers.Cadastro cadastro = new com.example.flour_foods.controllers.Cadastro();

                cadastro.cadastro(usuario.getText().toString(),senha.getText().toString(), Cadastro.this,erroCadastro);
            }
        });


    }
}