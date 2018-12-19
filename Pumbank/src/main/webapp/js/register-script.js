// Register 1 Datos Padre

$('#registerBtn').click(function (evnt) {
    evnt.preventDefault();

    document.querySelectorAll('.error').forEach(elem => {
        elem.classList.add('esconder');
    });

    let formValid = document.getElementById('register_form').checkValidity();

    let passEqs = validatePassword();
    console.log("passEqs:", passEqs);

    let emailEqs = validateEmail();
    console.log("emailEqs:", emailEqs);

    if (formValid && emailEqs && passEqs) {
        let registro1 = {
            nombre: document.getElementById('nombre').value,
            apellido1: document.getElementById('apellido1').value,
            apellido2: document.getElementById('apellido2').value,
            email: document.getElementById('email').value,
            birthdate: document.getElementById('birthdate').value,
            password: document.getElementById('password').value,
        };

        $.ajax({
            method: "POST",
            url: "http://www.mocky.io/v2/5bd978b52f00006b0006d15c",
            // result : true . http://www.mocky.io/v2/5bd978b52f00006b0006d15c
            // result: false . http://www.mocky.io/v2/5bd977d92f0000570006d15a
            data: registro1
        }).done(function (resp) {
            console.log(resp)
            if (resp.result) {
                window.location.href = 'register2.html'
            }
            else {
                document.getElementById('mensaje').classList.remove('esconder')
            }
        });

    } else {


        if (!document.getElementById('nombre').checkValidity()) {
            document.getElementById('errorUsername').classList.remove('esconder');
        }

        if (!document.getElementById('password').checkValidity()) {
            document.getElementById('errorPassword').classList.remove('esconder');
        }

        if (!document.getElementById('birthdate').checkValidity()) {
            document.getElementById('errorBirth').classList.remove('esconder');
        }

        if (!emailEqs) {
            document.getElementById('emailNoEqs').classList.remove('esconder');

        }

        if (!passEqs) {
            document.getElementById('passNoEqs').classList.remove('esconder')
        }

    }


});

function validatePassword() {
    var password = document.getElementById('password')
        , confirm_password = document.getElementById('conf_password');

    if (password.value != confirm_password.value) {
        return false;
    } else {
        return true;
    }
}

function validateEmail() {
    var email = document.getElementById('email')
        , confirm_email = document.getElementById('conf_email');

    if (email.value != confirm_email.value) {
        return false;
    } else {
        return true;
    }
}



// Register 2 (tarjeta de credito)

$('#backBtn').click(function () {
    window.location.href = 'register.html'
});




$('#nextBtn2').click(function (evnt) {
    evnt.preventDefault();

    document.querySelectorAll('.error').forEach(elem => {
        elem.classList.add('esconder');
    });

    let formValid = document.getElementById('register_form2').checkValidity();

    if (formValid) {
        let registro2 = {
            ccType: document.getElementById('creditcard_type').value,
            ccNumber: document.getElementById('creditcard').value,
            ccExpiryMonth: document.getElementById('cc_exp_month').value,
            ccExpiryYear: document.getElementById('cc_exp_year').value,
            cvv: document.getElementById('cvv').value,
        };

        $.ajax({
            method: "POST",
            url: "http://www.mocky.io/v2/5bd978b52f00006b0006d15c",
            // result : true . http://www.mocky.io/v2/5bd978b52f00006b0006d15c
            // result: false . http://www.mocky.io/v2/5bd977d92f0000570006d15a
            data: registro2
        }).done(function (resp) {
            console.log(resp)
            if (resp.result) {
                window.location.href = 'register3.html'
            }
            else {
                document.getElementById('mensaje').classList.remove('esconder')
            }
        });

    } else {

        if (!document.getElementById('creditcard').checkValidity()) {
            document.getElementById('creditcarderror').classList.remove('esconder');
        }


        if (!document.getElementById('cvv').checkValidity()) {
            document.getElementById('errorcvv').classList.remove('esconder');
        }

    };



});

// Register 3 (Hijos)

$('#backBtn2').click(function () {
    window.location.href = 'register2.html'
});

$('#nextBtn3').click(function () {
    window.location.href = 'homepage_sr.html'
});

let htmlHijos = '';

function addHijoHtml(paramElemid, unHijo) {



    htmlHijos = `<li id="Hijo_${unHijo.nombre}" class="row"><div class="col-6">
    <div>Nombre: ${unHijo.nombre}</div>
    <div id="${unHijo.email}">Correo Electrónico: ${unHijo.email}</div></div>       
    <div class="col-3"><button class="codigoBtn" data-value="${unHijo.email}">Enviar Código</button></div>
    <div class="col-3"><button class="eliminarBtn" data-li="Hijo_${unHijo.nombre}">Eliminar</button></div>      
    </li>`;

    $(paramElemid).append(htmlHijos);


}

$('#addBtn').click(function (evnt) {
    evnt.preventDefault();

    document.querySelectorAll('.error').forEach(elem => {
        elem.classList.add('esconder');
    });

    let formValid = document.getElementById('addForm').checkValidity();



    if (formValid) {
        let unHijo = {
            nombre: document.getElementById('nombre').value,
            nacimiento: document.getElementById('birthdate').value,
            email: document.getElementById('email').value,
        };



        //ENVIAR
        $.ajax({
            method: "POST",
            url: "http://www.mocky.io/v2/5bd9731d2f00005e0006d11d",//caso true
            // url: "http://www.mocky.io/v2/5bd9777d2f0000790006d14c",//caso false
            data: unHijo
        }).done(function (resp) {
            console.log(resp);
            if (resp.result) {
                addHijoHtml('#hijos', unHijo);

                document.getElementById('addForm').reset();

                let codigoBtns = document.getElementsByClassName('codigoBtn')
                let eliminarBtns = document.getElementsByClassName('eliminarBtn')

                console.log(codigoBtns);
                console.log(eliminarBtns);


                // PROBLEMA: SE ACUMULAN LOS NIÑOS

                for (let index = 0; index < codigoBtns.length; index++) {
                    codigoBtns[index].onclick = function () {
                        let emailBtn = this.getAttribute('data-value');
                        let infoEmail = document.getElementById(emailBtn).innerHTML;
                        alert('El código de activación se ha enviado al ' + infoEmail);
                    }
                }



                for (let index = 0; index < eliminarBtns.length; index++) {
                    eliminarBtns[index].onclick = function () {
                        let elIdLi = this.getAttribute("data-li");
                        removeElement(elIdLi)

                    }

                }

            } else {

            }
        });

    } else {

        if (!document.getElementById('nombre').checkValidity()) {
            document.getElementById('errorUsername').classList.remove('esconder');
        }

        if (!document.getElementById('birthdate').checkValidity()) {
            document.getElementById('errorBirth').classList.remove('esconder');
        }

        if (!emailEqs) {
            document.getElementById('emailNoEqs').classList.remove('esconder');

        }
    }
});


function removeElement(id) {
    var elem = document.getElementById(id);
    return elem.parentNode.removeChild(elem)
}


