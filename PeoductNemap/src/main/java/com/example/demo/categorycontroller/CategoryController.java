package com.example.demo.categorycontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.category.Category;
import com.example.demo.caterepo.CategoryRepo;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryRepo crepo;

	@GetMapping("/categories")
	public List<Category> getCategory() {
		List<Category> categories = crepo.findAll();
		return categories;
	}

	@GetMapping("/categories/{di}")
	public Category GetbyId(@PathVariable int di) {
		Category categories = crepo.findById(di).get();
		return categories;
	}

	@PostMapping("/categories")
	public void CreateCateory(@RequestBody Category categories) {
		crepo.save(categories);
	}

	@PutMapping("/categories/{di}")
	public Category UpdateCategory(@PathVariable int di) {
		Category categories = crepo.findById(di).get();
		categories.setCategoryName("Statinary");
		crepo.save(categories);
		return categories;
	}

	@DeleteMapping("/categories/{di}")
	public void DeleteCategory(@PathVariable int di) {
		Category categories = crepo.findById(di).get();
		crepo.delete(categories);
	}
}
