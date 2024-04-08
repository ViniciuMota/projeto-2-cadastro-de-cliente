package test.br.com;

import br.com.dao.IClienteDAO;
import br.com.domain.Cliente;
import br.com.exceptions.TipoChaveNaoEncontradaException;
import br.com.services.ClienteService;
import br.com.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.br.com.dao.ClienteDAOMock;

public class ClienteServiceTest {
    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Lucas");
        cliente.setCidade("São Paulo");
        cliente.setEnd("End");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(1199999999L);

    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Lucas Martins");
        clienteService.alterar(cliente);

        Assert.assertEquals("Lucas Martins", cliente.getNome());
    }
}
