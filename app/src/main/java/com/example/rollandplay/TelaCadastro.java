package com.example.rollandplay;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollandplay.Controller.UsuarioController;
import com.example.rollandplay.conexao.Conexao;


public class TelaCadastro extends AppCompatActivity {
    private Button btnCadastrar;
    private EditText txtCadastraUsuario,txtCadastraEmail,txtConfirmaEmail,txtCadastraSenha,txtConfirmaSenha;
    Conexao con = new Conexao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        final UsuarioController usuarioControllerLogin = new UsuarioController();
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        txtCadastraUsuario  = (EditText) findViewById(R.id.txtCadastraUsuario);
        txtCadastraEmail = (EditText) findViewById(R.id.txtCadastraEmail);
        txtConfirmaEmail = (EditText) findViewById(R.id.txtConfirmaEmail);
        txtCadastraSenha = (EditText) findViewById(R.id.txtCadastraSenha);
        txtConfirmaSenha = (EditText) findViewById(R.id.txtConfirmaSenha);

        if (android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        btnCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String usuario = txtCadastraUsuario.getText().toString();
                String email = txtCadastraEmail.getText().toString();
                String confirmaEmail = txtConfirmaEmail.getText().toString();
                String senha = txtCadastraSenha.getText().toString();
                String confirmaSenha = txtConfirmaSenha.getText().toString();

                if (usuario.isEmpty() || email.isEmpty() || confirmaEmail.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio", Toast.LENGTH_LONG).show();
                } else {
                    boolean confirma = usuarioControllerLogin.verificaEmailSenha(email, confirmaEmail, senha, confirmaSenha);
                    boolean buscaUsuario = con.buscaDados(email,senha);
                    if (confirma == true) {
                        if(buscaUsuario == false) {
                            try {
                                // boolean add = usuarioController.adicionaBanco(usuario, email, senha);
                                boolean add = con.gravaDados(usuario, email, senha);
                                if (add) {
                                    Toast.makeText(getApplicationContext(), "CADASTRADO COM SUCESSO", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "ERRO! CADASTRO NAO EFETUADO", Toast.LENGTH_LONG).show();
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                Toast.makeText(getApplicationContext(), "TA DANDO ERRO AQUI", Toast.LENGTH_LONG).show();
                            }
                            txtCadastraUsuario.setText("");
                            txtCadastraEmail.setText("");
                            txtConfirmaEmail.setText("");
                            txtCadastraSenha.setText("");
                            txtConfirmaSenha.setText("");
                        }else {
                            Toast.makeText(getApplicationContext(), "Email ja esta cadastrado", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Verifique se seu email e senha estao corretos", Toast.LENGTH_LONG).show();
                        txtConfirmaEmail.setText("");
                        txtConfirmaSenha.setText("");
                    }
                }
            }
        });

    }
}