<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
</head>
    <body>
        <p>Connexion</p>
        <form action="identification.php" method="post">
            <div>
                <label for="login">Login:</label>
                <input type="text" name="login" id="login">
            </div>
            <div>
                <label for="pwd">Mot de passe:</label>
                <input type="text" name="pwd" id="pwd">
            </div>
            <button type="submit">Se connecter</button>
        </form>
    </body>
</html>