<?php
    session_start();
?>
<!DOCTYPE html >
<html lang ="fr">
<head>
	<meta charset="UTF-8">
	<title>Exercice 4 </title>
		
	<style>
        .valid{
            color: green;
        }
	</style>
</head>

<body>
	<?php
		$login = strtolower(trim($_POST['username']));
		$mdp = strtolower(trim($_POST['password']));
		if (isset($login) && $login=="crepo" && isset($mdp) && $mdp=="nutella"){
            echo 'ok';
            $_SESSION['login'] = $login;
            $_SESSION['connecte'] = 'YES';
		    echo "<p class=\"valid\">Vous êtes connecté</p>";
	    }else{
		    header("Location: login.php?message=Erreur de connexion");
	    }
	?>
</body>
</html>
