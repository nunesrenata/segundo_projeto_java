package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.Produto;
import factories.ConnectionFactory;

public class ProdutoRepositorySQL implements IProdutoRepository {

	@Override
	public void create(Produto produto) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		String query = "insert into produto(idproduto, nome, preco, quantidade, status) " + "values(?, ?, ?, ?, ?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, produto.getIdProduto());
		preparedStatement.setString(2, produto.getNome());
		preparedStatement.setDouble(3, produto.getPreco());
		preparedStatement.setInt(4, produto.getQuantidade());
		preparedStatement.setString(5, produto.getStatus().toString());

		preparedStatement.execute();
		connection.close();
	}

}
