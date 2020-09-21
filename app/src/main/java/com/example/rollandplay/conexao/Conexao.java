package com.example.rollandplay.conexao;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

//jdbc:mysql://143.106.241.3:3306
//jdbc:jtds://sqlserver:143.106.241.3
//com.mysql.cj.jdbc.Driver
//net.sourceforge.jtds.jdbc.Driver


public class Conexao {
    /*
    public static Connection conectar() throws SQLException{
        Connection conn = null;
        try{
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("com.mysql.jdbc:com.springsource.com.mysql.jdbc:5.1.6").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://143.106.241.3:3306/cl19457","cl19457","cl*25052004");
        }catch(SQLException e){
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return conn;
    }
*/


    public boolean gravaDados(String usuario, String email, String senha) {
        boolean teste =false;
        try{
            // Abrir um client HTTP
            DefaultHttpClient clienteHTTP = new DefaultHttpClient();

            //Requisicao
            HttpGet requisicaoHTTP = new HttpGet(
                    "http://192.168.2.140/gravaDados.php" +
                            "?usuario=" + usuario +
                            "&email=" + email +
                            "&senha=" + senha
            );
            clienteHTTP.execute(requisicaoHTTP);

            // pegar a resposta do HTTP
            //  HttpResponse resposta = clienteHTTP.execute(requisicaoHTTP);

            teste = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return teste;
    }

    public boolean buscaDados(String email, String senha){

        boolean passou = false;
        try{
            // Abrir um client HTTP
            DefaultHttpClient clienteHTTP = new DefaultHttpClient();

            //Requisicao
            HttpGet requisicaoHTTP = new HttpGet(
                    "http://192.168.2.140/buscaDados.php" +
                            "?email=" + email +
                            "&senha=" + senha
            );

            // pegar a resposta do HTTP
            HttpResponse resposta = clienteHTTP.execute(requisicaoHTTP);

            //LER A PAGINA HTTP
            BufferedReader leitorHTTP = new BufferedReader(new InputStreamReader(resposta.getEntity().getContent(), StandardCharsets.UTF_8));
            String cadastrado;
            cadastrado = leitorHTTP.readLine();

            if (cadastrado.equals("verdade")){
                passou=true;
            }
        }catch(Exception e){
            e.printStackTrace();

        }
        return passou;
    }


    public String retornaNome(String email){
        String nome = null;
        try {
            // Abrir um client HTTP
            DefaultHttpClient clienteHTTP = new DefaultHttpClient();

            //Requisicao
            HttpGet requisicaoHTTP = new HttpGet(
                    "http://192.168.2.140/buscaNome.php" +
                            "?email=" + email
            );

            // pegar a resposta do HTTP
            HttpResponse resposta = clienteHTTP.execute(requisicaoHTTP);

            //LER A PAGINA HTTP
            BufferedReader leitorHTTP = new BufferedReader(new InputStreamReader(resposta.getEntity().getContent(), StandardCharsets.UTF_8));
            String nome1;
            nome1 = leitorHTTP.readLine();
            nome = nome1;
        }catch (Exception e){
            e.printStackTrace();
        }

        return nome;
    }




}
