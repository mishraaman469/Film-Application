$(document).ready(function(){
	var i=0;
	$("#btn").click(function(){
			
			$("#fig").append("<div>Director id :<input type='text' id='id"+i+"'> </div>");
			i++;
		});
	
	$("#btn1").on("click",function(){
		var director=[];
		for(var j=0;j<i;j++){
		var directors={};
		id="id"+j;
		console.log(id);	
		directors.id =document.getElementById(id).value;
		director.push(directors);	
		
		}
		
		 
		
	var dataPost={
		name: $("#name").val(),
		boxOfficeCollection: $("#boxOfficeCollection").val(),
		rating: $("#rating").val(),
		director: director
		}
		alert(dataPost.name+" "+dataPost.boxOfficeCollection+" "+dataPost.rating);
		postFilm(dataPost);
		
		
	});
	
	
	function postFilm(dataPost){
		$.ajax({
			url: '/film/saveFilm',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(dataPost),
			dataType: 'Json',
			success: function(data){
				console.log(data);
			}
			
		});
	}
	
});