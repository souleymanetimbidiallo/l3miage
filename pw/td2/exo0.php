<?php
    function somme($table){
        $somme = 0;
        for($i=0; $i<count($table); $i++){
            $somme +=  $table[$i];
        }
        return $somme;
    }

    $tab = [1, 2, 3, 4, 5];
    echo somme($tab);

    echo '<hr>';

    $personnes = [
        'nom' => 'Gardner',
        'prenom' => 'Eric',
        'age' => 32,
        'sexe' => 'M',
        'adresse' => '5 Rue du Germain',
        'plat' => 'Frites au poulet'
    ];

    foreach($personnes as $value){
        echo '<p>'.$value.'</p>';
    }
    
    echo '<hr>';

    /** Tester l'egalite des tableaux */

    function tableauxIdentiques($tab1, $tab2){
        if(count($tab1)!=count($tab2)){
            return false;
        }elseif($tab1 != $tab2){
            return false;
        }
        return true;
    }
    $tab1 = [1, 2, 3, 4, 5];
    $tab2 = [2, 3, 4, 5, 9];
    $tab3 = [1, 2, 3, 4, 5];
    $tab4 = [1, 2, 3, 4, 5, 6];
    $assoc1 = ['nom'=>'Diallo', 'prenom'=>'Karim', 'age'=>18];
    $assoc2 = ['nom'=>'Diallo', 'age'=>18, 'prenom'=>'Karim',];
    $assoc3 = ['nom'=>'LeGrand', 'nom'=>'Karim', 'age'=>18];
    echo 'Comparaison 1: '.tableauxIdentiques($tab1, $tab2).'<br>';
    echo 'Comparaison 2: '.tableauxIdentiques($tab1, $tab3).'<br>';
    echo 'Comparaison 3: '.tableauxIdentiques($assoc1, $assoc2).'<br>';
    echo 'Comparaison 4: '.tableauxIdentiques($assoc1, $assoc3);
    
    echo '<hr>';

    function estPalindrome($tab){
        $tabReverse = [];
        $j=0;
        for($i=count($tab)-1; $i>=0; $i--){
            $tabReverse[$j] = $tab[$i];
            $j++;
        }
        return tableauxIdentiques($tab, $tabReverse)? true: false;
    }
    $tab1 = ["k", "a", "y", "a", "k"];
    echo (estPalindrome($tab1))?"Palindrome":"Pas un palindrome";
    echo '<br>';
    $tab2 = [1, 2, 3, 2, 7];
    echo (estPalindrome($tab2))?"Palindrome":"Pas un palindrome";;
?>