package fiap.scj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "MinhaSegundaServlet", urlPatterns = "/minha-segunda-servlet")
public class MinhaSegundaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1>Putz... Bem melhor com annotation!</h1>");
		req.getRequestDispatcher("/minha-primeira-servlet").include(req, resp);
	}

	
	
}
