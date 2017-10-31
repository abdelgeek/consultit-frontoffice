var oldAgency = {};
var countryToDelete
var totalCountry = 0


//enregistrer la liste des pays


var saveAgency = function(no) {
	$.ajax({
		url : '/saveAgency',
		data : {
			id : $("#id-text" + no).val(),
			agencyName : $("#agencyName-text" + no).val(),
			agencyInitials : $("#agencyInitials-text" + no).val(),
			link : $("#link-text" + no).val(),
			countryName : $("#countryName-text" + no).val(),
			isActive : true
		},
		type : 'POST',
		success : function(result) {

			if (result.isValid == true) {

				if (no == 0) {

					addToTable(result.agency);
					cancel_row(no)
				} else {

					bind_row(no);
				}



			}


			showAlert(result)

		},
		error : function() {}
	})
}



/*
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

*/


// get all agency
$.get({
	url : "/findAgencies",
	success : function(countries) {

		$.each(countries, function(i, agency) {

			i++;
			$("#data-table tr:last").after('<tr>'

				+ '<td id="id-row' + i + '">' + agency.id + '</td>'
				+ '<td id="agencyName-row' + i + '">' + agency.agencyName + '</td>'
				+ '<td id="agencyInitials-row' + i + '">' + agency.agencyInitials + '</td>'
				+ '<td id="link-row' + i + '">' + agency.link + '</td>'
				+ '<td id="countryName-row' + i + '">' + agency.country.countryName + '</td>'

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


				+ '</tr>');



		});

	},
	error : function() {}
})


function findCountries(no) {
	$.get({
		url : "/findCountries",
		success : function(countries) {

			$.each(countries, function(i, country) {
				$("#countryName-text" + no).append("" +
					'<option value="' + country.countryName + '" selected>' + country.countryName + '</option>');
			});

		},
		error : function() {}
	})

}


















//--------------------------------------  Action on button ---------------------------------------------------------



//edit a row
function edit_row(no) {
	document.getElementById("edit_button" + no).style.display = "none";
	document.getElementById("delete_button" + no).style.display = "none";

	document.getElementById("save_button" + no).style.display = "inline-block";
	document.getElementById("cancel_button" + no).style.display = "inline-block";

	var id = document.getElementById("id-row" + no);
	var agencyInitials = document.getElementById("agencyInitials-row" + no);
	var agencyName = document.getElementById("agencyName-row" + no);
	var link = document.getElementById("link-row" + no);
	var countryName = document.getElementById("countryName-row" + no);



	oldAgency.id = id.innerHTML;
	oldAgency.agencyInitials = agencyInitials.innerHTML;
	oldAgency.agencyName = agencyName.innerHTML;
	oldAgency.link = link.innerHTML;
	oldAgency.countryName = countryName.innerHTML;

	var id_data = id.innerHTML;
	var agencyInitials_data = agencyInitials.innerHTML;
	var agencyName_data = agencyName.innerHTML;
	var link_data = link.innerHTML;
	var countryName_data = countryName.innerHTML;


	id.innerHTML = "<input disabled class='form-control  form-edit' type='text' id='id-text" + no + "' value='" + id_data + "'>";
	agencyInitials.innerHTML = "<input class='form-control form-edit' type='text' id='agencyInitials-text" + no + "' value='" + agencyInitials_data + "'>";
	agencyName.innerHTML = "<input  class='form-control  form-edit' type='text' id='agencyName-text" + no + "' value='" + agencyName_data + "'>";
	link.innerHTML = "<input class='form-control form-edit' type='text' id='link-text" + no + "' value='" + link_data + "'>";


	countryName.innerHTML = "<select id='countryName-text1' class='mdb-select'> <option value=''selected='selected'>Choose your option</option" +"</select>";


	findCountries(no);

	/**/


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


		var id_val = oldAgency.id;
		var agencyInitials_val = oldAgency.agencyInitials;
		var agencyName_val = oldAgency.agencyName;
		var link_val = oldAgency.link;
		var countryName_val = oldAgency.countryName;


		var id = document.getElementById("id-row" + no);
		var agencyInitials = document.getElementById("agencyInitials-row" + no);
		var agencyName = document.getElementById("agencyName-row" + no);
		var link = document.getElementById("link-row" + no);
		var countryName = document.getElementById("countryName-row" + no);


		id.innerHTML = id_val;
		agencyInitials.innerHTML = agencyInitials_val;
		agencyName.innerHTML = agencyName_val;
		link.innerHTML = link_val;
		countryName.innerHTML = link_val;

	}

}




//bind data

function bind_row(no) {
	if (no == 0) {

		$("#id-row0").parent().remove();
		$("#add_button").prop('disabled', false);
	} else {



		document.getElementById("edit_button" + no).style.display = "inline-block";
		document.getElementById("delete_button" + no).style.display = "inline-block";

		document.getElementById("save_button" + no).style.display = "none";
		document.getElementById("cancel_button" + no).style.display = "none";


		var id_val = $("#id-text" + no).val();

		var agencyInitials_val = $("#agencyInitials-text" + no).val();
		var agencyName_val = $("#agencyName-text" + no).val();
		var link_val = $("#link-text" + no).val();
		var countryName_val = $("#countryName-text" + no).val();


		var id = document.getElementById("id-row" + no);
		var agencyInitials = document.getElementById("agencyInitials-row" + no);
		var agencyName = document.getElementById("agencyName-row" + no);
		var link = document.getElementById("link-row" + no);
		var countryName = document.getElementById("countryName-row" + no);


		id.innerHTML = id_val;
		agencyInitials.innerHTML = agencyInitials_val;
		agencyName.innerHTML = agencyName_val;
		link.innerHTML = link_val;
		countryName.innerHTML = countryName_val;

	}

}






//get row to delete

function delete_row(no) {
	countryToDelete = no

}

function deleteRow(no) {
	deleteCountry(no);
}


//confirm button
$("#button_confirm").on("click", function() {
	deleteRow(countryToDelete);
	$("#id-row" + countryToDelete).parent().remove();
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

		"</td>" +
		"<td id='id-row0'>" +
		"<input disabled class='form-control form-edit' type='text' id='id-text0' >" +
		"</td>" +

		"<td id='agencyName-row0'>" +
		"<input class='form-control form-edit' type='text' id='agencyName-text0" +
		"'></td>" +

		"<td  id='agencyInitials-row0'>" +
		"<input class='form-control form-edit' type='text' id='agencyInitials-text0" +
		"'></td>" +

		"<td  id='link-row0'>" +
		"<input class='form-control form-edit' type='text' id='link-text0" +
		"'></td>" +

		"<td>"


		+ "<select id='countryName-text0' class='mdb-select'>"
		+ "<option value=''  selected='selected'>Choose your option</option>"
		+ "</select>" +




		"<td scope='row' class='text-center'>" +

		"<button title='save' display='inline-block' type='button' id='save_button0' onclick='save_row(0)' class='btn btn-outline-success   waves-effect px-3'>" +
		"<i class='fa fa-save' aria-hidden='true'></i>" +
		"</button>" +

		"<button title='cancel'  onclick='cancel_row(0)'   type='button' id='cancel_button0' value='cancel' class='btn btn-outline-danger waves-effect px-3'>" +
		"<i class='fa fa-times' aria-hidden='true'></i>" +
		"</button>" +



		"</tr>";
	$("#add_button").prop('disabled', true);

	findCountries(0);

}


// save data to database
function save_row(no) {
	if (!$("#agencyName-text" + no).val()) {

		$("#agencyName-row" + no).append("" +
			"<p class='red-text'>This value could not be null.</p>");

	} else {


		if (!$("#agencyInitials-text" + no).val()) {

			$("#agencyInitials-row" + no).append("" +
				"<p class='red-text'>This value could not be null.</p>");
		} else {
			saveAgency(no);
			$("#add_button").prop('disabled', false);
		}


	}


}


//add new country to table
var addToTable = function(a) {

	var lgh = $("#data-table tr").length - 2;

	$("#data-table tr:last").after('<tr>'
		+ '<td id="id-row' + lgh + '">' + a.id + '</td>'
		+ '<td id="agencyName-row' + lgh + '">' + a.agencyName + '</td>'
		+ '<td id="agencyInitials-row' + lgh + '">' + a.agencyInitials + '</td>'
		+ '<td id="link-row' + lgh + '">' + a.link + '</td>'
		+ '<td id="countryName-row' + lgh + '">' + a.country.countryName + '</td>'
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

		+ '<button title="CANCEL" onclick="cancel_row(' + lgh + ')" style="display: none" type="button" id="cancel_button' + lgh + '" value="cancel" class="btn btn-outline-danger waves-effect px-3">'
		+ '	<i class="fa fa-times" aria-hidden="true"></i>'
		+ '</button>'
		+ '</td>'

		+ '</tr>')

}

function showAlert(result) {
	$(".alert").show()

	$('.alert').empty();

	/*$('.alert').append('' +
		'<span aria-hidden="true">&times;</span>' +
		'</button>');*/


	$('.alert').append(result.message);

	if (result.isValid == true) {

		$('.alert').addClass("alert-success");
		$('.alert').removeClass("alert-danger");

	} else {

		$('.alert').addClass("alert-danger");
		$('.alert').removeClass("alert-success");
	}

	setTimeout(function() {
		$(".alert").hide()
	}, 6000);
}