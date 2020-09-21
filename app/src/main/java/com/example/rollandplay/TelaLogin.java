package com.example.rollandplay;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollandplay.conexao.Conexao;

public class TelaLogin extends AppCompatActivity {
    private Button btnLogar;
    private EditText txtEmail,txtSenha;
    Conexao con = new Conexao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        btnLogar = (Button) findViewById(R.id.btnEntrarUsuario);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        if (android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    Toast.makeText(getApplicationContext(), "PREENCHA OS CAMPOS", Toast.LENGTH_LONG).show();
                }else{

                    boolean buscaUsuario = false;
                    String nome = null;

                    try {

                        buscaUsuario = con.buscaDados(email, senha);
                        nome = con.retornaNome(email);

                    }catch (Exception ex) {

                        Toast.makeText(getApplicationContext(), "Connection Error", Toast.LENGTH_LONG).show();
                        System.out.println(ex);
                    }

                    if(buscaUsuario){
                        Toast.makeText(getApplicationContext(), "ACESSO CONCEDIDO! Usuario: "+ nome, Toast.LENGTH_LONG).show();
                        txtSenha.setText("");
                        txtEmail.setText("");
                    }else{
                        Toast.makeText(getApplicationContext(), "Acesso NEGADO!!!", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}