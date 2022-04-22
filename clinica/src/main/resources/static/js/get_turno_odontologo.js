window.addEventListener('load', function () {
    (function() {
            const url = 'api/odontologos';
            const settings = {
                method: 'GET'
            }

            fetch(url, settings)
                .then(response => response.json())
                .then(data => {
                    for (odontologo of data) {
                        var selectElement2 = document.querySelector("#odontologo");
                        selectElement2.appendChild(new Option(odontologo.nombre + " " + odontologo.apellido, odontologo.id));
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