<?php
    include("functions.inc.php");
    $connection = PDOConnection();
    $select = $connection->prepare("SELECT id, name FROM SERVi");
    $select->execute();

    
    if(isset($_POST['save'])){
        $sql = "INSERT INTO PERSi (name, service) 
                VALUES(:name, :service)";
        $insertion = $connection->prepare($sql);
        $insertion->bindParam(":name", $name);
        $insertion->bindParam(":service", $service);
        $name = formExist($_POST['name']);
        $service = formExist($_POST['service']);
        $insertion->execute();
        echo "Insertion reussie avec succès";
    }

?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exo 2.4</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <form action="" method="post">
            <div>
                <label for="name">Nom:</label>
                <input type="text" name="name" id="name">
            </div>
            <div>
                <label for="service">Service:</label>
                <select name="service" id="service">
                    <?php while($data = $select->fetch()): ?>
                        <option value="<?= $data['id']?>"><?= $data['name']?></option>
                    <?php endwhile; ?>
                </select>
            </div>
            <button name="save" type="submit">Enregistrer</button>
        </form>
    </body>
</html>