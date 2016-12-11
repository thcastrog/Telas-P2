package com.thayna.telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela2Activity extends AppCompatActivity {


    Button progresso;
    Button cadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        progresso = (Button)findViewById(R.id.prog);
        cadastro = (Button)findViewById(R.id.cadastro);

        progresso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),Tela4Activity.class);
                startActivity(i);
            }
        });

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),Tela3Activity.class);
                startActivity(i);
            }
        });

    }
}
