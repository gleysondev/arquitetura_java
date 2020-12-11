package palavrasreservados.modificadoracesso

import palavrasreservados.Endereco

class Filho : Pai(){
    fun somar(a: Int, b: Int): Int {
        return soma(a,b);
    }
    var endereco: Endereco= Endereco()
    // getter
    get() = field

    // setter
    set(value) {
        field = value
    }

    var endereco2: Endereco= Endereco()
        // getter
        get() = field

        // setter
        set(value) {
            field = value
        }
}

