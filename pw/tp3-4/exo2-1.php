<?php
    include("functions.inc.php");
    $connection = PDOConnection();
    $sql = "CREATE TABLE SERVj (
                id INT NOT NULL AUTO_INCREMENT,
                name VARCHAR(100),
                PRIMARY KEY (id)
            )";
    $connection->exec($sql);
    echo "Table SERVj créé avec succès!";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exo 2.1</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    
</body>
</html>