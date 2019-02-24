package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private int itemPrice;
	private int itemCount;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result=SUCCESS;
		if(!(itemName.equals(""))
				&&!(itemPrice==0)
				&&!(itemCount==0)){
			session.put("itemName",itemName);
			session.put("itemPrice",itemPrice);
			session.put("itemCount",itemCount);
		}else{
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
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

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage=errorMessage;
	}
}
