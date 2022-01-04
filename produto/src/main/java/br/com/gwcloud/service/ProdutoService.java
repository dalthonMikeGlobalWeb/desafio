package br.com.gwcloud.service;

import br.com.gwcloud.exception.EntidadeNaoEncontradaException;
import br.com.gwcloud.model.Produto;
import br.com.gwcloud.repository.ProdutoRepositoy;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class ProdutoService {

    @Inject
    ProdutoRepositoy produtoRepositoy;

    public List<Produto> buscarTodos() {
        return produtoRepositoy.listAll();
    }

    public void cadastrar(Produto produto) {
        produtoRepositoy.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepositoy.findByIdOptional(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado"));
    }
    public void deletarPorId(Long id) {
        Produto produto = buscarPorId(id);
        produtoRepositoy.delete(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        Produto produtoSalvo = buscarPorId(id);
        produtoSalvo.setNome(produto.getNome());
        produtoRepositoy.persist(produtoSalvo);
        return produtoSalvo;

    }
}
