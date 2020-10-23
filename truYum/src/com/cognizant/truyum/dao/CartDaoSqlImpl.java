package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
		
	private static PreparedStatement ps=null;
	private static Connection con=null;
	@Override
	public void addCartItem(long userId, long menuItemId) {
		
		try {
			 con = ConnectionHandler.getConnection();
			String sql="insert into  CART(CT_USER_ID,CT_MENU_ID)values(?,?);";
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			ps=con.prepareStatement(sql);
			int n=ps.executeUpdate();
			ps.clearParameters();	
			
		}catch(ClassNotFoundException  e) {
		e.printStackTrace();
		}catch(SQLException e) {
		e.printStackTrace();

		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException{
		List<MenuItem> menuList=new ArrayList<MenuItem>();
		try {
			 con = ConnectionHandler.getConnection();
			
			Cart cart=new Cart(menuList,0);
			String sql=("select * from MENU_ITEMS where ID in(select CT_MENU_ID from CART where CT_USER_ID=?;");
			ps.setLong(1,userId);
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			double  totalPrice =0;
			while(rs.next())
			{
				long id=rs.getLong(1);
				String name=rs.getString(2);
				float price=rs.getFloat(3);
				boolean active=rs.getBoolean(4);
				Date dateOfLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				 totalPrice +=price;
				MenuItem item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				menuList.add(item);
			}
			cart.setTotal(totalPrice);
			cart.setMenuItemList(menuList);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return menuList;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		
		
		
				try {
					 con = ConnectionHandler.getConnection();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
				
			
		
		
	}
	

}
	
	

