let addButton = document.getElementById("add")
addButton.addEventListener("click", addCoche)
function addCoche() {
    console.log("hay que añadir el Coche")
    let modelo = document.getElementById("modelo").value
    let marca = document.getElementById("marca").value
    let precio= document.getElementById("precio").value
    console.log(modelo)
    console.log(marca)
    console.log(precio)
    let datos = { modelo: modelo, marca: marca,precio:precio }
    service.add(datos).then(result => {
        if (result.error) {
            console.log("error añadido")
        } else {
            console.log("coche añadido correctamente")
        }

    })

}

service.getAll().then(data => {
    let Coches = JSON.parse(data.data)
    console.log(Coches)
    let tabla = document.getElementById("coches")
    tabla.innerHTML = " "
    for (let coches of Coches) {
        let fila = tabla.insertRow(-1)
        let celda_id = fila.insertCell(-1)

        celda_id.innerHTML = coches.id
        let celda_modelo = fila.insertCell(-1)
        celda_modelo.innerHTML = coches.modelo
        let celda_marca = fila.insertCell(-1)
        celda_marca.innerHTML = coches.marca
    }

})
let updateButton = document.getElementById("update")
updateButton.addEventListener("click", updateCoche)
function updateCoche() {
    console.log("hay que modificar el coche")
    let modelo = document.getElementById("modelo").value
    let marca = document.getElementById("marca").value
    let precio = document.getElementById("precio").value
    let id = document.getElementById("id").value
    let datos = { id: id, modelo:modelo, marca:marca,precio:precio }

    service.update(id, datos).then(result => {
        if (result.error) {
            console.log("error modificado")
        } else {
            console.log("coche modificado correctamente")
        }

    })

}
let deleteButton = document.getElementById("delete")
deleteButton.addEventListener("click", deleteCoche)
function deleteCoche() {
    console.log("hay que eliminar el coche")
   let id = document.getElementById("id").value
   service.remove(id).then(result => {
        if (result.error) {
            console.log("error no eliminado")
        } else {
            console.log("coche eliminado correctamente Vendido")
        }

    })

}
