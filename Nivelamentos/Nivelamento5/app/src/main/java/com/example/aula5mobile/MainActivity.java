package com.example.aula5mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aula5mobile.models.DisciplinaDAO;
import com.example.aula5mobile.models.DisciplinaValue;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista=null;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
//        String[] disciplinas = {"Redes", "Algoritmos", "Programacao"};
//
//        int layout = android.R.layout.simple_list_item_1;
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout, disciplinas);
//
//        ListView lista = (ListView) findViewById(R.id.listView);
//        lista.setAdapter(adapter);

//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> adapter, View view, int posicao, long id) {
//                Toast.makeText(MainActivity.this, "Clicou " + posicao, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            public boolean onItemLongClick(AdapterView<?> adapter, View view, int posicao, long id) {
//                Toast.makeText( MainActivity.this,
//                        adapter.getItemAtPosition(posicao).toString(),
//                        Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int layout = android.R.layout.simple_list_item_1;

        DisciplinaDAO dao = new DisciplinaDAO(this);

        ArrayList<DisciplinaValue> disciplinas = (ArrayList<DisciplinaValue>) new ArrayList(dao.getLista());

        dao.close();
        ArrayAdapter<DisciplinaValue> adapter = new ArrayAdapter<DisciplinaValue>(this, layout, disciplinas);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DisciplinaDAO dao = new DisciplinaDAO(this);
        ArrayList<DisciplinaValue> disciplinas = new ArrayList(dao.getLista());

        dao.close();
        int layout = android.R.layout.simple_list_item_1;

        ArrayAdapter<DisciplinaValue> adapter = new ArrayAdapter<DisciplinaValue>(this, layout, disciplinas);

        if(!adapter.isEmpty()) {
            lista.setAdapter(adapter);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_new) {
            Intent intent = new Intent(this, DisciplinaActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}