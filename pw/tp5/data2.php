<?php
    if(isset($_GET['age']) && !empty($_GET['age'])){
        $age = $_GET['age'];
        if($age>=18){
            echo "Tu es majeur!";
        }else{
            echo "Tu es mineur!";
        }
    }
?>