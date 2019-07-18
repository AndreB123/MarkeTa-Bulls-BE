function getUsers(){
	let xhr = new XMLHttpRequest();

	var id = getId();

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			data = JSON.parse(xhr.responseText);
			
			body.innerHTML = data;
		}
	}
	
	xhr.open("Get", "/pipeline/users"); // ready state 1
	xhr.send();
}