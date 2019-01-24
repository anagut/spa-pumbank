export class Paga { 

    constructor(private _pgid: number,
        private _cantidad: number,
        private _frecuenciadias: number,
        private _pid: number,
        private _hid: number,
        ){
    }

    get pgid() {return this._pgid;}
    get cantidad() {return this._cantidad;}
    get frecuenciadias() {return this._frecuenciadias;}
    get pid() {return this._pid;}
    get hid() {return this._hid;}

    set pgid(pgid) {this._pgid = pgid;}
    set cantidad(cantidad) {this._cantidad = cantidad;}
    set frecuenciadias(frecuenciadias) {this._frecuenciadias = frecuenciadias;}
    set pid(pid) {this._pid = pid;}
    set hid(hid) {this._hid = hid;}

}
