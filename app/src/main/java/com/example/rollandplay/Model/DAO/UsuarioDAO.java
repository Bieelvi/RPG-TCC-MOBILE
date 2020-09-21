package com.example.rollandplay.Model.DAO;
import com.example.rollandplay.conexao.Conexao;

import java.sql.SQLException;

public class UsuarioDAO {
    Conexao conec = new Conexao();

    public boolean inserirUsuario(String usuario, String email, String senha) throws SQLException{
        boolean add = false;
        add =  conec.gravaDados(usuario,email,senha);
        return add;
    }

}
