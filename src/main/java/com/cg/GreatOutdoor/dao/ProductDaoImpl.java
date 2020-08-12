package com.cg.GreatOutdoor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.GreatOutdoor.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements IProductDao {
	@PersistenceContext
	private EntityManager entityManager;

	/**********************************
	 * Method: create(AllProduct product) description: save the product in the
	 **********************************/

	@Override
	public boolean create(Product product) {

		entityManager.persist(product);
		if (entityManager.find(Product.class, product.getProductId()) != null) {
			return true;
		} else
			return false;
	}

	/**********************************
	 * Method: retrive() description: it display all product
	 * @returns List of product
	 **********************************/
	@Override
	public List<Product> retrive() {		
		String getProductQuery = "SELECT products FROM Product products";
		TypedQuery<Product> query = entityManager.createQuery(getProductQuery, Product.class);

		return query.getResultList();

	}

	/**********************************
	 * Method: findById description: display the particular record by id 
	 * parameter: it accept productId as a parameter
	 * @returns: product detail
	 **********************************/
	@Override
	public Product findById(long productId) {
		
		return entityManager.find(Product.class, productId);
	}

	/**********************************
	 * Method: checkProductId description: check the particular productId available or not
	 * parameter: it takes productId as a parameter
	 * @returns true if availale otherwise false 
	 **********************************/

	@Override
	public boolean checkProductId(long productId) {
		
		System.out.println(productId);
		if (entityManager.find(Product.class, productId) != null) {
			System.out.println(entityManager.find(Product.class, productId));
			System.out.println("product id check");
			return true;
		} else {
			System.out.println(entityManager.find(Product.class, productId));
			System.out.println("product id not check");
			return false;
		}
	}

}