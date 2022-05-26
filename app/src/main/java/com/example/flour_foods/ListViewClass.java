package com.example.flour_foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListViewClass extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aticity_listview);

        listView = findViewById(R.id.listView);



        Intent it = getIntent();
        ArrayList<String> produtoNome = it.getStringArrayListExtra("produtosNome");
        ArrayList<String> produtoPreco = it.getStringArrayListExtra("produtosPreco");
        ArrayList<String> produtoId = it.getStringArrayListExtra("produtosId");
        int[] ids = { android.R.id.text1, android.R.id.text2 };


        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_2, produtoNome);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, produtoNome) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(produtoNome.get(position));
                text2.setText(produtoPreco.get(position));
                return view;
            }
        };
        listView.setAdapter(adapter);

    }

}