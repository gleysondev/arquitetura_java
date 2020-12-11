package palavrasreservados

import palavrasreservados.modificadoracesso.Filho
import palavrasreservados.modificadoracesso.Pai

fun main(){
    println("Iniciando exemplos de palavras reservadas");

    var endereco = Endereco()
    endereco.name="Novo endereco"

    var filho= Filho();
    filho.endereco=endereco;
    filho.endereco2=endereco

    println(filho.endereco.name)

    println(filho.endereco2.name)
    var num = filho.somar(10,20);

    println(num)
}