let datos_cong = [];

(function () {
    $.ajax({
        //url: "http://www.mocky.io/v2/5be04ef432000076006495ba", //congelada
        url: "http://www.mocky.io/v2/5be051db3200005a006495cf", //no congelada


    }).done(function (resp) {
        console.log("done:", resp);
        datos_cong = resp;
        console.log(datos_cong.congelado)
        console.log(datos_cong);

        if (datos_cong.congelado) {
            document.getElementById('cuentabloqueada').innerHTML += `<div>TU CUENTA HA SIDO BLOQUEADA DESDE EL ${datos_cong.fecha_inicio} HASTA EL ${datos_cong.fecha_fin}</div>`;
        }

    }).fail(function (error) {
        console.log("error:", error);
    })
})()



$('#realizarpago').click(function () {
    if (datos_cong.congelado) {
        alert("No puedes realizar pago, tu cuenta está bloqueada desde el " + datos_cong.fecha_inicio + " hasta el " + datos_cong.fecha_fin + '.')
    } else {
        window.location.href = "./realizarpago.html"
    }
}
)

$('#transferencias').click(function () {
    if (datos_cong.congelado) {
        alert("No puedes realizar transferencia, tu cuenta está bloqueada desde el " + datos_cong.fecha_inicio + " hasta el " + datos_cong.fecha_fin + '.')
    } else {
        window.location.href = "./transferencias.html"
    }
}
)



