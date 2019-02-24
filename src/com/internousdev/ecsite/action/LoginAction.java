package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private String loginPassword;
	public Map<String,Object> session;
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();
	private BuyItemDAO buyItemDAO=new BuyItemDAO();
	public ArrayList<BuyItemDTO> buyItemList=new ArrayList<BuyItemDTO>();


	public String execute(){
		String result=ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",loginDTO);


		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;
			buyItemList=buyItemDAO.getBuyItemInfo();
			session.put("buyitemlist", buyItemList);

			session.put("login_user_id",loginDTO.getLoginId());

			if(((LoginDTO)session.get("loginUser")).getAdminFlg()){
				result="admin";
				return result;
			}

			return result;
		}

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

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}


	public ArrayList<BuyItemDTO> buyItemList(){
		return buyItemList;
	}

	public void buyItemList(ArrayList<BuyItemDTO> buyItemList){
		this.buyItemList=buyItemList;
	}


}