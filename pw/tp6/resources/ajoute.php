<?php
 session_start();
 if($_SESSION['connecte']!='YES'){
    header('Location: login.php');
 }

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajout</title>
</head>
<body>
    <div>
        <a href="deconnexion.php">
            <img src="images/deconnexion.png" alt="">
        </a>
    </div>
</body>
</html>