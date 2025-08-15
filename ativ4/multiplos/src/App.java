public class App {

    public static int somaMultiplos(int numero){
        int soma = 0;
        for (int i = 0; i < numero ; i++){
            if(i % 3 == 0 || i % 5 == 0){
                soma += i;
            }
        }
        return soma;
    }
    public static void main(String[] args) throws Exception {
        int numero = 10;
        System.out.println("A soma do número " + numero + " é " + somaMultiplos(numero));
    }
}
