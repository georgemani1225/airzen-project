document.getElementById('member-form').addEventListener('submit', function() {
	document.getElementById('tierEnable').disabled = false;
});

document.getElementById('ctrySelect').addEventListener('change', function() {
	var selectedISDCode = this.value;
	document.querySelector('.isdcod1').value = selectedISDCode;
	document.querySelector('.isdcod2').value = selectedISDCode;
});


document.querySelectorAll('.phone-input').forEach(function(input) {
	input.addEventListener('input', function() {
		this.value = this.value.replace(/[^0-9]/g, '');
	});
});

$('#date').datepicker({
	autoclose: true,
	endDate: '0d',
	format: 'dd-M-yyyy'
})


$(document).ready(function() {
	$('#addDocumentBtn').on('click', function() {
		var newRow = `
	            <tr>
	                <td>
					    <select name="docType" class="dType">
						    <option value="">Select One</option>
						    <option value="Passport">Passport</option>
						    <option value="Driving License">Driving License</option>
						    <option value="Voters ID">Voters ID</option>
					    </select>
	                </td>
	                <td>
					    <input type="file" class="form-control file-input" id="file" name="data" accept="application/pdf">
	                </td>
	                <td>
	                    <button type="button" class="btn btn-danger removeRowBtn">Remove</button>
	                </td>
	            </tr>
	        `;
		$('#documentTable tbody').append(newRow);
	});


	$(document).on('click', '.removeRowBtn', function() {
		$(this).closest('tr').remove();
	});

	$('#uploadForm').on('submit', function(event) {
		event.preventDefault();

		var isValid = true;
		var formData = new FormData(this);

		if ($('#documentTable tbody tr').length === 0) {
			alert('Please add at least one document before uploading.');
			isValid = false;
			return;
		}

		$('.file-input').each(function() {
			var fileInput = $(this);
			var file = fileInput[0].files[0];
			var maxSize = 5 * 1024 * 1024;

			if (!file) {
				alert('Please select a file');
				isValid = false;
				return;
			}


			else if (file.type !== 'application/pdf') {
				alert('Only PDF files are allowed.');
				isValid = false;
				return;
			}

			else if (file.size > maxSize) {
				alert('File size must be less than 5 MB.');
				isValid = false;
				return;
			}
		});

		if (isValid) {
			$.ajax({
				url: $(this).attr('action'),
				type: 'POST',
				data: formData,
				contentType: false,
				processData: false,
				success: function(response) {
					$('#uploadModal').modal('hide');
					alert("Upload Successful");
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.error("Upload failed: " + textStatus + ", " + errorThrown);
				}
			});
		}
	});


});


function deleteDocument(docId) {
	const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
	const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
	if (confirm('Are you sure you want to delete this document?')) {
		fetch(`/airzen/delete/document/${docId}`, {
			method: 'DELETE',
			headers: {
				[csrfHeader]: csrfToken
			},
		}).then(response => {
			if (response.ok) {
				location.reload();
			} else {
				alert('Failed to delete document');
			}
		});
	}
}






