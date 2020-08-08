package com.example.rollandplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rollandplay.Controller.AcessoController;

public class MainActivity extends AppCompatActivity {

    AcessoController acessoControllerTela;

    private Button btnCriarConta, btnEntrar, btnJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acessoControllerTela = new AcessoController();

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCriarConta = (Button) findViewById(R.id.btnCriarConta);
        btnJogar = (Button) findViewById(R.id.btnJogar);

        //Abre a tela de Cadastro
        btnCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TelaCadastro.class));
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TelaLogin.class));
            }
        });

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TelaJogar.class));
            }
        });
    }
}