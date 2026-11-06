
public class FaturaCliente {

    private final int id;
    private Cliente cliente;
    private double valor;

    public FaturaCliente(int id, Cliente cliente, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
    }

    public FaturaCliente(int id) {
        this(id, null, 0.0);
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorComDesconto() {
        double percentualDesconto = cliente.getDesconto() / 100.0;
        return valor * (1 - percentualDesconto);
    }

    @Override
    public String toString() {
        return String.format(
            "Fatura [id=%d, cliente=%s, valor=%s ]",
            id, cliente, valor
        );
    }
}
