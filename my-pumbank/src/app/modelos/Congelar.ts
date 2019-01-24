export class Congelar { 

    constructor(private _cid: number,
        private _fechainicio: number,
        private _fechafin: number,
        private _pid: number,
        private _hid: number,
        ){
    }

    get cid() {return this._cid;}
    get fechainicio() {return this._fechainicio;}
    get fechafin() {return this._fechafin;}
    get pid() {return this._pid;}
    get hid() {return this._hid;}

    set cid(cid) {this._cid = cid;}
    set fechainicio(fechainicio) {this._fechainicio = fechainicio;}
    set fechafin(fechafin) {this._fechafin = fechafin;}
    set pid(pid) {this._pid = pid;}
    set hid(hid) {this._hid = hid;}

}
