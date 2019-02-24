package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListDeleteCompleteAction extends ActionSupport implements SessionAware{

	private UserListDeleteCompleteDAO userListDeleteCompleteDAO=new UserListDeleteCompleteDAO();

	private String message;
	private ArrayList<UserListDTO> userList=new ArrayList<UserListDTO>();
	public Map<String,Object> session;

	public String delete() throws SQLException{
		int res=userListDeleteCompleteDAO.userHistoryDelete();

		if(res>0){
			userList=null;
			setMessage("ユーザー情報を正しく削除しました。");
		}else if(res==0){
			setMessage("ユーザー情報の削除に失敗しました。");

		}
		return SUCCESS;
	}
		public void setSession(Map<String,Object> session){
			this.session=session;
		}

		public ArrayList<UserListDTO> getUserlist(){
			return this.userList;
		}

		public String getMessage(){
			return this.message;
		}

		public void setMessage(String message){
			this.message=message;
		}


}
