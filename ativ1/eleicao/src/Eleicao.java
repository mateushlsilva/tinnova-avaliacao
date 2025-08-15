public class Eleicao {
    private int total;
    private int validos;
    private int votosBrancos;
    private int nulos;
    public Eleicao(int total, int validos, int votosBrancos, int nulos) {
        this.total = total;
        this.validos = validos;
        this.votosBrancos = votosBrancos;
        this.nulos = nulos;
    }

    public double calcularPercentualVotosValido(){
        return (double) validos / total * 100;
    }
    public double calcularPercentualVotosBranco(){
        return (double) votosBrancos / total * 100;
    }
    public double calcularPercentualVotosNulos(){
        return (double) nulos / total * 100;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getValidos() {
        return validos;
    }

    public void setValidos(int validos) {
        this.validos = validos;
    }

    public int getVotosBrancos() {
        return votosBrancos;
    }

    public void setVotosBrancos(int votosBrancos) {
        this.votosBrancos = votosBrancos;
    }

    public int getNulos() {
        return nulos;
    }

    public void setNulos(int nulos) {
        this.nulos = nulos;
    }

    
}
