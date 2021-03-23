<?php
    include("functions.inc.php");
    $connection = PDOConnection();
    $sql = "INSERT INTO SERVj (name) 
            VALUES(:name)";
    $statement = $connection->prepare($sql);
    $statement->bindParam(":name", $name);
    $name = "Manager HR";
    $statement->execute();
    echo "Insertion reussie avec succès";

?>