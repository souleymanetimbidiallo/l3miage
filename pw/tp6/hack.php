<?php   
echo $_SERVER['REMOTE_ADDR']."<br>";   
$handle = @fopen("mdp.txt", "r");
if ($handle) {
    while (($buffer = fgets($handle, 4096)) !== false) {
        echo $buffer."<br>";
    }
    fclose($handle);
}
?>