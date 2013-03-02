package pl.kwi.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import pl.kwi.services.INameService;

@WebServlet("/input.do")
public class InputServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	@Inject
	private INameService nameService;
	
	
	public InputServlet(){
		Injector injector = Guice.createInjector();
		nameService = injector.getInstance(INameService.class);	}
	

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
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
		nameService.save(name);					
		response.sendRedirect("output.do?submit=Display");
		
	}


}
