package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDaoSqlImpl implements CartDao {
		
	private static PreparedStatement ps=null;
	@Override
	public void addCartItem(long userId, long menuItemId) {
		
		try {
			Connection con = ConnectionHandler.getConnection();
			
				
			}
			
		}
	}
	
	
}
