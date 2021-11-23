package com.example.aula3mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aula3mobile.R;

public class MainActivity extends AppCompatActivity {
    private TextView textView = null;
    private Button button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(view ->{
            String oimundo = getResources().getString(R.string.hello_world);
            if(textView.getText().toString() .equals(oimundo)) {
                textView.setText(getResources().getString(R.string.mudado));
            } else {
                textView.setText(oimundo);
            }


        });

    }
}