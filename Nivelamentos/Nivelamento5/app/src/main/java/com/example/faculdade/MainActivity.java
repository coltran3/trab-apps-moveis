package com.example.faculdade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] disciplinas = {"Redes", "Algoritmos", "Programacao"};
        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,layout, disciplinas);
        ListView lista = (ListView) findViewById(R.id.listView);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {

                Toast.makeText(ListaDisciplinasActivity.this, "Clicou " + posicao,

                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}