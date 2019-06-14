package mum.edu.cs.cs425.project.ecarrent.services;

import java.util.List;
import mum.edu.cs.cs425.project.ecarrent.model.Category;

public interface ICategoryService {
	
	List<Category>findAll();
	Category save(Category category);
	Category findById(Long cId);
	void delete(Long cId);

}
