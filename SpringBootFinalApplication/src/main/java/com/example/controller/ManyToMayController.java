package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Category;
import com.example.bean.StockEntity;
import com.example.bean.User;
import com.example.repository.ManyManyRepositoryForCategory;
import com.example.repository.ManyManyRepositoryForStock;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/many")
public class ManyToMayController {

	@Autowired
	private ManyManyRepositoryForStock manyManyRepository;

	@Autowired
	private ManyManyRepositoryForCategory manyManyRepositoryForCategory;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String Add(HttpServletRequest request) {

		StockEntity stockEntity = new StockEntity();
		stockEntity.setStockCode("123");
		stockEntity.setStockName("testStock");

		Category category = new Category();
		category.setCategoryName("testCategory");
		category.setDesc("testDesc");

		Category category1 = new Category();
		category1.setCategoryName("testCategory_1");
		category1.setDesc("testDesc_1");

		List<Category> categories = new ArrayList<>();
		categories.add(category1);
		categories.add(category);
		stockEntity.setCategory(categories);

		manyManyRepository.save(stockEntity);
		return "success";
	}

	@Transactional
	@RequestMapping(value = "AddCategory", method = RequestMethod.GET)
	public String AddCategory(HttpServletRequest request) {

		Category category = new Category();
		category.setCategoryName("testasparent");
		category.setDesc("testDescasparent");

		StockEntity stockEntity = new StockEntity();
		stockEntity.setStockCode("123");
		stockEntity.setStockName("testStock");

		StockEntity stockEntity1 = new StockEntity();
		stockEntity1.setStockCode("123_1");
		stockEntity1.setStockName("testStock_1");

		List<StockEntity> stockEntities = new ArrayList<>();
		stockEntities.add(stockEntity);
		stockEntities.add(stockEntity1);

		category.setStock(stockEntities);

		manyManyRepositoryForCategory.save(category);
		return "success";
	}

	@Transactional
	@RequestMapping(value = "getStockEntityByd", produces = "application/json", method = RequestMethod.GET)
	public StockEntity getStockEntityByd(HttpServletRequest request) {
		return manyManyRepository.getStockDetailsById(1L);
	}

	@RequestMapping(value = "getUserByID", method = RequestMethod.GET, produces = "application/json")
	public User getUserByID() {
		return userRepository.findOne(1l);
	}
}
