package com.example.rollandplay.Model;

public class Usuario {
    //Atributos
    private String usuario;
    private String email;
    private String cEmail;
    private String senha;
    private String cSenha;

    //Construtores
    public Usuario(String usuario, String email, String senha) {
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String usuario, String email, String cEmail, String senha, String cSenha) {
        this.usuario = usuario;
        this.email = email;
        this.cEmail = cEmail;
        this.senha = senha;
        this.cSenha = cSenha;
    }

    //Getter e Setter
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getcSenha() {
        return cSenha;
    }

    public void setcSenha(String cSenha) {
        this.cSenha = cSenha;
    }
}
