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