$(document).ready(function() {
	
	ajaxGet();
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url :  "/dir/getDirector",
			success: function(result){
				$.each(result, function(i, director){
					
					var updateUrl= "/dir/updateDirector/" + director.name;
					
					// render a customer data form
					var directorInfo = '<form id=empform_' + director.id + ' class="form-inline" style="margin-top:20px;margin-bottom:20px">' +
											'<div class="form-group">'	+
										 		'<label style="margin-left:10px; margin-right:5px">Id: </label>'	+
										 		'<input name="directorId" type="text" class="form-control" value=' + director.id  + ' disabled >' +
										 	'</div>' +
										 	'<div class="form-group">'	+
										 		'<label style="margin-left:10px; margin-right:5px">Name: </label>'	+
										 		'<input name="name" type="text" class="form-control"  value=' + director.name + ' disabled >' +
										 	'</div>' +
										
											'<div class="form-group" style="display: none;">' +
										  		'<label style="margin-left:5px; margin-right:5px">Gender: </label>' +
										  		'<input name="gender" type="text" class="form-control" value=' + director.gender +'>' +
										  	'</div>' +
												
										 	'<div class="form-group" style="display: none;">' +
										  		'<label style="margin-left:5px; margin-right:5px">Age: </label>' +
										  		'<input name="age" type="number"  class="form-control"  value=' + director.age +'>' +
										  	'</div>' +
										
										 	'<div class="form-group" style="display: none;">' +
										  		'<label style="margin-left:5px; margin-right:5px">AwardCount: </label>' +
										  		'<input name="awardCount" type="number" class="form-control"  value=' + director.awardCount +'>' +
										  	'</div>' +
										  	
										  	'<button type="submit" class="btn btn-default" style="margin-left:10px">Select</button>'
										'</form>';
					
					$('#directorlist .list-group').append(directorInfo)
					
					// default fill data of the first customer to update-form
					if(i==0){
						$("#updateFormDirId").val(director.id);
						$("#updateFormName").val(director.name);
						$("#updateFormGender").val(director.gender);
						$("#updateFormAge").val(director.age);
						$("#updateFormAwardCount").val(director.awardCount);
						
					}
					
		        });
				console.log("Success: ", result);
			},
			error : function(e) {
				$("#directorlist").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})


