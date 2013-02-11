package pl.kwi.guice.test;

import org.mockito.Mockito;

import com.google.inject.Provider;

import pl.kwi.services.INameService;

public class OutputServletProvider implements Provider<INameService>{

	@Override
	public INameService get() {
		
		INameService mock = Mockito.mock(INameService.class);
		Mockito.when(mock.load()).thenReturn("Name1");
		
		return mock;
	}

}
