package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	
	
	public static void main(String[] args) {
		System.out.println("Adding to cart:");
		testAddCartItem();
		System.out.println("cart items are:");
		testGetAllCartItem();
		System.out.println("removing item:");
		testRemoveCartItem();
		
	}
	
	public static void testAddCartItem() {
		CartDaoSqlImpl testObj = new CartDaoSqlImpl();
		testObj.addCartItem(2, 8);
	}
	
	public static void testGetAllCartItem() {
		CartDaoSqlImpl testObj = new CartDaoSqlImpl();
		List<MenuItem> cList=new ArrayList<MenuItem>();
		
		try {
			cList=testObj.getAllCartItems(1);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(MenuItem m : cList)
				System.out.println(m);
	}
	
	public static void testRemoveCartItem() {
		CartDaoSqlImpl testObj = new CartDaoSqlImpl();
		testObj.removeCartItem(2,8);
	}
}
