window.addEventListener('load', function () {
    (function(){
      const url = 'api/pacientes';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
      //recorremos la colección de pacientes del JSON
         for(paciente of data){
            //por cada paciente armaremos una fila de la tabla
            var table = document.getElementById("pacienteTable");
            var pacienteRow =table.insertRow();
            let tr_id = 'tr_' + paciente.id;
            pacienteRow.id = tr_id;

            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                      ' type="button" onclick="deleteBy('+paciente.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                      ' type="button" onclick="findBy('+paciente.id+')" class="btn btn-info btn_id">' +
                                      paciente.id +
                                      '</button>';


            pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_email\">' + paciente.email + '</td>' +
                    '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                    '<td class=\"td_fechaIngreso\">' + new Date(paciente.fechaIngreso).toISOString().slice(0,10)+ '</td>' +
                    '<td class=\"td_domicilio\"> Calle ' + paciente.domicilio.calle + ' ' + paciente.domicilio.numero + '</td>' +

                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/pacienteList.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })

                    function formatDate(NewDtime) {
                            var dt = new Date(parseInt(NewDtime.slice(6, 19)));
                            var year = dt.getFullYear();
                            var month = dt.getMonth() + 1;
                            var date = dt.getDate();
                            var hour = dt.getHours();
                            var minute = dt.getMinutes();
                            var second = dt.getSeconds();
                            return year + "/" + month + "/" + date + "/" + hour+ "/" + minute+ "/" + second;
                        }