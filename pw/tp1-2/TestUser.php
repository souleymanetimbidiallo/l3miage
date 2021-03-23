<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Test User</title>
    </head>
    <body>
        <?php

            require 'User.php';
            $u1 = new User();
            $u2 = new User("Diallo", "Souleymane");
            echo($u1->getAge());
            echo($u2->getNom());
        ?>
    </body>
</html>