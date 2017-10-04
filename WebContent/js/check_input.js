function isEveryInputEmpty() {
	var agency = document.getElementById("agency").value;
	var headline = document.getElementById("headline").value;
	var date = document.getElementById("date").value;
	var city = document.getElementById("city").value;
	var content_seasrch = document.getElementById("content_seasrch").value;
	
	if( agency == "" && headline == "" && date == "" && city == "" && content_seasrch == ""){
		alert("Please input something!")
		return false;
	}
	return true;
}