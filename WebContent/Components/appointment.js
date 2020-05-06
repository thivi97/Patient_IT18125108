$(document).ready(function() {

	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}

	$("#alertError").hide();
});

$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {

		$("#alertError").text(status);
		$("#alertError").show();

		return;
	}

	var type = ($("#hidAppIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "AppointmentAPI",
		type : type,
		data : $("#formItem").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});

	// $("#formItem").submit();

});

function onItemSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#formItem")[0].reset();
}
$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "AppointmentAPI",
		type : "DELETE",
		data : "PID=" + $(this).data("pid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});

function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}








$(document)
		.on("click",".btnUpdate",function(event) {
					$("#hidAppIDSave").val(
							$(this).closest("tr").find('#hidAppIDUpdate')
									.val());
					$("#appointmentid").val(
							$(this).closest("tr").find('td:eq(0)').text());
					$("#doctorid").val(
							$(this).closest("tr").find('td:eq(1)').text());
					$("#doctorName").val(
							$(this).closest("tr").find('td:eq(2)').text());
					$("#patientid")
							.val($(this).closest("tr").find('td:eq(3)').text());
					$("#patientName").val(
							$(this).closest("tr").find('td:eq(4)').text());
					$("#hospitalName").val(
							$(this).closest("tr").find('td:eq(5)').text());
					$("#date").val(
							$(this).closest("tr").find('td:eq(6)').text());

				});

// CLIENT-MODEL================================================================
function validateItemForm() {
	// holderName
	if ($("#appointmentid").val().trim() == "") {

		return "Insert appointmentid.";
	}
	if ($("#doctorid").val().trim() == "") {

		return "Insert doctorid.";
	}
	if ($("#doctorName").val().trim() == "") {

		return "Insert doctorName.";
	}
	if ($("#patientid").val().trim() == "") {

		return "Insert patientid.";
	}
	if ($("#patientName").val().trim() == "") {

		return "Insert patientName.";
	}
	if ($("#hospitalName").val().trim() == "") {

		return "Insert hospitalName.";
	}
	if ($("#date").val().trim() == "") {

		return "Insert date.";
	}
	

	
	
	return true;
	
	
}