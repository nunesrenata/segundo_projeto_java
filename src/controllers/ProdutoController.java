package controllers;

import java.util.Scanner;

import entities.Produto;
import enums.StatusProduto;
import repositories.IProdutoRepository;
import repositories.ProdutoRepositorySQL;
import repositories.ProdutoRepositoryTXT;

public class ProdutoController {

	public void cadastrarProduto() {

		Scanner scanner = new Scanner(System.in);

		try {

			Produto produto = new Produto();

			System.out.print("Informe o id do produto......: ");
			produto.setIdProduto(Integer.parseInt(scanner.nextLine()));

			System.out.print("Informe o nome do produto....: ");
			produto.setNome(scanner.nextLine());

			System.out.print("Informe o preço..............: ");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));

			System.out.print("Informe a quantidade.........: ");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

			if (produto.getQuantidade() > 0) {
				produto.setStatus(StatusProduto.DISPONÍVEL);
			} else {
				produto.setStatus(StatusProduto.ESGOTADO);
			}

			System.out.print("Escolha (1)TXT ou (2)BD......: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			IProdutoRepository produtoRepository = null;

			switch (opcao) {
			case 1:
				produtoRepository = new ProdutoRepositoryTXT();
				break;

			case 2:
				produtoRepository = new ProdutoRepositorySQL();
				break;
			}

			produtoRepository.create(produto);

			System.out.println("\nPRODUTO CADASTRADO COM SUCESSO!");
		} catch (Exception e) {

			System.out.println("\nERRO: " + e.getMessage());
		}
	}
}
