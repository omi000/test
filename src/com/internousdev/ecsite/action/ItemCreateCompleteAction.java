package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{
	private String itemName;
	private int itemPrice;
	private int itemCount;
	public Map<String,Object> session;
	private ItemCreateCompleteDAO itemCreateCompleteDAO=new ItemCreateCompleteDAO();

	public String execute() throws SQLException{
		itemCreateCompleteDAO.createItem(session.get("itemName").toString(),
				Integer.parseInt(session.get("itemPrice").toString()),
				Integer.parseInt(session.get("itemCount").toString()));
		String result=SUCCESS;
		return result;
	}
	public String getItemName(){
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName=itemName;
	}

	public int getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(int itemPrice){
		this.itemPrice=itemPrice;
	}

	public int getItemCount(){
		return itemCount;
	}

	public void setItemCount(int itemCount){
		this.itemCount=itemCount;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}


}
