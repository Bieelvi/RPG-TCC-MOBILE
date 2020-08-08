package com.example.rollandplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rollandplay.Model.EntrandoSala;

public class Personagem extends AppCompatActivity {

    private Button btnEntrarSalaPersonagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagem);

        btnEntrarSalaPersonagem = (Button) findViewById(R.id.btnEntrarSalaPersonagem);
        btnEntrarSalaPersonagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEntrarSala();
            }
        });
    }

    public void openEntrarSala(){
        EntrandoSala entrandoSala = new EntrandoSala();
        entrandoSala.show(getSupportFragmentManager(),"Entrando Sala");

    }

}