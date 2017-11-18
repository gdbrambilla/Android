package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

public class VisualizarEmpresa implements Command {

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
		view = request.getRequestDispatcher("Visualizar.jsp");
		view.forward(request, response);
	}

	public int busca(Empresa cliente, ArrayList<Empresa> lista) {
		Cliente to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == cliente.getId()) {
				return i;
			}
		}
		return -1;
	}

}
