public class App {
    public static void main(String[] args) throws Exception {
        Eleicao eleicao = new Eleicao(1000,800 , 150, 50);
        System.out.println("O percentual de votos válidos é: " + eleicao.calcularPercentualVotosValido()+"%");
        System.out.println("O percentual de votos brancos é: " + eleicao.calcularPercentualVotosBranco()+"%");
        System.out.println("O percentual de votos nulos é: " + eleicao.calcularPercentualVotosNulos()+"%");
    }
}
