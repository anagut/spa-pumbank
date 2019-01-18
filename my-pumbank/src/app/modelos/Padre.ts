export class Padre {

    constructor(private _pid: number, 
        private _nombre: string,
        private _apellidos: string,
        private _email: string,
        private _fechanacimiento: string,
        private _tarjetacredito: number,
        private _cvv: number,
        private _password: string,
        private _mescaducidad: number,
        private _yearcaducidad: number,
        private _hijos: string) {
    }

    get pid() {return this._pid;}
    get nombre() {return this._nombre;}
    get apellidos() {return this._apellidos;}
    get email() {return this._email;}
    get fechanacimiento() {return this._fechanacimiento;}
    get tarjetacredito() {return this._tarjetacredito;}
    get cvv() {return this._cvv;}
    get password() {return this._password;}
    get mescaducidad() {return this._mescaducidad;}
    get yearcaducidad() {return this._yearcaducidad;}
    get hijos() {return this._hijos;}

    set pid(pid) {this._pid = pid;}
    set nombre(nombre) {this._nombre = nombre;}
    set apellidos(apellidos) {this._apellidos = apellidos;}
    set email(email) {this._email = email;}
    set fechanacimiento(fechanacimiento) {this._fechanacimiento = fechanacimiento;}
    set tarjetacredito(tarjetacredito) {this._tarjetacredito = tarjetacredito;}
    set cvv(cvv) {this._cvv = cvv;}
    set password(password) {this._password = password;}
    set mescaducidad(mescaducidad) {this._mescaducidad = mescaducidad;}
    set yearcaducidad(yearcaducidad) {this._yearcaducidad = yearcaducidad;}
    set hijos(hijos) {this._hijos = hijos;}

}
