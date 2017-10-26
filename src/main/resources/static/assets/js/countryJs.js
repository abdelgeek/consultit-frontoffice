
//enregistrer la liste des pays
var saveCountry = function(no) {
	$.ajax({
		url : '/saveCountry',
		data : {
			id : $("#id-text" + no).val(),
			countryName : $("#country-text" + no).val()
		},
		type : 'POST',
		success : function(result) {
			
			
			
			$('.alert').empty();
			
			$('.alert').append('<button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
										'<span aria-hidden="true">&times;</span>'+
									'</button>');
			
			$('.alert').append(result.message);
			
			
			if(result.isValid == true){
			$('.alert').addClass("alert-success");
			}else{
				$('.alert').addClass("alert-danger");
			}
			
			  setTimeout(function(){ $(".alert").hide()  }, 60000);
		},
		error : function() {
			
			
		}
	})
}


//retourner la liste des pays
$.get({
	url : "/findCountries",
	success : function(countries) {
		console.log("ok")
		$.each(countries,function(i,country) {
			
			var table_len=$("#data-table").length;
			i++;
			$("#data-table tr:last").after('<tr>'
			+'<td scope="row" class="text-center">'

				+'<button type="button" id="edit_button'+i+'" value="edit" onclick="edit_row('+i+')" class=" edit btn btn-outline-primary  waves-effect px-3">'
				+	'<i class="fa fa-edit" aria-hidden="true"></i>'
				+'</button>'

				+'<button type="button" id="delete_button'+i+'" value="delete" class="btn btn-outline-danger waves-effect px-3">'
				+'	<i class="fa fa-trash" aria-hidden="true"></i>'
				+'</button>'

				+'<button style="display: none" type="button" id="save_button'+i+'" onclick="save_row('+i+')" class="btn btn-outline-success   waves-effect px-3">'
				+'	<i class="fa fa-save" aria-hidden="true"></i>'
				+'</button>'

				+'<button onclick="cancel_row(1)" style="display: none" type="button" id="cancel_button'+i+'" value="cancel" class="btn btn-outline-danger waves-effect px-3">'
				+'	<i class="fa fa-times" aria-hidden="true"></i>'
				+'</button>'
			+'</td>'
			+'<td id="id-row'+i+'">'+ country.id +'</td>'
			+'<td id="country-row'+i+'">'+country.countryName+'</td>'+

		+'</tr>')
			
		})
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

	var id_data = id.innerHTML;
	var country_data = country.innerHTML;
	
	id.innerHTML = "<input class='form-control disabled  form-edit' type='text' id='id-text" + no + "' value='" + id_data + "'>";

	country.innerHTML = "<input class='form-control form-edit' type='text' id='country-text" + no + "' value='" + country_data + "'>";

}

//cancel a row
function cancel_row(no) {
	document.getElementById("edit_button" + no).style.display = "inline-block";
	document.getElementById("delete_button" + no).style.display = "inline-block";

	document.getElementById("save_button" + no).style.display = "none";
	document.getElementById("cancel_button" + no).style.display = "none";


	var country_val = document.getElementById("country-text" + no).value;

	var country = document.getElementById("country-row" + no);
	console.log(country)
	country.innerHTML = country_val;


}

//cancel a row
function cancel_new() {
	$("#data-table tr:nth-child(2)").remove();
	$("#add_button").prop('disabled', false);
}


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

		"<button display='inline-block' type='button' id='save_new' onclick='save_row()' class='btn btn-outline-success   waves-effect px-3'>" +
		"<i class='fa fa-save' aria-hidden='true'></i>" +
		"</button>" +

		"<button  onclick='cancel_new()'   type='button' id='cancel_new' value='cancel' class='btn btn-outline-danger waves-effect px-3'>" +
		"<i class='fa fa-times' aria-hidden='true'></i>" +
		"</button>" +


		"</td>" +
		"<td id='id-row0'></td>" +
		"<td>" +
		"<input class='form-control form-edit' type='text' id='country-row0" +
		"'></td>" +
		"</tr>";
	$("#add_button").prop('disabled', true);
}


// data to database
function save_row(no) {
	
	
	if (!$("#country-text"+no).val()) {
		
		$("#country-row").parent().append("" +
			"<p class='red-text'>This value could not be null.</p>");
	} else {
		
		
		 saveCountry(no);
		
	}
}