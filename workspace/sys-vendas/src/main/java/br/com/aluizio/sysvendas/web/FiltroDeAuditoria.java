package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * FiltroDeUri.java
 * @author Aluizio Monteiro
 * 29 de ago de 2018
 */

//Para quem rodar
@WebFilter(urlPatterns="/*")

public class FiltroDeAuditoria implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		
		String usuario = getUsuario(req);
		
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		
		System.out.println(" - "+hora+" "+data+" - Usuário"+usuario+" acessando a url: ("+uri+")");
		
		//Continua fluxo
		chain.doFilter(request, response);
	}

	//Pega o cookie do usuario
	private String getUsuario(HttpServletRequest req) {
		String usuario = "<deslogado>";
		Cookie[] cookies = req.getCookies();
		if(cookies == null) return usuario;
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("usuario.logado")) {
				usuario = cookie.getValue();
			}
		}
		return usuario;
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
