<?php
    function all($tab){
        echo '<table>';
        /*Affichage des entetes */
        echo '<tr>';
        foreach($tab['toto'] as $key => $value){
            echo '<th>'.$key.'</th>';
        }
        echo '</tr>';
        /*Affichage des enregistrements */
        foreach ($tab as $values) {
            echo '<tr>';
            foreach($values as $value){
                echo '<td>'.$value.'</td>';
            }
            echo '</tr>';
        }
        echo '</table>';
    }

    function recherche($tab, $ville){
        $ville = ucfirst($ville);
        echo '<table>';
        echo '<tr>';
        foreach($tab['toto'] as $key => $value){
            echo '<th>'.$key.'</th>';
        }
        echo '</tr>';
        foreach ($tab as  $values) {
            echo '<tr>';
            if($values['ville'] === $ville){
                foreach($values as $value){
                    echo '<td>'.$value.'</td>';
                }
            }
            echo '</tr>';
        }
        echo '</table>';
    }