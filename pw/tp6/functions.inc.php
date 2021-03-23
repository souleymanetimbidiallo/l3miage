<?php
    define("DATABASE", "programmation_web");
    define("HOST", "localhost");
    define("USER", "root");
    define("PASS", "");

    function connexion(){
        $dns = "mysql:host=".HOST.";dbname=".DATABASE.";charset=UTF8";
        $user = USER;
        $password = PASS;
        try{
            $connexion = new PDO($dns, $user, $password);
            $connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return $connexion;
        }catch(PDOException $except){
            //Lorsque la connexion a echoué;
            echo "Echec de la connexion: ".$except->getMessage();
            return false;
            exit();
        }
    }

    function secure($field){
        return htmlspecialchars(strtolower(trim($field)));
    }
?>