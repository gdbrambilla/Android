package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

public class AlterarEmpresa implements Command {

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
		RequestDispatcher view = null;

		empresa = cs.carregar(empresa.getId());
		request.setAttribute("empresa", empresa);
		view = request.getRequestDispatcher("AlterarCliente.jsp");

		view.forward(request, response);

	}
}
