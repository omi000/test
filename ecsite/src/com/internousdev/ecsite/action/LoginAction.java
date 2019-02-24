package com.internousdev.ecsite.action;

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

//	executeメソッド
	public String execute(){
//	resultにERRORの代入
		String result=ERROR;
//	loginDTOにloginDAOのgetLoginUserInfoメソッドを実行してかえってくる値を代入する、引数に入るものはユーザーが入力した情報
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
//	sessionにloginDTOにいれた情報を格納する(4情報)
		session.put("loginUser", loginDTO);
//	☆もしsessionのloginUserキーの値にgetLoginFlgメソッドが存在していたら
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
//	reaultにSUCCESSを代入する
			result=SUCCESS;
//	buyItemDTOの中にbuyItemInfoメソッドを実行したときの戻り値を代入(3情報)
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
//sessionに4つの情報の格納
			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

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

	public void setSession(Map<String,Object> session){
		this.session=session;
	}


}
