package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Pagamentos;
import br.com.aluizio.sysvendas.model.Produto;
import br.com.aluizio.sysvendas.model.Usuario;
import br.com.aluizio.sysvendas.service.AReceber;
import br.com.aluizio.sysvendas.service.AReceberHoje;
import br.com.aluizio.sysvendas.service.AReceberMes;
import br.com.aluizio.sysvendas.service.AReceberSemana;
import br.com.aluizio.sysvendas.service.ProdutoTopList;
import br.com.aluizio.sysvendas.service.ProdutosEsgotados;
import br.com.aluizio.sysvendas.service.ProdutosReserva;
import br.com.aluizio.sysvendas.service.TotalAtraso;
import br.com.aluizio.sysvendas.service.TotalDividas;
import br.com.aluizio.sysvendas.service.VisaoGeral;

/**
 * Servlet implementation class Login
 * 
 * @author Aluizio Monteiro 29 de ago de 2018
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuarioBuscado = new Usuario();
		usuarioBuscado.setLogin(request.getParameter("login"));
		usuarioBuscado.setSenha(request.getParameter("senha"));

		Usuario usuario = new UsuarioDao().buscaUsuario(usuarioBuscado);
		System.out.println(usuario);

		if (usuario.getId() == null) {
			System.out.println("Erro ao tentar se logar.");

			JOptionPane.showMessageDialog(null, "Nome ou senha incorretas.");

			request.getRequestDispatcher("index.html").forward(request, response);
		} else {

			System.out.println("Usuário " + usuario.getNome() + " efetuou login.");

			// Coloca a sessão na memória do servidor e retorna um cookie.
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);

			// Carrega dashboard

			// Lista a receber
			List<Pagamentos> listaAReceber = AReceber.getListaValoresAReceber();
			request.setAttribute("listaAReceber", listaAReceber);//

			// Total a receber
			System.out.println("- Total atrasados");
			BigDecimal valorTotalAtraso = AReceber.getValorTotalAtraso(listaAReceber);
			request.setAttribute("valorTotalAtraso", valorTotalAtraso);

			// Lista A Receber Hoje
			List<Pagamentos> listaAReceberHoje = AReceberHoje.getListAReceberHoje();
			listaAReceberHoje.forEach(e -> System.out.println(e));
			request.setAttribute("listaAReceberHoje", listaAReceberHoje);//

			// Valor A Receber Hoje
			BigDecimal valorAReceberHoje = AReceberHoje.getValorAReceberHoje(listaAReceberHoje);
			System.out.println("- Valor a receber hoje: " + valorAReceberHoje);
			request.setAttribute("valorAReceberHoje", valorAReceberHoje);

			// Lista á receber mês
			List<Pagamentos> listaAReceberMes = AReceberMes.getListAReceberMes();
			request.setAttribute("listaAReceberMes", listaAReceberMes);//

			// Valor total a receber mês
			BigDecimal valorAReceberMes = AReceberMes.getValorAReceberMes(listaAReceberMes);
			request.setAttribute("valorAReceberMes", valorAReceberMes);

			// Lista á receber Semana
			List<Pagamentos> listaAReceberSemana = AReceberSemana.getListaAReceberSemana();//
			request.setAttribute("listaAReceberSemana", listaAReceberSemana);

			// Valor á receber Semana
			BigDecimal valorAReceberSemana = AReceberSemana.getValorAReceberSemana(listaAReceberSemana);
			request.setAttribute("valorAReceberSemana", valorAReceberSemana);

			// Produtos Esgotado
			List<Produto> produtosEsgotados = ProdutosEsgotados.getProdutosEsgotados();
			request.setAttribute("produtosEsgotados", produtosEsgotados);

			// Lista de produtos na reserva
			List<Produto> produtosReserva = ProdutosReserva.getProdutosReserva();
			request.setAttribute("produtosReserva", produtosReserva);

			// Produtos Top List
			List<Produto> produtoTopList = ProdutoTopList.getProdutoTopList();
			request.setAttribute("produtoTopList", produtoTopList);

			// Lista de pagamentos em Atraso
			List<Pagamentos> listaAtrasos = TotalAtraso.getListaAtraso();
			request.setAttribute("listaAtrasos", listaAtrasos);
			
			// Valor total Atraso
			BigDecimal totalAtraso = TotalAtraso.getTotalAtraso(listaAtrasos);
			request.setAttribute("totalAtraso", totalAtraso);
			
			// Listar todas as dívidas
			List<Pagamentos> listaDividas = TotalDividas.getTotalDividas();
			request.setAttribute("listaDividas", listaDividas);
			
			// Valor total dívidas
			BigDecimal totalDividas = TotalDividas.getListDividas(listaDividas);
			request.setAttribute("totalDividas", totalDividas);
			
			
			
			
			//Total Investido
			BigDecimal totalInvestido = VisaoGeral.getTotalInvestido();
			request.setAttribute("totalInvestido", totalInvestido);
			
			//LucroLiquido
			BigDecimal lucroLiquido = VisaoGeral.getLucroLiquido();
			request.setAttribute("lucroLiquido", lucroLiquido);
			
			//LucroBruto
			BigDecimal lucroBruto = VisaoGeral.getLucroBruto();
			request.setAttribute("lucroBruto", lucroBruto);
			
			// Extimativa Bruta
			BigDecimal extimativaBruta = VisaoGeral.getExtimativaBruta();
			request.setAttribute("extimativaBruta", extimativaBruta);
			
			// Extimativa Liquida
			BigDecimal extimativaLiquida = VisaoGeral.getExtimativaLiquida();
			request.setAttribute("extimativaLiquida", extimativaLiquida);

			
			
			request.setAttribute("usuario", usuario.getNome());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

}
