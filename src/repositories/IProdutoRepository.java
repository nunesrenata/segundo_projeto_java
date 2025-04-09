package repositories;

import entities.Produto;

public interface IProdutoRepository {

	void create(Produto produto) throws Exception;
	
}
