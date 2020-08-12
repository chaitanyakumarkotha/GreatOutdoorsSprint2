package com.cg.GreatOutdoors.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.GreatOutdoorsSprint2Application;
import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.WishlistProduct;
import com.cg.GreatOutdoor.exception.ProductException;
import com.cg.GreatOutdoor.service.IWishlistProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WishlistServiceTest {
	@Autowired
	IWishlistProductService wishlistProductService;

	Logger logger = LoggerFactory.getLogger(GreatOutdoorsSprint2Application.class);
	String msg;
	@BeforeAll
	 void setUpBeforeClass() {
		msg = "All Test Cases started";
		logger.info(msg);
	}
	
	@BeforeEach
	void setup() {
		msg = "Test Case Started";
		logger.info(msg);
	}

	@AfterEach
	void tearDown() {
		msg = "Test Case Over";
		logger.info(msg);
	}
	
	@AfterAll	
	void setUpAfterClass() {
		msg = "All Test Cases ended";
		logger.info(msg);
	}

	@Test
	@DisplayName("Test for adding an product in wishlist")
	public void addWishlistProductTest() throws ProductException
	{
		WishlistProduct product=new WishlistProduct(5);
		assertEquals(true,wishlistProductService.create(product));
	}
	
	@Test
	@DisplayName("Test for retrieving wishlist products")
	public void retrieveWishlistProductTest() throws ProductException
	{
		List<Product> list=wishlistProductService.retrive(1);
		assertFalse(list.isEmpty());
	}
	
	@Test
	@DisplayName("Test for checking an product in wishlist")
	public void CheckWishlistProductTest() throws ProductException
	{	 assertEquals(false,wishlistProductService.checkId(2,3));
     Assertions.assertThrows(ProductException.class,()->{
    	 wishlistProductService.checkId(1,3);});
    
	}
	
	@Test
	@DisplayName("Test for deleting the product from wishlist")
	public void deleteProductFromWishlistTest() throws  ProductException
	{
		
		assertEquals(true,wishlistProductService.deleteProduct(1,3 ));

		Assertions.assertThrows(ProductException.class,()->{
			wishlistProductService.deleteProduct(65,656 );
		});
		Assertions.assertThrows(ProductException.class,()->{
			wishlistProductService.deleteProduct(1,656 );
		});
		Assertions.assertThrows(ProductException.class,()->{
			wishlistProductService.deleteProduct(65,6 );
		});
		
		
		
	}

}
