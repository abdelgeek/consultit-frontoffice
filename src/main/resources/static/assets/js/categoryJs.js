var oldCountry = {};
var categoryToDelete



//enregistrer la liste des pays
/*

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

*/

/*
//supprimer un pays
function deleteCountry(no) {
	
	
	$.post({
		url : "/deleteAngency",
		data : {
			id : $("#id-row" + no).html(),
			agencyName : $("#agencyName-row" + no).html(),
			agencyInitials : $("#agencyInitials-row" + no).html(),
			link : $("#link-row" + no).html(),
			countryName : $("#countryName-row" + no).html(),
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
	url : "/findCategories",
	success : function(categories) {

		$.each(categories, function(i, category) {

			i++;
			$("#data-table tr:last").after('<tr>'

				+ '<td id="id-row' + i + '">' + category.id + '</td>'
				+ '<td id="countryName-row' + i + '">' + category.country.countryName + '</td>'
				+ '<td id="categoryName-row' + i + '">' + category.categoryName + '</td>'
				+ '<td id="categoryPrice-row' + i + '">' + category.categoryPrice + '</td>'
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

// afficher la liste
function findCountries(no) {
	$.get({
		url : "/findCountries",
		success : function(countries) {

			$.each(countries, function(i, country) {
				$("#countryName-text" + no).append("" +
					'<option value="' + country.countryName + '" >' + country.countryName + '</option>');
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
	var countryName = document.getElementById("countryName-row" + no);
	var categoryName = document.getElementById("categoryName-row" + no);
	var categoryPrice = document.getElementById("categoryPrice-row" + no);
	


	oldCountry.id = id.innerHTML;
	oldCountry.countryName = countryName.innerHTML;
	oldCountry.categoryName = categoryName.innerHTML;
	oldCountry.categoryPrice = categoryPrice.innerHTML;
	

	var id_data = id.innerHTML;
	var countryName_data = countryName.innerHTML;
	var categoryName_data = categoryName.innerHTML;
	var categoryPrice_data = categoryPrice.innerHTML;
	

	id.innerHTML = "<input disabled class='form-control  form-edit' type='text' id='id-text" + no + "' value='" + id_data + "'>";
	countryName.innerHTML = "<select id='countryName-text"+no+"' class='form-control'> <option value=''selected>Choose your option</option" +"</select>";
	
	categoryName.innerHTML ="<select onchange='activeName(" +no+")' id='hasName" + no + "' class='form-control'> "+
	"<option value='0' selected>Has one category</option>"+
	"<option value='1'>Has many categories </option></select>" +
	"<input type='text' placeholder='categorie name'   id='categoryName-text" + no + "' style='display:none;'   class='form-control  form-edit'/>";
	
	categoryPrice.innerHTML = "<input  class='form-control form-edit' type='text' id='link-text" + no + "' value='" + categoryPrice_data + "'>";


	

	findCountries(no);

	


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

		
		
		var id_val = oldCountry.id;
		var countryName_val = oldCountry.countryName;
		var categoryName_val = oldCountry.categoryName;
		var categoryPrice_val = oldCountry.categoryPrice;


		var id = document.getElementById("id-row" + no);
		var countryName = document.getElementById("countryName-row" + no);
		var categoryName = document.getElementById("categoryName-row" + no);
		var categoryPrice = document.getElementById("categoryPrice-row" + no);


		id.innerHTML = id_val;
		countryName.innerHTML = countryName_val;
		categoryName.innerHTML = categoryName_val;
		categoryPrice.innerHTML = categoryPrice_val;
		
	}

}



//bind data

/*
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


*/



//get row to delete
/*
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
*/


//add a row to the data table
function add_row() {

	var table = document.getElementById("data-table");
	var table_len = (table.rows.length);
	var row = table.insertRow(1).outerHTML = "<tr>" +

		"</td>" +
		"<td id='id-row0'>" +
		"<input disabled class='form-control form-edit' type='text' id='id-text0' >" +
		"</td>" +

		"<td id='countryName-row0'>" +
		 "<select id='countryName-text0' class='form-control'> <option value=''selected>Choose your option</option>" +"</select>"+
		"</td>" +

		"<td  id='categoryName-row0'>" +
		"<select onchange='activeName(0)' id='hasName0'  class='form-control'> "+
		"<option value='0' selected='selected'>Has one category</option>"+
		"<option value='1'>Has many categories </option></select>" +
		"<input type='text' placeholder='categorie name' id='categoryName-text0' style='display:none;'   class='form-control  form-edit'/>"+
		"</td>" +

		"<td  id='categoryPrice-row0'>" +
		"<input class='form-control form-edit' type='text' id='categoryPrice-text0" +
		"'></td>"+

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



/*
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
*/


/*
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
*/


// show the category name input
function activeName(no){
	
	 var rep = $("#hasName"+no).val()
	 if(rep == 1){
		 $("#categoryName-text"+no).css("display","block");
		 
	 }else{
		 $("#categoryName-text"+no).css("display","none");
		 $("#categoryName-text"+no).val("");
	 }
	
	
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