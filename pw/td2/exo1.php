<?php

    $couleurs = ['rouge', 'jaune', 'vert', 'orange'];

    function choixDefault($couleur, $post_couleur){
        if(isset( $post_couleur) && $couleur == $post_couleur){
            return "selected";
        }else{
            return "";
        }
    }
?>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exo 2 - TD2</title>
    </head>
    <body>
        <form action="" method="post">
            <div>
                <label for="couleur">Entrer votre couleur préférée: </label>
                <select name="couleur" id="couleur">
                <?php foreach($couleurs as $value) :?> 
                <option value="<?=$value?>" 
                <?php 
                if(isset($_POST['couleur'])){echo choixDefault($value, $_POST['couleur']);}?>>
                    <?=ucfirst($value);?>
                </option>';
                <?php endforeach; ?>
                </select>
            <button type="submit">Valider</button>
            </div>
        </form>
        <p id="color"><?= isset($_POST['couleur'])?$_POST['couleur']:""; ?></p>
        <script>
            let color = document.getElementById('color').innerHTML;
            var body = document.body;
            switch(color){
                case "jaune":
                    body.style.backgroundColor = "yellow";
                    break;
                case "rouge":
                    body.style.backgroundColor = "red";
                    break;
                case "vert":
                    body.style.backgroundColor = "green";
                    break;
                case "orange":
                    body.style.backgroundColor = "orange";
                    break;
            }
        </script>
    </body>
</html>