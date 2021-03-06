window.addEventListener('load', function () {
        (function () {
            const url = 'api/pacientes';
            const settings = {
                method: 'GET',
            }

            fetch(url, settings)
                .then(response => response.json())
                .then(data => {

                    for (paciente of data) {
                        var selectElement = document.querySelector("#paciente");
                        selectElement.appendChild(new Option(paciente.nombre + " " + paciente.apellido, paciente));
                    }
                })
        })

        (function () {
            let pathname = window.location.pathname;
            if (pathname == "/turnoList.html") {
                document.querySelector(".nav .nav-item a:last").addClass("active");
            }
        })
    });