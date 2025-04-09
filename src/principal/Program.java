package principal;

import controllers.ProdutoController;

public class Program {

	public static void main(String[] args) {

		ProdutoController produtoController = new ProdutoController();
		produtoController.cadastrarProduto();

	}

}
