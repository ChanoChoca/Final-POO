// Asegúrate de que el DOM esté completamente cargado antes de ejecutar el script
document.addEventListener('DOMContentLoaded', (event) => {
    // Obtén los elementos del formulario
    let desde = document.getElementById('desde');
    let hasta = document.getElementById('hasta');
    let precio = document.getElementById('precio-alquiler');

    console.log(precio);
    console.log(desde);
    console.log(hasta);

    // Asegúrate de que los elementos existen antes de continuar
    if (desde && hasta && precio) {
        // Añade un controlador de eventos para cuando cambien las fechas
        desde.addEventListener('change', calcularPrecioTotal);
        hasta.addEventListener('change', calcularPrecioTotal);

        function calcularPrecioTotal() {
            // Asegúrate de que ambas fechas están establecidas
            if (desde.value && hasta.value) {
                // Calcula la diferencia en días entre las dos fechas
                let fechaDesde = new Date(desde.value);
                let fechaHasta = new Date(hasta.value);
                let diferencia = Math.abs(fechaHasta - fechaDesde);
                let dias = Math.ceil(diferencia / (1000 * 60 * 60 * 24));

                // Calcula el precio total
                let precioTotal = (dias + 1) * parseFloat(precio.textContent);
                console.log(precioTotal);

                // Muestra el precio total
                document.getElementById('total-precio').textContent = 'Precio Total: ' + precioTotal;
            }
        }
    }
});
