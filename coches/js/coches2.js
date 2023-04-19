// Api Coches


function limpiar() {

    const inputModelo = document.getElementById("modelo");
    const inputMarca = document.getElementById("marca");
    const inputPais = document.getElementById("pais");
    inputModelo.value = "";
    inputMarca.value = "";
    inputPais.value = "";
}

// Api Coches


window.addEventListener("load", () => {
    const element = document.getElementById("peticion")
      element.addEventListener("click", async (event) => {
          event.preventDefault();
          const inputModelo = document.getElementById("modelo");
          const inputMarca = document.getElementById("marca");
          const inputPais = document.getElementById("pais");
          //variable donde vamos a guardar la informacion
          const modeloCoche = inputModelo.value.trim();
          const marcaCoche = inputMarca.value.trim();
          const paisCoche = inputPais.value.trim();//eliminamos los espacios blancos
          const apiUrl = `http://127.0.0.1:9090/api/coches2?modelo=${modeloCoche}&marca=${marcaCoche}&pais=${paisCoche}`;//llamamos a la url
          const spinner = document.getElementById("spinner");
          spinner.style.display = "block";
          let respuesta = await fetch(apiUrl)
          console.log(respuesta)
          let res = await respuesta.json()
          console.log(res)
  
          let listaCoches = ""//donde vamos a guardar los datos
          for (let i = 0; i < res.length; i++) {//bucle para que pasen todos los coches
              let coche = res[i];
              const cocheModelo = coche.modelo;
              const cocheMarca = coche.marca;
              const cochePais = coche.pais;
              const cochePrecio = coche.precio;
              const cocheFotos = coche.fotos;
              listaCoches += `
          <p>Modelo: ${cocheModelo}</p>
          <p>Marca: ${cocheMarca}</p>
          <p>Pais: ${cochePais}</p>
          <p>Precio: ${cochePrecio}</p>
          <p>Fotos:<img src="${cocheFotos}" width="50px" height="50px"></p>`
  
          }
  
  
          const contenedor = document.getElementById("coches")
          let elemento = document.createElement("div");
          contenedor.innerHTML = listaCoches;
          contenedor.appendChild(elemento);
  
          //para mostrar en el html
  
          spinner.style.display = "none";
  
  
      })
  })