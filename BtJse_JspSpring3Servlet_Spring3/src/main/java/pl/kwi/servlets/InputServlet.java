package pl.kwi.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import pl.kwi.services.NameService;

@Component(value = "inputServlet")
public class InputServlet implements HttpRequestHandler{
	
	
	@Autowired
	private NameService nameServiceice;
	

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
				
		String submit = request.getParameter("submit");
		
		if("Display".equals(submit)){
			displayPage(request, response);
			return;
		}else if("OK".equals(submit)){
			handleOkButton(request, response);
			return;
		}
			
	}
	
	private void displayPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/inputJsp.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	private void handleOkButton(HttpServletRequest request, HttpServletResponse response) throws IOException{
					
		String name = request.getParameter("name");		
		nameServiceice.save(name);					
		response.sendRedirect("output.do?submit=Display");
		
	}

	

}
