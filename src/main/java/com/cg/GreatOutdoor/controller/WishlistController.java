package com.cg.GreatOutdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.GreatOutdoor.entity.Product;
import com.cg.GreatOutdoor.entity.WishlistProduct;
import com.cg.GreatOutdoor.exception.ProductException;
import com.cg.GreatOutdoor.exception.UserException;
import com.cg.GreatOutdoor.service.IUserService;
import com.cg.GreatOutdoor.service.IWishlistProductService;
@CrossOrigin(origins="*")
@RestController
public class WishlistController {
	
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IWishlistProductService wishlistProductService;
	
   
  //*********Wishlist Operation***************
   
   /*
    * This method will like the product with respective user and save it to the wishlist.
    */
   
   @GetMapping(value="/user/{userId}/{productId}")
   public String addToWislist(@PathVariable long userId,@PathVariable long productId) throws ProductException, UserException
   {   
	    if(!wishlistProductService.checkId(userId, productId))
	    {
	    	WishlistProduct product=new WishlistProduct(productId);
	    	product.setUser(userService.findById(userId));
	    	wishlistProductService.create(product);
	    return ("Added successfully");
	    }
		return null;  
	    
   }
   
   /*
    * This method will delete the particular Product from wishlist with respect to the particular user.
    */
   @DeleteMapping(value="/user/{userId}/{productId}")
   public void deleteProduct(@PathVariable long userId,@PathVariable long productId) throws ProductException
   {   
	   wishlistProductService.deleteProduct(userId, productId);
	 
   }
   
   /*
    * This method will return List of Product Liked by the particular user
    */
   
   @GetMapping(value="/wishlistproduct/{userId}")
	public List<Product> fetchProduct(@PathVariable long userId) throws ProductException
	{  
	    
	    return wishlistProductService.retrive(userId);
	}
  
   
   
   

}
