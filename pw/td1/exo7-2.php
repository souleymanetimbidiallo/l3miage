<?php
    $personnes = array(
        'mdupond'=> array('prenom' => 'Martin', 'nom' => 'Dupond', 'age' => 25, 'ville' => 'Paris'),
        'jm'=> array('prenom' => 'Jean', 'nom' => 'Martin', 'age' => 20, 'ville' => 'Villetaneuse'),
        'toto'=> array('prenom' => 'Tom', 'nom' => 'Tonge', 'age' => 18, 'ville' => 'Epinay'),
        'arn'=> array('prenom' => 'Arnaud', 'nom' => 'Dupond', 'age' => 33, 'ville' => 'Paris'),
        'email'=> array('prenom'=>'Emilie', 'nom'=>'Ailta', 'age'=>46, 'ville'=>'Villetaneuse'),
        'dask' => array('prenom'=>'Damien','nom'=>'Askier','age'=>7,'ville'=>'Villetaneuse')
     );
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exo 7.2 - TD 1 </title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <form action="" method="POST">
            <label for="pseudo">Pseudo:</label>
            <input type="search" id="pseudo" name="pseudo" value="<?php if(isset($_POST['pseudo'])) echo $_POST['pseudo'];?>">
            <button type="submit">rechercher</button>
        </form>
        <?php
            if(isset($_POST['pseudo']) || !empty($_POST['pseudo'])){
        
                $pseudo =  $_POST['pseudo'];
                if(!array_key_exists($pseudo, $personnes)){
                    echo "<p> Désolé! </p>";
                }else{
                    foreach($personnes[$pseudo] as $key => $value){
                        echo '<p>'.ucfirst($key).': '.$value."</p>";
                    }
                }
            }
        ?>
    </body>
</html>