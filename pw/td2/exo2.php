<?php
    $cpt = 0;
    if(isset($_POST['validate'])){
        $cpt = 0; 
        if( (isset($_POST['actionPage']) || !empty($_POST['actionPage'])) && ($_POST['actionPage']=="samePage") ){
            $cpt++;
        }
        if( (isset($_POST['attrChecked']) || !empty($_POST['attrChecked'])) && ($_POST['attrChecked']=="checked") ){
            $cpt++;
        }
        if( (isset($_POST['couleur']) || !empty($_POST['couleur'])) && ($_POST['couleur']=="noir") ){
            $cpt++;
        }
        if( (isset($_POST['valueChecked']) || !empty($_POST['valueChecked'])) && ($_POST['valueChecked']=="checked") ){
            $cpt++;
        }
        if( (isset($_POST['post_input']) || !empty($_POST['post_input'])) && ($_POST['post_input']=="post_age_18") ){
            $cpt++;
        }
        if( (isset($_POST['post_textarea']) || !empty($_POST['post_textarea'])) && ($_POST['post_textarea']=="post_news_value") ){
            $cpt++;
        }
        if($cpt==6){
            echo '<p style="color:blue">Félicitations. Nombre de reponses justes: '.$cpt.'/6</p>';
        }else{
            echo '<p style="color:blue">Désolé vous n\'avez pas tout trouvé. Nombre de reponses justes: '.$cpt.'/6</p>';
        }
    }
    
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exo 3 - TD2</title>
    </head>
    <body>
        <form action="" method="POST">
            <p>Une question ...</p>
            <div>
                <label>Si on ne met pas d'attribut action aux formulaires, que va t'il se passer?</label>
                <p>
                    <input type="radio" id="emptyPage" name="actionPage" value="emptyPage">
                    <label for="emptyPage">Ca va afficher une page vide</label>
                </p>
                <p>
                    <input type="radio" id="samePage" name="actionPage" value="samePage">
                    <label for="samePage">Ca va recharger la meme page</label>
                </p>
                <p>
                    <input type="radio" id="errorPage" name="actionPage" value="errorPage">
                    <label for="errorPage">Ca va afficher une erreur 404 </label>
                </p>
            </div>
            <hr>
            <div>
                <label>Quel est l'attribut à rajouter à une case à cocher pour qu'elle soit cochée par défaut</label>
                <p>
                    <input type="radio" id="selected" name="attrChecked" value="selected">
                    <label for="selected">selected</label>
                </p>
                <p>
                    <input type="radio" id="checked" name="attrChecked" value="checked">
                    <label for="checked">checked</label>
                </p>
                <p>
                    <input type="radio" id="signed" name="attrChecked" value="signed">
                    <label for="signed">signed</label>
                </p>
            </div>
            <hr>
            <div>
                <label for="couleur">Quelle est la couleur d'un tableau: </label>
                <select name="couleur" id="couleur">
                    <option value="vert" selected>Vert</option>
                    <option value="rouge">Rouge</option>
                    <option value="noir">Noir</option>
                </select>
            </div>
            <hr>
            <div>
                <label>Quelle est la valeur correspondante à une case à cocher cochée?</label>
                <p>
                    <input type="radio" id="val1" name="valueChecked" value="1">
                    <label for="val1">1</label>
                </p>
                <p>
                    <input type="radio" id="valChecked" name="valueChecked" value="checked">
                    <label for="valChecked">checked</label>
                </p>
                <p>
                    <input type="radio" id="valOn" name="attrChecked" value="on">
                    <label for="valOn">on</label>
                </p>
            </div>
            <hr>
            <div>
                <label>Que va produire ce code HTML?</label>
                <p><small>code HTML: </small> &lt;input type="hidden" name="age" value="18"/&gt;</p>
                <p>
                    <input type="radio" id="post_age_18" name="post_input" value="post_age_18">
                    <label for="post_age_18">Une variable $_POST['age'] qui aura une valeur 18</label>
                </p>
                <p>
                    <input type="radio" id="post_hidden_18" name="post_input" value="post_hidden_18">
                    <label for="post_hidden_18">Une variable $_POST['hidden'] qui aura une valeur 18</label>
                </p>
                <p>
                    <input type="radio" id="post_age_hidden" name="post_input" value="post_age_hidden">
                    <label for="post_age_hidden">Une variable $_POST['age'] qui aura une valeur "hidden"</label>
                </p>
            </div>
            <hr>
            <div>
                <label>
                    Quelle sera la variable créée, et quelle sera sa valeur, si on ne change pas 
                    le texte par défaut de la grosse zone de texte ci-dessous ?
                </label>
                <p><small>code HTML: </small> &lt;textarea name="news" cols="45" rows="8"&gt;Taper la news ici &lt;/textarea&gt;</p>
                <p>
                    <input type="radio" id="post_news_null" name="post_textarea" value="post_news_null">
                    <label for="post_news_null">$_POST['news'] = NULL</label>
                </p>
                <p>
                    <input type="radio" id="post_textarea_value" name="post_textarea" value="post_textarea_value">
                    <label for="post_textarea_value"> $_POST['textarea'])="Taper la news ici"</label>
                </p>
                <p>
                    <input type="radio" id="post_news_value" name="post_textarea" value="post_news_value">
                    <label for="post_news_value">$_POST['news']="Taper la news ici"</label>
                </p>
            </div>
            <hr>
            <button type="submit" name="validate">Valider</button>
        </form>
    </body>
</html>