package pl.kwi.servlets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.kwi.guice.test.OutputServletModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class OutputServletTest {
	
	private OutputServlet outputServlet;

	@Before
	public void setUp() throws Exception {
		Injector injector = Guice.createInjector(new OutputServletModule());
		outputServlet = injector.getInstance(OutputServlet.class);
	}

	@Test
	public void loadName() {
		String name = outputServlet.loadName();
		assertEquals("Name1", name);
	}

}
