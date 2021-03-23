<?php
    include('functions.inc.php');

    $personnes = array(
        'mdupond'=> array('prenom' => 'Martin', 'nom' => 'Dupond', 'age' => 25, 'ville' => 'Paris'),
        'jm'=> array('prenom' => 'Jean', 'nom' => 'Martin', 'age' => 20, 'ville' => 'Villetaneuse'),
        'toto'=> array('prenom' => 'Tom', 'nom' => 'Tonge', 'age' => 18, 'ville' => 'Epinay'),
        'arn'=> array('prenom' => 'Arnaud', 'nom' => 'Dupond', 'age' => 33, 'ville' => 'Paris'),
        'email'=> array('prenom'=>'Emilie', 'nom'=>'Ailta', 'age'=>46, 'ville'=>'Villetaneuse'),
        'dask' => array('prenom'=>'Damien','nom'=>'Askier','age'=>7,'ville'=>'Villetaneuse')
     );

    if(isset($_GET['pseudo']) || !empty($_GET['pseudo'])){
        $pseudo =  $_GET['pseudo'];
        if(!array_key_exists($pseudo, $personnes)){
            echo "Désolé!";
        }else{
            foreach($personnes[$pseudo] as $key => $value){
                echo ucfirst($key).': '.$value." <br>";
            }
        }
    }
?>