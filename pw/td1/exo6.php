<?php
    include("functions.inc.php");
    
    $personnes = array(
        'mdupond'=> array('prenom' => 'Martin', 'nom' => 'Dupond', 'age' => 25, 'ville' => 'Paris'),
        'jm'=> array('prenom' => 'Jean', 'nom' => 'Martin', 'age' => 20, 'ville' => 'Villetaneuse'),
        'toto'=> array('prenom' => 'Tom', 'nom' => 'Tonge', 'age' => 18, 'ville' => 'Epinay'),
        'arn'=> array('prenom' => 'Arnaud', 'nom' => 'Dupond', 'age' => 33, 'ville' => 'Paris'),
        'email'=> array('prenom'=>'Emilie', 'nom'=>'Ailta', 'age'=>46, 'ville'=>'Villetaneuse'),
        'dask' => array('prenom'=>'Damien','nom'=>'Askier','age'=>7,'ville'=>'Villetaneuse')
    );

    $ville = "Paris";


?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exo 6 - TD 1 </title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <?php
        echo $personnes['arn']['age']; 
        echo '<br>';
        echo $personnes['toto']['ville']; 
    
    ?>
    <h2>Liste des personnes:</h2>
    <?php


        all($personnes);
    ?>
    <br>
    <h2>Liste des personnes habitant à <?=$ville?>:</h2>
    <?php
        recherche($personnes, $ville);
    ?>
</body>
</html>