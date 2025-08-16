public class App {
    public static long calcFatorial(int numero){
        if (numero <= 1) return 1;
        return numero * calcFatorial(numero -1);
    } 
    public static void main(String[] args) {
        int numero = 5;
        System.out.println("Fatorial de " + numero + "! é " + calcFatorial(numero));
    }
}
