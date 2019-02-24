package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware{

	private ItemListDeleteCompleteDAO itemListDeleteCompleteDAO=new ItemListDeleteCompleteDAO();
	private String message;
	private ArrayList<ItemListDTO> itemList=new ArrayList<ItemListDTO>();
	public Map<String,Object> session;

	public String delete() throws SQLException{

		int res=itemListDeleteCompleteDAO.itemHistoryDelete();

		if(res>0){
			itemList=null;
			setMessage("アイテム情報を正しく削除しました。");
		}else if(res==0){
			setMessage("アイテム情報の削除に失敗しました。");
		}
		return SUCCESS;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<ItemListDTO> getItemList(){
		return this.itemList;
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message=message;
	}



}
