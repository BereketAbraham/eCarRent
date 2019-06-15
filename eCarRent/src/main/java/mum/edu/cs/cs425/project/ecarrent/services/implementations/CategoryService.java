package mum.edu.cs.cs425.project.ecarrent.services.implementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mum.edu.cs.cs425.project.ecarrent.model.Category;
import mum.edu.cs.cs425.project.ecarrent.repository.ICategoryRepository;
import mum.edu.cs.cs425.project.ecarrent.services.ICategoryService;

@Service("categoryService")
public class CategoryService implements ICategoryService{
	
	private ICategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(ICategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category findById(Long cId) {
		return categoryRepository.findById(cId).orElse(null);
	}

	@Override
	public void delete(Long cId) {
		categoryRepository.deleteById(cId);
	}

}
