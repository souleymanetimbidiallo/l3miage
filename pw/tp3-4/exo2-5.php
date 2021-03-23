<?php
    include("functions.inc.php");
    $connection = PDOConnection();
    $sql = "SELECT PERSi.id as pid, PERSi.name as pname, SERVi.name as sname
            FROM PERSi, SERVi
            WHERE PERSi.service = SERVi.id";
    $statement = $connection->prepare($sql);
    $statement->execute();

?>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exo 2.5</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Service</th>
            </tr>
            <?php while($data = $statement->fetch()) : ?>
            <tr>
                    <td><?= $data['pid'] ?></td>
                    <td><?= $data['pname'] ?></td>
                    <td><?= $data['sname'] ?></td>
            </tr>
            <?php endwhile; ?>
        </table>
    </body>
</html>