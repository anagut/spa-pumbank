document.getElementById('accederbtn').onclick = (function (evnt) {
    // console.log(evnt);
    evnt.preventDefault();

    document.querySelectorAll('.error').forEach(elem => {
        elem.classList.add('esconder');
    });

    let formValid = document.getElementById('transferForm').checkValidity();

    if (formValid) {
        //ENVIAR
        let papi = {
            nombre: document.getElementById('nombre_niño_paga').value,
            cant: document.getElementById('cant').value,
            datosbanc: document.getElementById('datosbanc').value,
            mes: document.getElementById('mes').value,
            año: document.getElementById('año').value,
            CVV: document.getElementById('CVV').value
        }

        $.ajax({
            method: "POST",
            url: "http://www.mocky.io/v2/5bd9731d2f00005e0006d11d",//caso true
            // url: "http://www.mocky.io/v2/5bd9777d2f0000790006d14c",//caso false

        }).done(function (data) {
            console.log(data);
            if (data.result) {
                alert("Ha realizado una transferencia puntual a " + papi.nombre + " de " + papi.cant + "€.")
                window.location.href = 'homepage_sr.html';
            } else {
                //mensaje de error
                document.getElementById('mensaje').classList.remove('esconder');
            }
        });

    } else {

        if (!document.getElementById('cant').checkValidity()) {
            document.getElementById('errorcant').classList.remove('esconder');
        }

        if (!document.getElementById('datosbanc').checkValidity()) {
            document.getElementById('errorbanc').classList.remove('esconder');
        }

        if (!document.getElementById('mes').checkValidity()) {
            document.getElementById('errormes').classList.remove('esconder');
        }

        if (!document.getElementById('CVV').checkValidity()) {
            document.getElementById('errorCVV').classList.remove('esconder');
        }

        if (!document.getElementById('frecuencia').checkValidity()) {
            document.getElementById('errorfrec').classList.remove('esconder');
        }


    }
});

document.getElementById('cancelar_paga').onclick = function (evnt){
    evnt.preventDefault();
    window.location.href = "./homepage_sr.html"
}