package pacote1;

public class StringPower {
    public static void main(String[] args){
        String nome = " Gleyson Sampaio ";
        nome = nome.trim();
        String nomeCompleto=nome.concat(" Oliveira");
        System.out.println("Menu nome completo é: " + nomeCompleto );
        String primeiroNome = nome.substring(0,7);
        System.out.println("O primeiro nome de " + nome + " é: " + primeiroNome);

        String[] palavras = nome.split(" ");

        primeiroNome = palavras[0];
        String sobrenome=  palavras[1];

        System.out.println("O primeiro nome de " + nome + " é: " + primeiroNome);
        System.out.println("O ultimo nome de " + nome + " é: " + sobrenome);

        char charNome[] = {'G', 'l', 'e','y','s','o','n'};

        primeiroNome = new String(charNome);
        System.out.println("Meu primeiro nome é: " + primeiroNome);

        char letra = primeiroNome.charAt(3);
        int unicode = primeiroNome.codePointAt(3);

        System.out.println("A letra: " + letra + " é o UNICODE de n° " + unicode);

        char[] letras = nome.toCharArray();
        System.out.println("Arrays com as letras do nome " + nome + " é: "  +letras);

        System.out.println("O nome: " + nome + " tem " +  nome.length() + " caracteres");
        String  parteNome = meuSubstring(nome,20);
        System.out.println("Parte do nome é: " + parteNome);

        System.out.println("Os Bytes do " + nome + " são " + nome.getBytes());

        System.out.println("Nome MAIUSCULO " + nome.toUpperCase());
        System.out.println("Nome minusculo " + nome.toLowerCase());

        //Validacao
        boolean verdade = nome.startsWith("gleyson");
        System.out.println("Resultado da Validacao " + verdade);

        verdade = nome.endsWith("Sampaio");
        System.out.println("Resultado da Validacao " + verdade);

        System.out.println("Nome é igual: " + nome.equals("gleyson sampaio"));

        System.out.println("Nome é vazio: " + nome.isEmpty());

        System.out.println("Nome representado é igual: " + nome.equalsIgnoreCase("gleyson sampaio"));

        //Conversao
        Double duplo = null;
        String numero = String.valueOf(duplo);
        System.out.println(numero);

        //Formatacao
        duplo = 1234.56789;
        System.out.println(String.format("%.2f",duplo));
        System.out.println(String.format("%.3f",duplo));
        Integer inteiro = 1234512;
        System.out.println(String.format("%10d",inteiro));
        System.out.println(String.format("%-10d",inteiro));
        System.out.println(String.format("%015d",inteiro));

        System.out.println(String.format("%50s",nome));
        System.out.println(String.format("%-50s",nome));

        System.out.println(String.format("%2$s %1$s",nome.split(" ")));
    }
    static String meuSubstring(String texto,int ate){
        //eu posso ter ate tantos caracteres
        //mas não garanto virão todos
        //cenário básico - leitura de arquivos - nome de uma pessoa
        int max = Math.min(ate,texto.length());
        return texto.substring(0,max);
    }
}
