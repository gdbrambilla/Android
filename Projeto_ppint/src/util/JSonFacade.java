package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.Cliente;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSonFacade {
	
	public static StringBuilder montaJSon(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static String listToJSon(ArrayList<Cliente> lista) {
		JSONArray vetor = new JSONArray();
		for (Cliente to : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("id", to.getId());
				object.put("nome", to.getNome());
				object.put("fone", to.getFone());
				object.put("email", to.getEmail());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}

	public static Empresa jSonToCliente(String json) throws IOException{
		try{
			JSONObject registro = new JSONObject(json);
			int id = registro.getInt("id");
			String nome = registro.getString("nome");
			String fone = registro.getString("fone");
			String email = registro.getString("email");
			Empresa empresa = new Empresa();
			empresa.setId(id);
			empresa.setNome(nome);
			empresa.setFone(fone);
			empresa.setEmail(email);
			return empresa;
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}
	
	public static String clienteToJSon(Cliente empresa) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("id", cliente.getId());
			object.put("nome", cliente.getNome());
			object.put("fone", cliente.getFone());
			object.put("email", cliente.getEmail());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
