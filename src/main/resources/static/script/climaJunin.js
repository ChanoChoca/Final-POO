let key = `cc1e68f5202e8ec9007463838a888486`;
let city_name =`junin`;

let resultado=document.getElementById(`resultado-clima`);
let get_datos=() => {
    let url= `https://api.openweathermap.org/data/2.5/weather?q=${city_name}&appid=${key}&units=metric`;
    fetch(url).then((resp)=>resp.json()).then(data =>{
        console.log("la temperatura es: " + (data.main.temp) + `º`);
        console.log(data.weather[0].descripcion);
        console.log(data);
        resultado.innerHTML=
            `<h2>La temperatura en la ciudad de ${data.name} es: ${data.main.temp}º</h2>`
    })
}
window.onload = get_datos;
