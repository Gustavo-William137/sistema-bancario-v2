public class CalculadoraDeImposto {
    private double totalImposto;

    public CalculadoraDeImposto() {
        this.totalImposto = 0;
    }
    public void registrar(Tributavel t) {
        double imposto = t.calcularTributo();
        this.totalImposto = this.totalImposto + imposto;
    }

    public double getTotalImposto() {
        return this.totalImposto;
    }
}