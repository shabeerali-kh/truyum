package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	
	 
	
	public static void main(String[] args) throws ParseException {
		System.out.println("Admin list:");
		testGetMenuItemListAdmin();
		System.out.println("completed");
		System.out.println("customer list:");
		testGetMenuItemListCustomer();
		System.out.println("completed");
		System.out.println("modify:");
		testModifyMenuItem();
		System.out.println("menu item:");
		testGetMenuItem();
		System.out.println("completed");
		
		
	
		
		
	}
	
	public static void testGetMenuItemListAdmin() {
		MenuItemDaoSqlImpl testObj=new MenuItemDaoSqlImpl(); 
		List<MenuItem> adminList=testObj.getMenuItemListAdmin();
		for(MenuItem mi:adminList)
				System.out.println(mi);
	}
	
	public static void testGetMenuItemListCustomer() {
		MenuItemDaoSqlImpl testObj=new MenuItemDaoSqlImpl(); 
		List<MenuItem> adminList=testObj.getMenuItemListCustomer();
		for(MenuItem mi:adminList)
				System.out.println(mi);
		
	}
	public static void testModifyMenuItem() throws ParseException {
		MenuItemDaoSqlImpl testObj=new MenuItemDaoSqlImpl(); 
		Date date = DateUtil.convertToDate("01/01/2020");
		MenuItem mItem=new MenuItem(6,"water",150.0f,true,date ,"general",false);
		testObj.modifyMenuItem(mItem);
	}
	public static void testGetMenuItem() {
		MenuItemDaoSqlImpl testObj=new MenuItemDaoSqlImpl(); 
		MenuItem item=testObj.getMenuItem(7);
		System.out.println(item);
	}
}
