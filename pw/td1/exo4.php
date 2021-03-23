<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exo 4 - TD1</title>
    <style>
        table, td{
            border-collapse: collapse;
            border: 2px solid black;
        }
        td{
            padding: 5px;
        }
        .css1{
            background-color: orange;
        }
        .css2{
            background-color: lightcoral;
        }
        .css3{
            background-color: lightsalmon;
        }
    </style>
</head>
<body>
    <table>
        <?php
            for($i=1; $i<=9; $i++){
                echo '<tr>';
                for($j=1; $j<=9; $j++){
                    if($i==1 || $j==1){
                        echo '<td class="css1">'.($i*$j).'</td>';
                    }else if($i % 2 == 0){
                        echo '<td class="css2">'.($i*$j).'</td>';
                    }else{
                        echo '<td class="css3">'.($i*$j).'</td>';
                    }
                }
                echo '</tr>';
            }
        ?>
    </table>
</body>
</html>