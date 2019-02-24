package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private ItemListDAO itemListDAO=new ItemListDAO();
	private ArrayList<ItemListDTO> itemList=new ArrayList<ItemListDTO>();
	private String message;

	public String execute() throws SQLException{

			itemList = itemListDAO.getItemInfo();


		String result=SUCCESS;
		return result;

	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<ItemListDTO> getItemList(){
		return this.itemList;
	}

	public String getMessage(){
		return this.message;
	}

	public void setMessage(String message){
		this.message=message;
	}




}
