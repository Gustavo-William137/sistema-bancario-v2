public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void mostrarDados() {
        System.out.print("Conta Poupanca - ");
        super.mostrarDados();
    }
}