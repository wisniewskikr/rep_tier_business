package pl.kwi.services;

import java.util.Properties;


public class NameService implements INameService {
	
	
	private static final String NAME_PROPERTY = "name";
	private Properties props;

	
	public NameService(){		
		props = System.getProperties();
	}

	
	/* (non-Javadoc)
	 * @see pl.kwi.services.INameService#save(java.lang.String)
	 */
	public void save(String name){
		props.setProperty(NAME_PROPERTY, name);
	}
	
	/* (non-Javadoc)
	 * @see pl.kwi.services.INameService#load()
	 */
	public String load() {
		return props.getProperty(NAME_PROPERTY);
	}
	
	
}
