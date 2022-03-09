document.addEventListener("DOMContentLoaded",()=> {
    query()
})

function query (){
   fetch("http://localhost:8080/ServicioRest/webresources/Equipo")
           .then(data => {
               return data.json()
           }).then(response => {
               insertData(response)
           })
    
} 

function insertData(entidad){
    const parrafo = document.querySelector("#id")
    parrafo.textContent = entidad
}

