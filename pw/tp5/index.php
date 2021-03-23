<html>

<head>
    <title>TP5</title>
    <script language="JavaScript">

        function submitForm() {
            var req = null;

            document.ajax.dyn.value = "Started...";

            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();

            }
            else if (window.ActiveXObject) {
                try {
                    req = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        req = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) { }
                }
            }


            req.onreadystatechange = function () {
                document.ajax.dyn.value = "Wait server...";
                if (req.readyState == 4) {
                    if (req.status == 200) {
                        document.ajax.dyn.value = req.responseText;
                    }
                    else {
                        document.ajax.dyn.value = "Error: returned status code " + req.status + " " + req.statusText;
                    }
                }
            };
            var age =  document.getElementById('age').value;
            req.open("GET", "data2.php?age="+age, true);
            req.send(null);
        } 
    </script>
</head>

<body>
    <form method="POST" name="ajax" action="">
        <label for="age">Age:</label>
        <input type="text" id="age" name="age">
        <br><br>
        <input type="BUTTON" value="Submit" onmouseover="submitForm()">
        <input type="text" id="dyn" name="dyn" value="">
    </form>
</body>

</html>