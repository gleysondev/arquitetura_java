package pacote2

fun main(args: Array<String>) {
    val PI = 3.144564546544654 //final - imutavel
    var nome = " Gleyson Sampaio "
    nome=nome.trim();

    var nomeCompleto = nome.plus(" Oliveira")
    //
    println("Meu nome completo é $nomeCompleto") //interpolação

    var primeiroNome = nomeCompleto.substring(7)

    println("O primeiro nome de $nomeCompleto é $primeiroNome") //interpolação

    var subNome:CharSequence=nome.subSequence(0,7)

    //split NÃO retorna Array
    var palavras:List<String> = nomeCompleto.split(" ")

    var charNome = charArrayOf('G','s','o')

    var sigla = String(charNome)
    //charAt
    var letra = sigla.get(1)

    var unicode = sigla.codePointAt(1)

    println("A LETRA  $letra tem o UNICODE $unicode") //interpolação

    var letras:List<Char> =sigla.toList()

    println("O byte da  $letra é ${letra.toByte()}") //interpolação

    println("Os bytes da  $sigla sao ${sigla.toByteArray()}") //interpolação

    var yesNo=sigla.startsWith("gso")
    println("O valor de yesNo é $yesNo") //interpolação

    yesNo=sigla.startsWith("gso",true)
    println("O valor de yesNo é $yesNo") //interpolação


    var variavelFormatada = "%.2f".format(PI)
    println("O valor é $variavelFormatada") //interpolação

    var inteiro = 897654

    variavelFormatada = "%010d".format(inteiro)
    println("O valor é $variavelFormatada") //interpolação

    var nomeBR = "Gleyson Sampaio"
    //escape - NAO INTERPOLAÇÃO
    var nomeUS = "%2\$s, %1\$s".format("Gleyson","Sampaio")

    println("Nome BR é $nomeBR  Nome US $nomeUS") //interpolação


}