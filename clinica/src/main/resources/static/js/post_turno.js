window.addEventListener('load', function() {

    const formulario = document.querySelector('#add_new_turno');

    formulario.addEventListener('submit', function(event) {

        const formData = {
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value,
            paciente: document.querySelector("#paciente").value,
            odontologo: document.querySelector("#odontologo").value,
        };

        // Invocamos utilizando la función fetch le API turnos con el método POST que guardará el turno que enviaremos en formato JSON
        const url = 'api/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 // Si no hay ningun error se muestra un mensaje diciendo que el turno se agrego bien
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                 '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                 '<strong></strong> Turno agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            }).catch(error => {
                 // Si hay algun error se muestra un mensaje diciendo que el turno no se pudo guardar y se intente nuevamente
                 let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                  '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                  '<strong> Error intente nuevamente</strong> </div>'

                 document.querySelector('#response').innerHTML = errorAlert;
                 document.querySelector('#response').style.display = "block";

                 // Se dejan todos los campos vacíos por si se quiere ingresar otro turno
                 resetUploadForm();
            });
    });

    function resetUploadForm(){
        document.querySelector('#fecha').value = "";
        document.querySelector('#hora').value = "";
        document.querySelector('#paciente > option').value = "";
        document.querySelector('#odontologo > option').value = "";
    }

    (function(){
        let pathname = window.location.pathname;
        if (pathname === "/") {
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/turnoList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});