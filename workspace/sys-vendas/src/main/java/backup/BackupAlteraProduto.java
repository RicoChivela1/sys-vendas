package backup;
/*
import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.dao.EstoqueDao;
import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.dao.ProdutoFornecedorDao;
import br.com.aluizio.sysvendas.model.Categoria;
import br.com.aluizio.sysvendas.model.Estoque;
import br.com.aluizio.sysvendas.model.Produto;
import br.com.aluizio.sysvendas.model.ProdutoFornecedor;

*//**
 * Servlet implementation class NovoCliente
 * 
 * @author Aluizio Monteiro 27 de ago de 2018
 *//*
@MultipartConfig(

		fileSizeThreshold = 1024 * 1024, // Limite para cntrole de ram/rom 1MB
		maxFileSize = 1024 * 1024 * 4, // limite de aceitação 4MB
		maxRequestSize = 1024 * 1024 * 4 // limite da requisição 4MB
)

//@WebServlet("/alteraProduto")
public class BackupAlteraProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = "Produto atualizado com sucesso.";
		String produtoId = req.getParameter("produtoId");
		int estoqueId = Integer.parseInt(req.getParameter("estoqueId"));

		// imagem separa em uma classe que recebe request e retorna string

		// Path da pasta no computador
		File dir = new File("C:\\Users\\Júnior\\Desktop\\uploads");
		File arquivo = null;

		// Se o diretório não existe ele cria
		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		// Itera sobre a part, pega a foto e grava em disco
		for (Part part : req.getParts()) {
			if (this.getFileName(part) != null) {

				// grava o arquivo no disco
				arquivo = new File(dir.getAbsolutePath() + "/" + getFileName(part));
				part.write(arquivo.getAbsolutePath());
			}

		}

		// fim da imagem

		// Cria produto
		Produto produto = new Produto();

		produto.setId(Integer.parseInt(produtoId));

		produto.setNome(req.getParameter("nome"));
		produto.setDescricao(req.getParameter("descricao"));
		produto.setIndicacao(req.getParameter("indicacao"));
		produto.setVolume(req.getParameter("volume"));
		produto.setCustoUnid(Integer.parseInt(req.getParameter("custoUnid")));
		produto.setSugestaoVenda(Integer.parseInt(req.getParameter("sugestaoVenda")));

		// Busca a categria pelo id do produto
		
		// Popula Categoria
		Categoria categoria = new Categoria();
		
		int categoriaId = Integer.parseInt(req.getParameter("categoriaId"));
		categoria.setId(categoriaId);
		
		categoria.setNome(req.getParameter("categoria"));

		//change categoria of the produto
		CategoriaDao categoriaDao = new CategoriaDao();
		categoriaDao.alterar(categoria);

		// Busca o estoque do produto em questão
		Estoque estoque = new Estoque();
		estoque.setId(estoqueId);
		Estoque estoqueBuscado = new EstoqueDao().buscaEstoqueId(estoque);
		
		System.out.println("Estoque buscado id: "+estoqueId);

		// Soma valor do input com valor da tabela e seta tudo no db
		int qtdAdicional = Integer.parseInt(req.getParameter("qtdAdicional"));
		System.out.println("QTD Entrada: "+qtdAdicional);
		
		int qtdMinima = Integer.parseInt(req.getParameter("qtdMinima"));
		qtdAdicional += estoqueBuscado.getQtdEntrada();
		
		System.out.println("QTD ATUALIZADA"+qtdAdicional);
		
		estoque.setQtdEntrada(qtdAdicional);
		System.out.println("Nova entrada de Estoque: "+estoque.getQtdEntrada());
		
		estoque.setQtdMinima(qtdMinima);

		EstoqueDao estoqueDao = new EstoqueDao();
		estoqueDao.alterar(estoque);

		int idCategoria = new CategoriaDao().buscaMaiorId();
		Categoria c = new Categoria();
		c.setId(idCategoria);

		// seta a imagem
		String caminho = String.valueOf(arquivo);
		caminho = caminho.replace("\\", "\\");

		// retorna caminho
		produto.setImagem(caminho);

		produto.setCategoria(c);
		produto.setEstoque(estoque);

		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.adicionaAltera(produto);

		// Faz busca pelo listbox fornecedor retornando o id da seleção
		int idFornecedor = Integer.parseInt(req.getParameter("fornecedor"));

		// Faz busca do último produto adicionado e retorna
		int idProduto = new ProdutoDao().buscaMaiorId();

		// Salva o relacionamento
		ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor();

		produtoFornecedor.setIdFornecedor(idFornecedor);
		produtoFornecedor.setIdProduto(idProduto);

		new ProdutoFornecedorDao().relacionar(produtoFornecedor);

		JOptionPane.showMessageDialog(null, message);

		RequestDispatcher rd = req.getRequestDispatcher("buscaProdutos?filtro=");
		rd.forward(req, resp);
	}

	// Método que pega o nome do arquivo
	public String getFileName(Part part) {
		String header = part.getHeader("content-disposition");
		for (String tmp : header.split(";")) {
			if (tmp.trim().startsWith("filename")) {
				return tmp.substring(tmp.indexOf("=") + 2, tmp.length() - 1);
			}
		}
		return null;
	}
}
*/