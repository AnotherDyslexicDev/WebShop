function showError(message) {
	Swal.fire({
		icon: 'error',
		title: 'Error',
		text: message
	});
}
document.addEventListener("DOMContentLoaded", function() {
	let decrementButtons = document.querySelectorAll('.decrement-btn');
	let incrementButtons = document.querySelectorAll('.increment-btn');
	decrementButtons.forEach(function(button) {
		button.addEventListener('click', function() {
			// Seleccionamos el input correspondiente al botón pulsado
			var input = button.parentElement.querySelector('input[type="number"]');
			var currentValue = parseInt(input.value);
			if (currentValue > 1) {
				input.value = currentValue - 1;
			}
		});
	});
	incrementButtons.forEach(function(button) {
		button.addEventListener('click', function() {
			// Seleccionamos el input correspondiente al botón pulsado
			var input = button.parentElement.querySelector('input[type="number"]');
			var currentValue = parseInt(input.value);
			input.value = currentValue + 1;
		});
	});
});

		// Ocultar el mensaje después de 3 segundos
		setTimeout(function(){
			$(".alert").fadeOut(500);
		}, 3000);
