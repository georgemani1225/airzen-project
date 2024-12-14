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


$(".s1nextBtn").click(function() {
	$(".personal").removeClass("active");
	$(".contact").removeClass("active");
	$(".preference").addClass("active");
	$(".document").addClass("active");
});

$(".s2backBtn").click(function() {
	$(".personal").addClass("active");
	$(".contact").addClass("active");
	$(".preference").removeClass("active");
	$(".document").removeClass("active");
});

$('#date').datepicker({
	autoclose: true,
	endDate: '0d',
	format: 'dd-M-yyyy'
})


