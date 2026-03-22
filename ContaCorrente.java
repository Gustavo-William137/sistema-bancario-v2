public class ContaCorrente extends Conta implements Tributavel {
    
    public ContaCorrente(int numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void mostrarDados() {
        System.out.print("Conta Corrente - ");
        super.mostrarDados();
    }

    public double calcularTributo() {
        return this.saldo * 0.01; 
    }
}