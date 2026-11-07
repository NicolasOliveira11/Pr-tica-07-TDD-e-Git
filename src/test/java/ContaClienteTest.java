
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaClienteTest {

    @Test
    void deveCriarContaComSaldo() {
        Cliente cliente = new Cliente(1, "Joao", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 500.0);

        assertEquals(1, conta.getId());
        assertEquals(cliente, conta.getCliente());
        assertEquals(500.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveCriarContaSemSaldoInformado() {
        Cliente cliente = new Cliente(1, "Joao", 10);
        ContaCliente conta = new ContaCliente(1, cliente);

        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveCriarContaSomenteComId() {
        ContaCliente conta = new ContaCliente(1);

        assertEquals(1, conta.getId());
        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveAlterarCliente() {
        ContaCliente conta = new ContaCliente(1);
        Cliente cliente = new Cliente(2, "Maria", 15);

        conta.setCliente(cliente);

        assertEquals(cliente, conta.getCliente());
    }

    @Test
    void deveAlterarSaldo() {
        ContaCliente conta = new ContaCliente(1);

        conta.setSaldo(300.0);

        assertEquals(300.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveAdicionarDeposito() {
        ContaCliente conta = new ContaCliente(1);

        double resultado = conta.addDeposito(200.0);

        assertEquals(200.0, resultado, 0.001);
        assertEquals(200.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSomarDepositos() {
        ContaCliente conta = new ContaCliente(1);

        conta.addDeposito(100.0);
        conta.addDeposito(150.0);

        assertEquals(250.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveRetirarSaldo() {
        Cliente cliente = new Cliente(1, "Joao", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 500.0);

        double resultado = conta.subSaldo(200.0);

        assertEquals(300.0, resultado, 0.001);
        assertEquals(300.0, conta.getSaldo(), 0.001);
    }

    @Test
    void naoDeveRetirarSaldoInsuficiente() {
        Cliente cliente = new Cliente(1, "Joao", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);

        double resultado = conta.subSaldo(200.0);

        assertEquals(100.0, resultado, 0.001);
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void devePermitirRetirarSaldoTotal() {
        ContaCliente conta = new ContaCliente(1);
        conta.setSaldo(100.0);

        double resultado = conta.subSaldo(100.0);

        assertEquals(0.0, resultado, 0.001);
    }

    @Test
    void deveFormatarConta() {
        Cliente cliente = new Cliente(1, "Joao", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 250.50);

        assertEquals(
            "Joao(1) saldo=R$250.50",
            conta.toString()
        );
    }
}
