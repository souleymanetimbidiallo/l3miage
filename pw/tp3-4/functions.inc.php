 <?php
    define("DB_HOST", "localhost");
    define("DATABASE", "programmation_web");
    define("DB_USER", "root");
    define("DB_PASSWORD", "");

    function PDOConnection(){
        try{
            /*Connexion à la BD */
            $connection = new PDO("mysql:host=".DB_HOST.";dbname=".DATABASE, DB_USER, DB_PASSWORD);
            $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return $connection;
        }catch(PDOException $e){
            echo 'Echec de la connexion: '.$e->getMessage();
        }
    }

    function formExist($field){
        if(isset($field) && !empty($field)){
            return $field;
        }
    }