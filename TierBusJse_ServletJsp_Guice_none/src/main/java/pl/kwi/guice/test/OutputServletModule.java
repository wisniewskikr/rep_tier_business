package pl.kwi.guice.test;

import pl.kwi.services.INameService;
import com.google.inject.Binder;
import com.google.inject.Module;

public class OutputServletModule implements Module {

	public void configure(Binder binder) {
        binder.bind(INameService.class).toProvider(OutputServletProvider.class);
    }

}
