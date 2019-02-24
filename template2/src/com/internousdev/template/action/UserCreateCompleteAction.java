package com.internousdev.template.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

		//フィールド変数
		private String loginUserId;
		private String loginPassword;
		private String userName;
		private Map<String,Object> session;

		//executeメソッド
		public String execute() throws SQLException{
		//DAOのインスタンス化
			UserCreateCompleteDAO userCreateCompleteDAO=new UserCreateCompleteDAO();
		//DAOのcreateUserメソッドの引数にユーザーが入力したsessionに格納した情報をString型で引き渡す.
			userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),
							session.get("loginPassword").toString(),
							session.get("userName").toString());
		//resultにSUCCESSを入れて、
			String result=SUCCESS;
		//struts.xmlに返される
			return result;

		}

		public String getLoginUserId(){
			return loginUserId;
		}

		public void setLoginUserId(String loginUserId){
			this.loginUserId=loginUserId;
		}

		public String getLoginPassword(){
			return loginPassword;
		}

		public void setLoginPassword(String loginPassword){
			this.loginPassword=loginPassword;
		}
		public String getUserName(){
			return userName;
		}

		public void setUserName(String userName){
			this.userName=userName;
		}
		public Map<String,Object> getSession(){
			return session;
		}

		public void setSession(Map<String,Object> session){
			this.session=session;
		}

}
