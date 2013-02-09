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

@Component(value = "outputServlet")
public class OutputServlet  implements HttpRequestHandler{
	
	
	@Autowired
	private NameService nameService;
	

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
					
		String submit = request.getParameter("submit");
		
		if("Display".equals(submit)){
			displayPage(request, response);
			return;
		}else if("Back".equals(submit)){
			handleBackButton(request, response);
			return;
		}
				
	}
	
	private void displayPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
		String name = nameService.load();
		request.setAttribute("name", name);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/outputJsp.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	private void handleBackButton(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.sendRedirect("input.do?submit=Display");
		
	}

}
