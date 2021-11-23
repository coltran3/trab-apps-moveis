package com.example.aula1_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
private EditText editText = null;
private Button button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button2);

        editText.setText("Candido");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() +" vagabundo ");
                Log.i("TAG", "Botao Clicado");
            }
        });

        Log.i("Tag", "Candido vagabundo");
    }
}