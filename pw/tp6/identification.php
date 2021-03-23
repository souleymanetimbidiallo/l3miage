<?php
    include("functions.inc.php");
    session_start();
    $_SESSION['cpt'] = 3;
    $ref = (isset($_SERVER['HTTP_REFERER']) ? $_SERVER['HTTP_REFERER'] : '');
    if($ref == "http://localhost/l3miage/pw/tp6/index.php" && $essai != 0){
        $connexion = connexion();
        if (isset($_POST['login']) && !empty($_POST['login']) && isset($_POST['pwd']) && !empty($_POST['pwd'])){
            $sql = "SELECT * FROM user WHERE login = :login and mdp = :mdp";
    
            $select = $connexion->prepare($sql);
            $select->bindParam(":login", $login);
            $select->bindParam(":mdp", $mdp);

            $login = secure($_POST['login']);
            $mdp = md5(secure($_POST['pwd']));
            
            $select->execute();
            if($select->rowCount() != 0){
                $_SESSION['login'] = $login;
                header("Location: accueil.php");
            }else{
                header("Location: index.php");
            }
        }
    }else{
        header("Location: index.php");
    }
?>
