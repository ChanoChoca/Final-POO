let key = `cc1e68f5202e8ec9007463838a888486`;
let ciudad = document.getElementById(`city`);
let boton= document.getElementById(`btn-clima`);
let resultado=document.getElementById(`resultado-clima`);
let get_datos=() => {
    let city_name = ciudad.value;
    let url= `https://api.openweathermap.org/data/2.5/weather?q=${city_name}&appid=${key}&units=metric`;
    fetch(url).then((resp)=>resp.json()).then(data =>{
        console.log("la temperatura es: " + (data.main.temp) + `º`);
        console.log(data.weather[0].descripcion);
        console.log(data);
        resultado.innerHTML= `<h2>${data.name}</h2>
        <h1>${data.main.temp}º</h1>
        <h4>${data.weather[0].descripcion}</h4>
        `
    })
}
boton.addEventListener(`click`,get_datos);