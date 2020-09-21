<?php
  //Conexão ao BD
   $conexao = new PDO("mysql:host=143.106.241.3;dbname=cl19457","cl19457","cl*25052004");

    // ativando o depurador de erros
   $conexao->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

   $email = $_GET['email'];
   $senha = $_GET['senha'];

   $sql = $conexao->prepare("SELECT email FROM Usuario WHERE email = ? AND senha = ?");
   $sql->bindValue(1, $email);
   $sql->bindValue(2, $senha);
   $sql->execute();
   
   $retorno = false;
   $controle = $sql->rowCount();

    if($controle == 1){
    $retorno = true;
    echo "verdade";

   }else{
    $retorno = false;
    echo "naoverdade";

   }




?>