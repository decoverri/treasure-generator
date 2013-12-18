function calculateSum(){
	
	var sum = 0;
	
	$(".checkbox input[type=checkbox]:checked").each(function(){
		sum += parseInt($(this).val());
	});
	
	$("#selectedTotal").html(sum.toLocaleString("en-US"));
}