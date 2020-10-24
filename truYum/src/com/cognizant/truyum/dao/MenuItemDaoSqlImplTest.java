package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	
	static  MenuItemDaoSqlImpl testObj=new MenuItemDaoSqlImpl(); 
	
	public static void main(String[] args) throws ParseException {
		System.out.println("Admin list:");
		testGetMenuItemListAdmin();
		System.out.println("completed");
		System.out.println("customer list:");
		testGetMenuItemListCustomer();
		System.out.println("completed");
		System.out.println("menu item:");
		testGetMenuItem();
		System.out.println("completed");
		System.out.println("modify:");
		testModifyMenuItem();
		System.out.println("completed");
	
		
		
	}
	
	public static void testGetMenuItemListAdmin() {
		List<MenuItem> adminList=testObj.getMenuItemListAdmin();
		for(MenuItem mi:adminList)
				System.out.println(mi);
	}
	
	public static void testGetMenuItemListCustomer() {
		List<MenuItem> adminList=testObj.getMenuItemListCustomer();
		for(MenuItem mi:adminList)
				System.out.println(mi);
		
	}
	public static void testModifyMenuItem() throws ParseException {
		Date date = DateUtil.convertToDate("01/01/2020");
		MenuItem mItem=new MenuItem(2,"water",15000.00f,true,date ,"general",false);
		testObj.modifyMenuItem(mItem);
	}
	public static void testGetMenuItem() {
		MenuItem item=testObj.getMenuItem(7);
		System.out.println(item);
	}
}
