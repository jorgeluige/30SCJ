package fiap.scj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MinhaPrimeiraServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Passei aqui!");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Funciona!!!</h1>");
		req.getParameterMap().keySet().
			forEach(k -> out.printf("Key: %s; Value: %s.<br>",k,req.getParameter(k)));
		for(String s: req.getParameterMap().keySet())
		{
			out.printf("Key: %s; Value: %s.<br>",s,req.getParameter(s));
		}
		out.close();
	}

	
	
}
