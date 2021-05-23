$(document).ready(function(){
	$("button").click(function(){
		postFilm();
	});
	

	
	function postFilm(){
		var name= $("#name").val();
		console.log(name);
		$.ajax({
			url: '/film/getFilmByName/'+name,
			type: 'GET',
			success: function(data){
				console.log(data);
				/*var jsonStr = JSON.stringify(data);
				document.getElementById("para").innerHTML = jsonStr;*/
				$("#para").append("-->{ Movie id= "+data.id+",Name : "+data.name+", Box Office Collection: "+data.boxOfficeCollection+"rating: "+data.rating+"}");
				$.each(data.director,function(i,director){
					$("#para").append("{ Director with name : "+director.name+",Age= "+director.age+", Gender"+director.gender+", Award Count"+director.awardCount+"}");
				});
			},
			error : function(data){
				alert("Not Found");
			}
			
		});
	}
	
});