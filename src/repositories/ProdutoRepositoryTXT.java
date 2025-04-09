package repositories;

import java.io.PrintWriter;

import javax.print.event.PrintJobAdapter;

import entities.Produto;

public class ProdutoRepositoryTXT implements IProdutoRepository {

	@Override
	public void create(Produto produto) throws Exception {
		// TODO Auto-generated method stub

		String path = "c:\\temp\\produto_" + produto.getIdProduto() + ".txt";

		PrintWriter printWriter = new PrintWriter(path);

		printWriter.write("\nId produto.......: " + produto.getIdProduto() + "\n");
		printWriter.write("\nNome.............: " + produto.getNome() + "\n");
		printWriter.write("\nPreço............: " + produto.getPreco() + "\n");
		printWriter.write("\nQuantidade.......: " + produto.getQuantidade() + "\n");
		printWriter.write("\nStatus...........: " + produto.getStatus() + "\n");

		printWriter.flush();
		printWriter.close();
	}
}