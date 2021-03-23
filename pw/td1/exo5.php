<?php
    $months = ['Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin', 
              'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];

    $months_assoc = ['Janvier'=>31, 'Fevrier'=>28, 'Mars'=>31, 'Avril'=>30, 'Mai'=>31, 
                    'Juin'=>30, 'Juillet'=>31, 'Aout'=>31, 'Septembre'=>30, 
                    'Octobre'=>31, 'Novembre'=>30, 'Décembre'=>31];
?>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Exo 5 - TD1</title>
    </head>
    <body>
        <ol>
            <?php
                for($i=0; $i<12; $i++){
                    echo '<li>'.$months[$i].'</li>';
                }
            ?>
        </ol>
        
        <ul>
            <?php
                foreach ($months_assoc as $key => $value){
                    echo '<li>'.$key.' => '.$value.'</li>';
                }
            ?>
        </ul>

    </body>
</html>