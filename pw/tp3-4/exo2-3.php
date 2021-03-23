<?php
    if(isset($_POST['save'])){

        include("functions.inc.php");
        $connection = PDOConnection();
        $sql = "INSERT INTO SERVj (name) 
                VALUES(:name)";
        $statement = $connection->prepare($sql);
        $statement->bindParam(":name", $name);
        $name = formExist($_POST['name']);
        $statement->execute();
        echo "Insertion reussie avec succès";
    }

?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exo 2.3</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <form action="" method="post">
            <div>
                <label for="name">Nom de service:</label>
                <input type="text" name="name" id="name">
            </div>
            <button name="save" type="submit">Enregistrer</button>
        </form>
    </body>
</html>