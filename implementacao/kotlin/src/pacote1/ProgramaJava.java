package pacote1;
public class ProgramaJava {
    public static void main(String[] args){
        Integer inteiro = 123;
       final Double DUPLO = inteiro.doubleValue();
       System.out.println(inteiro);
       System.out.println(DUPLO);
       receboValorDouble(DUPLO);

       for(int x=80; x<=100;x++ ){
           System.out.println(x);
       }

        for(int x=100; x>=80;x-- ){
            System.out.println(x);
        }

    }
    static void receboValorDouble(Double valor){
        System.out.println("Valor recebido:: " + valor);
    }
}
