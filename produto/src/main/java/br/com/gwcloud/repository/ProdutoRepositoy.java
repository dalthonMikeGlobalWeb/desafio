package br.com.gwcloud.repository;

import br.com.gwcloud.model.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepositoy implements PanacheRepositoryBase<Produto, Long> {

}
