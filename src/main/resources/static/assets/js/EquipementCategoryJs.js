/**
 * 
 */




//-----------------------
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

		"<td id='countryName-row0'> " +
		"<select id='countryName-text0' class='form-control'>" +
		" <option>Botswana</option>" +
		"<option>Burundi</option>" +
		"</select>" +
		"</td>" +
		
		"<td id='categoryName-row0'> " +
		"<select id='categoryName-text0' class='form-control'>" +
		" <option>Botswana A</option>" +
		"<option>Botswana B</option>" +
		"</select>" +
		"</td>" +

		

		"<td  id='link-row0'>" +
		"<input class='form-control form-edit' type='text' id='link-text0" +
		"'></td>" +

		
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
