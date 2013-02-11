package pl.kwi.services;

import com.google.inject.ImplementedBy;

@ImplementedBy(NameService.class)
public interface INameService {

	public void save(String name);

	public String load();

}