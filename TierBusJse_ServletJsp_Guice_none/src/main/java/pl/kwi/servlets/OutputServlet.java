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

@WebServlet("/output.do")
public class OutputServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	@Inject
	private INameService nameService;
	
	public OutputServlet(){
		Injector injector = Guice.createInjector();
		nameService = injector.getInstance(INameService.class);
	}
	

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
			
		request.setAttribute("name", loadName());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/outputJsp.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	private void handleBackButton(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.sendRedirect("input.do?submit=Display");
		
	}
	
	protected String loadName(){
		return nameService.load();
	}

}
