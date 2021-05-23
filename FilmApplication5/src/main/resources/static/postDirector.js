$(document).ready(function(){
	$("#myform").submit(function(){
		alert("hello");
		postDirector();
		});
		
		function postDirector(){
		
			var dataPost={
			name: $("#name").val(),
			age: $("#age").val(),
			gender: $("#gender").val(),
			awardCount: $("#awardCount").val()
				}
		console.log(name);
		$.ajax({
			url: '/dir/saveDirector',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(dataPost),
			dataType: 'json',
			success : function(data){
				console.log(data);
			}
		});
					
		}
		

	
});