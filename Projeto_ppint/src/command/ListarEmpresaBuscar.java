package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import service.VendedorService;

public class ListarEmpresaBuscar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String chave = request.getParameter("chave");
		VendedorService vendedor = new VendedorService();
		ArrayList<Cliente> lista = null;
		HttpSession session = request.getSession();

		if (chave != null && chave.length() > 0) {
			lista = vendedor.listarClientes(chave);
		} else {
			lista = vendedor.listarClientes();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarClientes.jsp");
		dispatcher.forward(request, response);
	}
}
