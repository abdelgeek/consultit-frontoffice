

function edit_row(no) {
	document.getElementById("edit_button" + no).style.display = "none";
	document.getElementById("delete_button" + no).style.display = "none";

	document.getElementById("save_button" + no).style.display = "inline-block";
	document.getElementById("cancel_button" + no).style.display = "inline-block";

	var country = document.getElementById("country-row" + no);

	var country_data = country.innerHTML;

	country.innerHTML = "<input class='form-control' type='text' id='country-text" + no + "' value='" + country_data + "'>";

}

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


function add_row() {
	/*var new_name=document.getElementById("new_name").value;
	var new_country=document.getElementById("new_country").value;
	var new_age=document.getElementById("new_age").value;
	*/  
	var table = document.getElementById("data-table");
	var table_len = (table.rows.length);
	var row = table.insertRow(1).outerHTML = "<tr>" +
		"<td scope='row' class='text-center'>" +

		"<button  type='button' id='save_button1' value='save' class=' save btn btn-outline-success   waves-effect px-3'>" +
		"<i class='fa fa-save' aria-hidden='true'></i>" +
		"</button>" +

		"<button  onclick='cancel_row(1)'   type='button' id='cancel_button1' value='cancel' class='btn btn-outline-danger waves-effect px-3'>" +
		"<i class='fa fa-times' aria-hidden='true'></i>" +
		"</button>" +


		"</td>" +
		"<td></td>" +
		"<td>" +
		"<input class='required form-control form-edit' type='text' id='country-text' + table_len ></td>" +
		"</tr>";

/* document.getElementById("new_name").value="";
 document.getElementById("new_country").value="";
 document.getElementById("new_age").value="";*/
}