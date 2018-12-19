$('#cancelar_congelar').click(function (evnt) {
    evnt.preventDefault();
    window.location.href= "./homepage_sr.html"
})

$('#confirmar_congelar').click(function (evnt) {
    evnt.preventDefault();

    document.querySelectorAll('.error').forEach(elem => {
        elem.classList.add('esconder');
    });

    let formValid = document.getElementById('congelarniño').checkValidity();

    if (formValid) {
        let congelaruser = {
            nombre_niño: document.getElementById('nombre_niño').value,
            fecha_inicio: document.getElementById('fecha_inicio').value,
            fecha_fin: document.getElementById('fecha_fin').value
        };

        //ENVIAR
        $.ajax({
            method: "POST",
            url: "http://www.mocky.io/v2/5bd9731d2f00005e0006d11d",//caso true
            // url: "http://www.mocky.io/v2/5bd9777d2f0000790006d14c",//caso false
            
        }).done(function (resp) {
            console.log(resp)
            if (resp.result) {
                alert('La cuenta de '+congelaruser.nombre_niño+' ha sido congelada desde el '+congelaruser.fecha_inicio+" hasta el "+congelaruser.fecha_fin)
                window.location.href= "./homepage_sr.html";

            } else {
                //mensaje de error
                document.getElementById('error').classList.remove('esconder');
            }
        });

    } else {

        if (!document.getElementById('nombre_niño').checkValidity()) {
            document.getElementById('nombre_niño_error').classList.remove('esconder');
        }

        if (!document.getElementById('fecha_inicio').checkValidity()) {
            document.getElementById('fecha_inicio_error').classList.remove('esconder');
        }

        if (!document.getElementById('fecha_fin').checkValidity()) {
            document.getElementById('fecha_fin_error').classList.remove('esconder');
        }
    }

});