<?php
    include("functions.inc.php");
    $connection = PDOConnection();
    $sql = "SELECT servi.name as sname, COUNT(*) as effectif
            FROM persi, servi
            where persi.service = servi.id
            GROUP by servi.id";
    $statement = $connection->prepare($sql);
    $statement->execute();

?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exo 3.1</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <table>
            <tr>
                <th>Nom Service</th>
                <th>Effectif</th>
            </tr>
            <?php while($data = $statement->fetch()) : ?>
            <tr>
                    <td><?= $data['sname'] ?></td>
                    <td><?= $data['effectif'] ?></td>
            </tr>
            <?php endwhile; ?>
        </table>
    </body>
</html>