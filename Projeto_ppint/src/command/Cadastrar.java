package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import service.ClienteService;

public class Cadastrar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pFone = request.getParameter("fone");
		String pEmail = request.getParameter("email");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (Exception e) {

		}

		EmpresaService cs = new EmpresaService();
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setNome(pNome);
		empresa.setFone(pFone);
		empresa.setEmail(pEmail);
		HttpSession session = request.getSession();

		cs.criar(empresa);
		ArrayList<Cliente> lista = new ArrayList<>();
		lista.add(empresa);
		session.setAttribute("lista", lista);
		RequestDispatcher view =  request.getRequestDispatcher("Listar.jsp");
		view.forward(request, response);
	}
}
