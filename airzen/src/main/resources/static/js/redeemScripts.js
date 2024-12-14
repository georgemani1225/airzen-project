document.querySelector('.btnCalculate').addEventListener('click', function(event) {
	event.preventDefault();

	const partnerCode = document.querySelector('.partner-select').value;
	const days = document.querySelector('.day-count').value;
	const guests = document.querySelector('.guest-count').value;

	if (!partnerCode || !days || !guests) {
		alert("Please fill all required fields.");
		return;
	}

	fetch(`/airzen/redeem/calculatePoints?partnerCode=${partnerCode}&days=${days}&guests=${guests}`)
		.then(response => response.json())
		.then(data => {
			document.querySelector('.ttlrdmpnts').value = data;
		})
		.catch(error => console.error('Error:', error));
});



function updatePartnerName() {

	const partnerCode = document.querySelector('.partner-select').value;

	fetch(`/airzen/redeem/partnerCode?partnerCode=${partnerCode}`)
		.then(response => response.json())
		.then(data => {
			document.querySelector('.partner-name').value = data.ptrnam;
		})
		.catch(error => console.error('Error:', error));
}

