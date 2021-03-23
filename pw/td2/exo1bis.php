<?php

    $couleurs = ['rouge', 'jaune', 'vert', 'orange'];
    if(isset($_POST['couleur'])){
        $result = $_POST['couleur'];
    }

    function choixDefault($couleur, $post_couleur){
        if($couleur == $post_couleur){
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
        <title>Exop 2 - TD2</title>
    </head>
    <body>
        <form action="" method="post">
            <div>
                <label for="couleur">Entrer votre couleur préférée: </label>
                <select name="couleur" id="couleur">
                <?php foreach($couleurs as $value) :?> 
                <option value="<?=$value?>" <?php if($value==$_POST['couleur']):?>selected <?php endif; ?>><?=ucfirst($value);?></option>';
                <?php endforeach; ?>
                </select>
            <button type="submit">Valider</button>
            </div>
        </form>
        <?= isset($_POST['couleur'])?$_POST['couleur']:""; ?>
    </body>
</html>