var oldCountry;
var countryToDelete
var totalCountry = 0


//enregistrer la liste des pays

var saveCountry = function(no) {
	$.ajax({
		url : '/saveCountry',
		data : {
			id : $("#id-text" + no).val(),
			countryName : $("#country-text" + no).val(),
			isActive : true
		},
		type : 'POST',
		success : function(result) {

			if (result.isValid == true) {
				addToTable(result.country);
				cancel_row(no);
			}

		
			showAlert(result)

		},
		error : function() {}
	})
}


//supprimer un pays
function deleteCountry(no) {
	$.post({
		url : "/deleteCountry",
		data : {
			id : $("#id-row" + no).html(),
			countryName : $("#country-row" + no).html(),
			isActive : false
		},
		success : function(result) {
			showAlert(result)
		}
	})
}


$.get({
	url : "/findCountries",
	success : function(countries) {

		$.each(countries, function(i, country) {

			totalCountry++
			
			i++;
			$("#data-table tr:last").after('<tr>'
				+ '<td scope="row" class="text-center">'

				+ '<button title="Update"  type="button" id="edit_button' + i + '" value="edit" onclick="edit_row(' + i + ')" class=" edit btn btn-outline-primary  waves-effect px-3">'
				+ '<i class="fa fa-edit" aria-hidden="true"></i>'
				+ '</button>'

				+ '<button title="Delete" type="button" data-toggle="modal" data-target="#confirmModal" onclick="delete_row(' + i + ')" id="delete_button' + i + '" value="delete" class="btn btn-outline-danger waves-effect px-3">'
				+ '	<i class="fa fa-trash" aria-hidden="true"></i>'
				+ '</button>'

				+ '<button title="Save" style="display: none" type="button" id="save_button' + i + '" onclick="save_row(' + i + ')" class="btn btn-outline-success   waves-effect px-3">'
				+ '	<i class="fa fa-save" aria-hidden="true"></i>'
				+ '</button>'

				+ '<button title="Cancel" onclick="cancel_row(' + i + ')" style="display: none" type="button" id="cancel_button' + i + '" value="cancel" class="btn btn-outline-danger waves-effect px-3">'
				+ '	<i class="fa fa-times" aria-hidden="true"></i>'
				+ '</button>'
				+ '</td>'
				+ '<td id="id-row' + i + '">' + country.id + '</td>'
				+ '<td id="country-row' + i + '">' + country.countryName + '</td>' +

				+'</tr>');
			
			

		});
		paginate();
	},
	error : function() {}
})























//--------------------------------------  Action on button ---------------------------------------------------------



//edit a row
function edit_row(no) {
	document.getElementById("edit_button" + no).style.display = "none";
	document.getElementById("delete_button" + no).style.display = "none";

	document.getElementById("save_button" + no).style.display = "inline-block";
	document.getElementById("cancel_button" + no).style.display = "inline-block";

	var id = document.getElementById("id-row" + no);
	var country = document.getElementById("country-row" + no);


	oldCountry = country.innerHTML;

	var id_data = id.innerHTML;
	var country_data = country.innerHTML;

	id.innerHTML = "<input disabled class='form-control  form-edit' type='text' id='id-text" + no + "' value='" + id_data + "'>";

	country.innerHTML = "<input class='form-control form-edit' type='text' id='country-text" + no + "' value='" + country_data + "'>";

}

//cancel a row
function cancel_row(no) {
	if (no == 0) {

		$("#id-row0").parent().remove();
		$("#add_button").prop('disabled', false);
	} else {
		document.getElementById("edit_button" + no).style.display = "inline-block";
		document.getElementById("delete_button" + no).style.display = "inline-block";

		document.getElementById("save_button" + no).style.display = "none";
		document.getElementById("cancel_button" + no).style.display = "none";


		var id_val = document.getElementById("id-text" + no).value;
		//	var country_val = document.getElementById("country-text" + no).value;

		var country_val = oldCountry;
		var id = document.getElementById("id-row" + no);
		var country = document.getElementById("country-row" + no);

		id.innerHTML = id_val;
		country.innerHTML = country_val;
	}

}


//get row to delete

function delete_row(no) {
	countryToDelete = no
	
}

function deleteRow(no){
	deleteCountry(no);
}


$("#button_confirm").on("click",function(){
	deleteRow(countryToDelete);
	$("#id-row"+countryToDelete).parent().remove();
	$('#confirmModal').modal('hide')
})

//add a row to the data table
function add_row() {
	/*var new_name=document.getElementById("new_name").value;
	var new_country=document.getElementById("new_country").value;
	var new_age=document.getElementById("new_age").value;
	*/
	var table = document.getElementById("data-table");
	var table_len = (table.rows.length);
	var row = table.insertRow(1).outerHTML = "<tr>" +
		"<td scope='row' class='text-center'>" +

		"<button title='save' display='inline-block' type='button' id='save_button0' onclick='save_row(0)' class='btn btn-outline-success   waves-effect px-3'>" +
		"<i class='fa fa-save' aria-hidden='true'></i>" +
		"</button>" +

		"<button title='cancel'  onclick='cancel_row(0)'   type='button' id='cancel_button0' value='cancel' class='btn btn-outline-danger waves-effect px-3'>" +
		"<i class='fa fa-times' aria-hidden='true'></i>" +
		"</button>" +


		"</td>" +
		"<td id='id-row0'>" +
		"<input disabled class='form-control form-edit' type='text' id='id-text0' >" +
		"</td>" +
		"<td>" +
		"<input class='form-control form-edit' type='text' id='country-text0" +
		"'></td>" +
		"</tr>";
	$("#add_button").prop('disabled', true);

}


// data to database
function save_row(no) {
	if (!$("#country-text" + no).val()) {

		$("#country-row").parent().append("" +
			"<p class='red-text'>This value could not be null.</p>");
	} else {
		saveCountry(no);

		$("#add_button").prop('disabled', false);
	}


}


//add new country to table
var addToTable = function(c) {

	var lgh = $("#data-table tr").length - 2;

	$("#data-table tr:last").after('<tr>'
		+ '<td scope="row" class="text-center">'

		+ '<button title="UPDATE" type="button" id="edit_button' + lgh + '" value="edit" onclick="edit_row(' + lgh + ')" class=" edit btn btn-outline-primary  waves-effect px-3">'
		+ '<i class="fa fa-edit" aria-hidden="true"></i>'
		+ '</button>'

		+ '<button  title="Delete" data-toggle="modal" data-target="#confirmModal" type="button" id="delete_button' + lgh + '" value="delete" class="btn btn-outline-danger waves-effect px-3">'
		+ '	<i class="fa fa-trash" aria-hidden="true"></i>'
		+ '</button>'

		+ '<button title="SAVE" style="display: none" type="button" id="save_button' + lgh + '" onclick="save_row(' + lgh + ')" class="btn btn-outline-success   waves-effect px-3">'
		+ '	<i class="fa fa-save" aria-hidden="true"></i>'
		+ '</button>'

		+ '<button title="CANCEL" onclick="cancel_row(' + i + ')" style="display: none" type="button" id="cancel_button' + lgh + '" value="cancel" class="btn btn-outline-danger waves-effect px-3">'
		+ '	<i class="fa fa-times" aria-hidden="true"></i>'
		+ '</button>'
		+ '</td>'
		+ '<td id="id-row' + lgh + '">' + c.id + '</td>'
		+ '<td id="country-row' + lgh + '">' + c.countryName + '</td>' +

		+'</tr>')

}

function showAlert(result) {
	$('.alert').empty();

	$('.alert').append('<button type="button" class="close" data-dismiss="alert" aria-label="Close">' +
		'<span aria-hidden="true">&times;</span>' +
		'</button>');

	$('.alert').append(result.message);
	if (result.isValid == true) {

		$('.alert').addClass("alert-success");

	


	} else {
		$('.alert').addClass("alert-danger");
	}

	setTimeout(function() {
		$(".alert").hide()
	}, 60000);
}


//paginate table
var paginate = function() {

	var pageIndex = 0;
	var maxCountry =2;
	var rowNum =0
	var totalCountry =5
	
	 $(" #data-table tr").each(function(){
		
		 rowNum++;
		 
		 if(rowNum>maxCountry){
			 $("#id-row"+rowNum).parent().hide();
			 
		 }
		 
		 
		
	 })
	 
	 

}
