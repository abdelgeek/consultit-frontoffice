/**
 *  get Approval type from dataBase
 */

$.ajax({
		type:'GET',
		url:'/findApprovalType',
		success: function(approvalType){
			 $.each(approvalType,function(i,item){
				 console.log("ok")
				$("#approvalTypeDiv").append("<div class='form-group'>"
												+"<input name='group20' class='checked-title' type='radio' value='"+item.id+"'"
												+"	id='"+item.name+"' onclick='getEqmType("+item.id+")'>"
				                                 +"<label for='"+item.name+"'>"+item.name+"</label>"
												+"</div>");
			 })
		},
		error: function(approvalType){
			console.log('No')
		}
});


/**
 *  get Equipement type from dataBase
 */

function getEqmType(idApprovalType){

	console.log($('input[name=group20]:checked').val())
	$("#eqmtType-item").html("")
	$("#frqCy-band").hide()
	
	if(idApprovalType ==4){
		$("#frqCy-band").show()
	}
	
	$.ajax({
		type: 'GET',
		url: '/findEqmtypeByApprovalType?approvalId=' +idApprovalType,
		success: function(equipementType){
			if(equipementType.length > 0){
				$("#eqmtType").show();
				
				$.each(equipementType,function(i,item){
					
						$("#eqmtType-item").append("<div class=' col-md-3  col-sm-4'>"
								+ "<input type='checkbox' id='"+item.name+"'> " 
								+ "<label for='"+item.name+"'>"+ item.name +"</label>"
						+"</div>")
				})
			}else{
				$("#eqmtType").hide()
				
			}
			
			
		}
	})
}

/**
 * get Approval type from dataBase
 */
