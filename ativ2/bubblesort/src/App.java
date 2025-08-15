import java.util.Arrays;

public class App {

    public static int[] bubbleSort(int[] vetor, int tamanho){
        if (tamanho <= 1) return vetor;
        int numero = 0;
        for(int i = 0; i < tamanho - 1; i++){
            if(vetor[i]  >= vetor[i+1]){
                numero = vetor[i];
                vetor[i] = vetor[i+1];
                vetor[i+1] = numero;
            }
        }
        return bubbleSort(vetor, tamanho - 1);
    }
    public static void main(String[] args) throws Exception {
        int[] vetor_num = { 5, 3, 2, 4, 7, 1, 0, 6 };
        int[] vetor_organizado = bubbleSort(vetor_num, vetor_num.length);
        System.out.println("Vetor organizado: " + Arrays.toString(vetor_organizado));
    }
}
