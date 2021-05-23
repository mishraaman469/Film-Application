$(document).ready(function(){
	$("button").click(function(){
		postFilm();
	});
	

	
	function postFilm(){
		var name= $("#name").val();
		$.ajax({
			url: '/dir/getDirector/'+name,
			type: 'GET',
			success: function(data){
				console.log(data);
				var jsonStr = JSON.stringify(data);
				document.getElementById("para").innerHTML = jsonStr;
				
			/*	$.each(data,function(index,director){
					'<tr>'+
					'<td>'+director.name+'</td>'
					+'</tr>'
				});*/
				
			},
			error: function(data){
				alert("Not Found");
			}
			
		});
	}
	
});