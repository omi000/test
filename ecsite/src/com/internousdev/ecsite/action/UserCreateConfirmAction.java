package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object> session;
	private String errorMessage;
//	executeメソッド
	public String execute(){
//	resultにSUCCESSの代入
		String result=SUCCESS;
//	もしユーザーが入力したloginUserIdが空欄でなく、loginPasswordと、userNameも空欄でなければ
		if(!(loginUserId.equals(""))
			&&!(loginPassword.equals(""))
			&&!(userName.equals(""))){
//	sessionに各情報を格納する
			session.put("loginUserId",loginUserId);
			session.put("loginPassword",loginPassword);
			session.put("userName",userName);
		}else{
//	1つでも未入力の項目があればerrorMessage変数に文を格納する。更にresultにERRORを代入する
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
//	struts.xmlに結果を返す
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
