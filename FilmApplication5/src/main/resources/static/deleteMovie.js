$(document).ready(function(){
	$("#submit").click(function(){
		postData();
	});
	
	function postData(){
		 var name = $("#name").val();
		
		$.ajax({
			type: 'Delete',
			url: "/film/deleteFilm/"+name,
			success : function(data){
				alert("deleted");
			},
			error : function(data){
				console.log(data);
				alert("data not deleted");
			}
		});
	}
	
});