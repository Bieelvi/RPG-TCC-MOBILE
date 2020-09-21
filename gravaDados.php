<?php
	//Conexão ao BD
   $conexao = new PDO("mysql:host=143.106.241.3;dbname=cl19457","cl19457","cl*25052004");
   
   // ativando o depurador de erros
   $conexao->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

   $usuario = $_GET['usuario'];
   $email = $_GET['email'];
   $senha = $_GET['senha'];

  // $usuario = 'gubi';
   //$email = 'gubi';
  // $senha ='gubi';

   $sql = $conexao->prepare("SELECT nome FROM Usuario WHERE email = ?");
   $sql->bindValue(1, $email);
   $sql->execute();
   $retorno = false;
   $controle = $sql->rowCount();

   if($controle > 0){
   	$retorno = true;
   }else{
               $sql = $conexao->prepare("INSERT INTO Usuario (nome, email, senha) VALUES (?, ?, ?)");
   				$sql->bindValue(1, $usuario, PDO::PARAM_STR);
					$sql->bindValue(2, $email, PDO::PARAM_STR);
               $sql->bindValue(3, $senha, PDO::PARAM_STR);
	}
	
	$sql->execute();
?>