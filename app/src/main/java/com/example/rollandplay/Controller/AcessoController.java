package com.example.rollandplay.Controller;
import android.os.Parcelable;

import com.example.rollandplay.Model.Usuario;

import java.util.ArrayList;
public class AcessoController {
    private final ArrayList<Usuario> bancoDadosArray;

    //CONTRUTOR QUE INICIA COM ALGUNS USUARIOS NA ARRAY, PARA TESTES
    public AcessoController() {
        bancoDadosArray = new ArrayList();

        Usuario j1 = new Usuario("Edilson", "edilsonlinefilho@gmail.com", "123456");
        Usuario j2 = new Usuario("Gub Well", "gubirosin@gmail.com", "123456");
        Usuario j3 = new Usuario("Bieelvi", "bieelvi@gmail.com", "123456");
        Usuario j4 = new Usuario("uu", "uu", "uu");

        bancoDadosArray.add(j1);
        bancoDadosArray.add(j2);
        bancoDadosArray.add(j3);
        bancoDadosArray.add(j4);
    }

    //METODO QUE RECEBE COMO PARAMETRO EMAIL(CONF EMAIL) E SENHA(CONF) E CONFERE PARA VER SE ESTA CORRETO
    public boolean verificaEmailSenha(String email, String cEmail, String senha, String cSenha){
        boolean confirmado = false;

        if(email.equals(cEmail) && senha.equals(cSenha)){
            confirmado = true;
        }

        return confirmado;
    }

    //METODO QUE RECEBE COMO PARAMETRO USUARIO, EMAIL E SENHA E ADICIONA NA ARRAY
    public void adicionaArray(String usuario, String email, String senha){
        Usuario j = new Usuario(usuario, email, senha);

        bancoDadosArray.add(j);
    }



    public boolean verificaUsuarioPeloEmail(String email){
        boolean existe = false;

        for(Usuario j: bancoDadosArray){

            if(j.getEmail().equals(email)){
                existe = true;
            }
        }

        return existe;
    }

    //METODO QUE RECEBE COMO PARAMENTRO USUARIO E SENHA. E CONFERE SE ESTA NO ARRAY CRIADO
    public boolean verificaAcesso(String email, String senha){
        boolean acesso = false;

        for(Usuario j: bancoDadosArray){
            String e = j.getEmail();
            String s = j.getSenha();

            if(e.equals(email) && s.equals(senha)){
                acesso = true;
            }
        }
        return acesso;
    }
}
