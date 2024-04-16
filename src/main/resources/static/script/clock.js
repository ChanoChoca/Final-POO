class Clock {
    constructor(container) {
        this.container = container;
    }


    start() {
        this.updateClock();
        // Actualiza el reloj cada segundo
        this.interval = setInterval(() => {
            this.updateClock();
        }, 1000);
    }

    // Método para actualizar el reloj
    updateClock() {
        const currentTime = new Date();
        const hours = currentTime.getHours();
        const minutes = currentTime.getMinutes();
        const seconds = currentTime.getSeconds();
        const timeString = `${this.padZero(hours)}:${this.padZero(minutes)}:${this.padZero(seconds)}`;
        this.container.textContent = timeString;
    }

    // Método para añadir un cero delante de un número si es necesario
    padZero(num) {
        return (num < 10 ? '0' : '') + num;
    }
}

/*
function updateClock() {
    var now = new Date();
    var hours = now.getHours();
    var minutes = now.getMinutes();
    var seconds = now.getSeconds();

    // Formatear los números de un solo dígito con un cero a la izquierda
    hours = ('0' + hours).slice(-2);
    minutes = ('0' + minutes).slice(-2);
    seconds = ('0' + seconds).slice(-2);

    // Construir la cadena de tiempo
    var timeString = hours + ':' + minutes + ':' + seconds;

    // Actualizar el contenido del elemento 'clock' con la hora actual
    document.getElementById('clock').innerHTML = timeString;
}

// Llamar a la función updateClock() para establecer el tiempo inicial
updateClock();

// Llamar a la función updateClock() cada segundo para mantener el reloj actualizado
setInterval(updateClock, 1000);
*/