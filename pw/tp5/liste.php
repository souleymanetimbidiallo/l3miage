<?php
    include("functions.inc.php");
    $connexion = connexion();

    $reponse = $connexion->query("SELECT * FROM serv");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exercice 2</title>
</head>
<body>
    
    <ul>
        <?php 
            while($service = $reponse->fetch()){
                echo '<li>'.$service['id'].' - '.$service['nom'].'</li>';
            }
        ?>
    </ul>   

    <ul>
        <?php 
            $reponse2 = $connexion->query("SELECT * FROM pers");
            while($personne = $reponse2->fetch()){
                echo '<li>'.$personne['id'].' - '.$personne['nom'].'</li>';
            }
        ?>
    </ul>
</body>
</html>