package com.example.aula2mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private Button button = null;
private EditText editText = null;
private SharedPreferences nyPrefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editTextTextPersonName2);

        nyPrefs = getSharedPreferences("nyPrefs", MODE_PRIVATE);
        String nome =  nyPrefs.getString("nome", "");

    if (nome !=null){
        editText.setText(nome);
    }

button.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor ePrefs = nyPrefs.edit();
        ePrefs.putString("nome", MainActivity.this.editText.getText().toString());
        ePrefs.commit();
    }
});


    }
}