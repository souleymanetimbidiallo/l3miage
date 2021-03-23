<script language="JavaScript">

	function submitForm()
	{ 
		var req = null; 

		document.ajax.dyn.value="Started...";
 
		if (window.XMLHttpRequest)
		{
 			req = new XMLHttpRequest();

		} 
		else if (window.ActiveXObject) 
		{
			try {
				req = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e)
			{
				try {
					req = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {}
			}
        	}


		req.onreadystatechange = function()
		{ 
			document.ajax.dyn.value="Wait server...";
			if(req.readyState == 4)
			{
				if(req.status == 200)
				{
					document.ajax.dyn.value=req.responseText;	
				}	
				else	
				{
					document.ajax.dyn.value="Error: returned status code " + req.status + " " + req.statusText;
				}	
			} 
		}; 
		req.open("GET", "data.txt", true); 
		req.send(null); 
	} 
	</script>