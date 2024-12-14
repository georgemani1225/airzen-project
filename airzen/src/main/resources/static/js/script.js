document.addEventListener('DOMContentLoaded', (event) => {
	const toastElement = document.querySelector('.toastSuccess');
	if (toastElement && toastElement.classList.contains('show')) {
		const duration = 1200;
		setTimeout(() => {
			const toast = new bootstrap.Toast(toastElement);
			toast.hide();
		}, duration);
	}
});


document.getElementById('member-form').addEventListener('submit', function() {
	document.getElementById('tierEnable').disabled = false;
});
