export class Hijo { 

    constructor(private _hid: number,
        private _nombre: string,
        private _apellidos: string,
        private _fechanacimiento: string,
        private _saldo: number,
        private _email: string,
        private _password: string,
        private _padre: number){
    }

    get hid() {return this._hid;}
    get nombre() {return this._nombre;}
    get apellidos() {return this._apellidos;}
    get fechanacimiento() {return this._fechanacimiento;}
    get saldo() {return this._saldo;}
    get email() {return this._email;}
    get password() {return this._password;}
    get padre() {return this._padre;}

    set hid(hid) {this._hid = hid;}
    set nombre(nombre) {this._nombre = nombre;}
    set apellidos(apellidos) {this._apellidos = apellidos;}
    set fechanacimiento(fechanacimiento) {this._fechanacimiento = fechanacimiento;}
    set saldo(saldo) {this._saldo = saldo;}
    set email(email) {this._email = email;}
    set password(password) {this._password = password;}
    set padre(padre) {this._padre = padre;}

}

