package com.cognizant.truyum.dao;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao  {
	
	private static List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl() throws ParseException {
		List<MenuItem> mList = new ArrayList<>();
		
		if(menuItemList==null) {
			mList.add(new MenuItem(1, "Sandwich", 99.0f, true, new DateUtil().convertToDate("15/03/2017"),"Main Course", true));
			mList.add(new MenuItem(2, "Burger", 129.0f, true, new DateUtil().convertToDate("23/12/2017"),"Main Course", false));
			mList.add(new MenuItem(3, "Pizza", 149.0f, true, new DateUtil().convertToDate("21/08/2018"),"Main Course", false));
		}
		
		menuItemList = mList;
		
		}
	
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	

}
