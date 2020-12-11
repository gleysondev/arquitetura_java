package pacote2


fun main(args: Array<String>) {
    val num: Int = 100;

    for (i in 80..100) {
        println(i)
    }
    println("Decremental")
    for (i in 100.downTo(80)) {
        println(i)
    }

    /*
    for(n in 100.downTo(80)){
        println(n)
    }
    */


}


fun receboValorDouble(valor: Double) {
    println("Valore recebido:: " + valor)
}

