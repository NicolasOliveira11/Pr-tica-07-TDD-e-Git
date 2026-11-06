
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FaturaClienteTest {

    @Test
    void deveCriarFatura() {
        Cliente cliente = new Cliente(1, "Joao", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 200.0);

        assertEquals(1, fatura.getId());
        assertEquals(cliente, fatura.getCliente());
        assertEquals(200.0, fatura.getValor(), 0.001);
    }

    @Test
    void deveCriarFaturaSomenteComId() {
        FaturaCliente fatura = new FaturaCliente(2);

        assertEquals(2, fatura.getId());
    }

    @Test
    void deveAlterarCliente() {
        Cliente cliente = new Cliente(1, "Joao", 10);
        FaturaCliente fatura = new FaturaCliente(1);

        fatura.setCliente(cliente);

        assertEquals(cliente, fatura.getCliente());
    }

    @Test
    void deveAlterarValor() {
        FaturaCliente fatura = new FaturaCliente(1);

        fatura.setValor(300.0);

        assertEquals(300.0, fatura.getValor(), 0.001);
    }

    @Test
    void deveCalcularDesconto() {
        Cliente cliente = new Cliente(1, "Joao", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 200.0);

        assertEquals(180.0, fatura.getValorComDesconto(), 0.001);
    }

    @Test
    void deveCalcularDescontoZero() {
        Cliente cliente = new Cliente(1, "Joao", 0);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 200.0);

        assertEquals(200.0, fatura.getValorComDesconto(), 0.001);
    }

    @Test
    void deveCalcularDescontoTotal() {
        Cliente cliente = new Cliente(1, "Joao", 100);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 200.0);

        assertEquals(0.0, fatura.getValorComDesconto(), 0.001);
    }

    @Test
    void deveFormatarFatura() {
        Cliente cliente = new Cliente(1, "Joao", 10);
        FaturaCliente fatura = new FaturaCliente(5, cliente, 200.0);

        assertEquals(
            "Fatura [id=5, cliente=Joao(1)(10%), valor=200.0 ]",
            fatura.toString()
        );
    }
}
