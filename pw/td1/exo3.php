<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TD1 - Exo 3</title>
</head>
<body>
    <ul>
        <?php
            function carre($nombre){
                $result = "";
                $result = $nombre.'<sup>2</sup> = '.($nombre*$nombre);
                return $result;
            }
            
            for($i=1; $i<=30; $i++){
                echo '<li>'.carre($i).'</li>';
            }
        ?>
    </ul>
</body>
</html>