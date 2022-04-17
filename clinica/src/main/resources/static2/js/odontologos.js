window.addEventListener('load', function () {
    (function(){

      const url = 'api/odontologos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
         for(odontologo of data){
         let btnDelete = '<a href="#" onclick="eliminarUsuario('+ odontologo.id + ') class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'

             let odontologoHTML =
               "<tr><td>" +
               odontologo.id +
               "</td><td>" +
               odontologo.nombre +
               " " +
               odontologo.apellido +
               "</td><td>" +
               odontologo.matricula +
               "</td><td>" +
               btnDelete +'</td></tr>';

             listadoHTML += usuarioHTML;


        };
        document.querySelector("#tablaOdontologos tbody").outerHTML = listadoHTML;

    })
    })



    })

