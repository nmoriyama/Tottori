var num = 0;
function input(){
	num++;
	var inputName = "isbn";
	var input = document.createElement("input");

	input.setAttribute("name",inputName);
	document.getElementById("input").appendChild(input);
	
	var limit = 8;
	if(num > limit){ // 10個以上になったらそれ以上増やさない
		input.setAttribute("type","text");
		return false;
	}
	
	return true;
}