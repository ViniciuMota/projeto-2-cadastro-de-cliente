package br.com.services;

import br.com.domain.Cliente;
import br.com.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteService {
    Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
