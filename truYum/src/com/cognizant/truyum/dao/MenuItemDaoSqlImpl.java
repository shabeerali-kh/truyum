package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;


public class MenuItemDaoSqlImpl implements MenuItemDao  {

	private static PreparedStatement ps=null;
	
	@Override 
	public List<MenuItem> getMenuItemListAdmin(){
		
		List<MenuItem> menuList=new  ArrayList<MenuItem> ();
	try {
		Connection con = ConnectionHandler.getConnection();
		String sql="select * from MENU_ITEMS;";
		ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			long id=rs.getLong(1);
			String name=rs.getString(2);
			float price=rs.getFloat(3);
			boolean active=rs.getBoolean(4);
			Date dateOfLaunch = rs.getDate(5);
			String category = rs.getString(6);
			boolean freeDelivery = rs.getBoolean(7);
			MenuItem item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			menuList.add(item);
		}
		}catch(ClassNotFoundException  e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
	
		}
		
		return menuList;
	}
	
	@Override
	public  List<MenuItem> GetMenuItemListCustomer(){
		
		List<MenuItem> menuList=new  ArrayList<MenuItem> ();
		try {
			
			Connection con = ConnectionHandler.getConnection();
			String sql="select * from MENU_ITEMS where ACTIVE=TRUE and DATE_OF_LAUNCH < now();";
			ps=con.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				MenuItem item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				menuList.add(item);
			}
		}catch(ClassNotFoundException  e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
	
		}
		
		return menuList;
		}
		
	
	@Override
	
	public MenuItem getMenuItem(long menuItemId) {
		
		MenuItem item=null;
		
		try {
			Connection con = ConnectionHandler.getConnection();
			String sql="select * from MENU_ITEMS where ID=?;";
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				 item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				break;
			}
			
		}catch(ClassNotFoundException  e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
	
		}
		return item;
			
	}
	
	
	@Override	
	public void modifyMenuItem(MenuItem menuItem) {
		
		try {
			Connection con = ConnectionHandler.getConnection();
			String sql="update MENU_ITEMS set NAME=?,PRICE=?,ACTIVE=?, DATE_OF_LAUNCH=?, CATEGORY=?, FREE_DELIVERY=?,where ID=? ;";
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, menuItem.getName());
			ps.setFloat(2,menuItem.getPrice());
			ps.setBoolean(3,menuItem.isActive());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(4, format.format(menuItem.getDateOfLaunch()));
			
			ps.setString(5,menuItem.getCategory());
			ps.setBoolean(6,menuItem.isFreeDelivery());
			ps.setLong(7, menuItem.getId());
			
			int n=ps.executeUpdate();
			
		}catch(ClassNotFoundException  e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
	
		}
		
		
	
	}
	
	
}
	
	

