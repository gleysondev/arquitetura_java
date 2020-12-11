package pacote1;
public class ProgramaJava {

    public static void main(String[] args){
        Integer inteiro = 123;
       final Double DUPLO = inteiro.doubleValue();
       System.out.println(inteiro);
       System.out.println(DUPLO);
       receboValorDouble(DUPLO);

    }
    static void receboValorDouble(Double valor){
        System.out.println("Valor recebido:: " + valor);
    }
}
