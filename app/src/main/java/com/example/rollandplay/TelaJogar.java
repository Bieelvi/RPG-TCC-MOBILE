package com.example.rollandplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaJogar extends AppCompatActivity {

    private Button btnEscolherPersonagem, btnEscolherMestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogar);

        btnEscolherMestre = (Button) findViewById(R.id.btnEscolherMestre);
        btnEscolherPersonagem = (Button) findViewById(R.id.btnEscolherPersonagem);

        btnEscolherMestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaJogar.this,CriandoSala.class));
            }
        });

        btnEscolherPersonagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaJogar.this,Personagem.class));
            }
        });

    }
}