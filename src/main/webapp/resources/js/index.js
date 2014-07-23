var loopy = function(elements, callback){
	var length = elements.length;
	while (length--) {
		callback(elements[length]);
	}
};

var $tabs = document.querySelector("[data-id=tabs]");
$tabs.addEventListener("click", function(event){
	var $this = event.target,
		$sessions = document.querySelectorAll("section");
	
	console.log($sessions);
	
	if ($this.tagName == "A") {
		var $clickedSession = document.querySelector($this.href.match("(?=.*)#.*"));
		console.log(loopy);
		loopy($sessions, function(element){
			console.log(element);
			element.classList.remove("show");
		});
		$clickedSession.classList.add("show");
	}
});

function getTypeValues(){

	$('#generateBtn').attr('disabled', 'disabled');
	$('#value').attr('disabled', 'disabled');
	$('#loader').show();
	
	var letter = $("#type option:selected").val();
	
	$.getJSON("getListOfValues?letter=" + letter, function(json){

		$("#value option").remove();

		var values = json.list[0].int;
		for (var i=0;i<values.length;i++){
			$("#value").append('<option value="' + values[i] + '">' + values[i].toLocaleString("en-US") + ' gp</option>');
		}

		$('#loader').hide();
		$('#value').removeAttr('disabled');
		$('#generateBtn').removeAttr('disabled');
	});
	
}