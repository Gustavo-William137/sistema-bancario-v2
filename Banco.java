import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> listaDeContas;

    public Banco() {
        listaDeContas = new ArrayList<>();
    }

    public void adicionar(Conta c) {
        listaDeContas.add(c);
    }

    public Conta buscar(int numero) {
        for (int i = 0; i < listaDeContas.size(); i++) {
            if (listaDeContas.get(i).getNumero() == numero) {
                return listaDeContas.get(i);
            }
        }
        return null;
    }

    public ArrayList<Conta> getLista() {
        return listaDeContas;
    }
}