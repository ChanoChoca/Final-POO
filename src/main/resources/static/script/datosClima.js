let key = `cc1e68f5202e8ec9007463838a888486`
let city_name= `junin`;
let boton= document.getElementById(`btn-clima`);

let get_datos=() => {
    let url= `https://api.openweathermap.org/data/2.5/weather?q=${city_name}&appid=${key}&units=metric`
    fetch(url).then((resp)=>resp.json()).then(data =>{
        console.log("la temperatura es: " + (data.main.temr) + `º`);
        console.log(data.weather[0].descripcion);
    })
}
boton.addEventListener(`click`,get_datos);