
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveCriarCliente() {
        Cliente cliente = new Cliente(1, "Joao", 10);

        assertEquals(1, cliente.getId());
        assertEquals("Joao", cliente.getNome());
        assertEquals(10, cliente.getDesconto());
    }

    @Test
    void deveAlterarDesconto() {
        Cliente cliente = new Cliente(1, "Joao", 10);

        cliente.setDesconto(20);

        assertEquals(20, cliente.getDesconto());
    }

    @Test
    void deveFormatarCliente() {
        Cliente cliente = new Cliente(1, "Joao", 10);

        assertEquals("Joao(1)(10%)", cliente.toString());
    }
}