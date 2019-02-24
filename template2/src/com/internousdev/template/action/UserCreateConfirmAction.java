package com.internousdev.template.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	//フィールド変数
	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String,Object> session;
	private String errorMessage;

	//executeメソッド
	public String execute(){
		//変数resultにSUCCESS代入
		String result =SUCCESS;

		//ユーザーが未入力の箇所がなければsessionに全ての情報をMap型で格納する
		if(!(loginUserId.equals(""))
			&&!(loginPassword.equals(""))
			&&!(userName.equals(""))){
			session.put("loginUserId",loginUserId);
			session.put("loginPassword",loginPassword);
			session.put("userName",userName);
		//1つでも未入力の項目があればerrorMessageに未入力の項目があります。を代入して、resultをERRORに変更する
		}else{
			setErrorMessage("<h1>未入力の項目があります。</h1>");
			result=ERROR;
		}
			//if文がtrueならSUCCESS、falseならERRORをjspファイルに返す
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
