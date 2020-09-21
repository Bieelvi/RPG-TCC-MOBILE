package com.example.rollandplay.Controller;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollandplay.Model.DAO.UsuarioDAO;

import java.sql.SQLException;


public class UsuarioController extends AppCompatActivity {

    UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

    public boolean adicionaBanco(String usuario, String email, String senha) throws SQLException {
        boolean add = false;
        add = usuarioDAO.inserirUsuario(usuario, email, senha);
        return add;
    }


    //METODO QUE RECEBE COMO PARAMETRO EMAIL(CONF EMAIL) E SENHA(CONF) E CONFERE PARA VER SE ESTA CORRETO
    public boolean verificaEmailSenha(String email, String cEmail, String senha, String cSenha){
        boolean confirmado = false;

        if(email.equals(cEmail) && senha.equals(cSenha)){
            confirmado = true;
        }
        return confirmado;
    }

}
