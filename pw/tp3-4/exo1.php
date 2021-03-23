<?php
    include("functions.inc.php");
    $connection = PDOConnection(); 
    $statement = $connection->prepare("SELECT * FROM persi");
    $statement->execute();

    $statement2 = $connection->prepare("SELECT COUNT(*) as nb FROM persi");
    $statement2->execute();
    $result = $statement2->fetch();

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exo 1</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <p>Le nombre de personnnes: <?= $result['nb']; ?></p>

    <table>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Service</th>
        </tr>
        <?php while($data = $statement->fetch()) : ?>
        <tr>
                <td><?= $data['id'] ?></td>
                <td><?= $data['name'] ?></td>
                <td><?= $data['service'] ?></td>
        </tr>
        <?php endwhile; ?>
    </table>
</body>
</html>