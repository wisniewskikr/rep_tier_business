package pl.kwi.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.kwi.services.NameService;

@WebServlet("/output.do")
public class OutputServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	@EJB
	private NameService nameService;
	

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
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
