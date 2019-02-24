package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemDAO;
import com.internousdev.template.dao.LoginDAO;
import com.internousdev.template.dto.BuyItemDTO;
import com.internousdev.template.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
		//フィールド変数
	private String loginUserId;
	private String loginPassword;
	private String result;
	private Map<String,Object> session;
		//executeメソッド
	public String execute(){
			//インスタンス化
		LoginDAO loginDAO=new LoginDAO();
		LoginDTO loginDTO=new LoginDTO();
		BuyItemDAO buyItemDAO=new BuyItemDAO();
			//フィールド変数resultにERRORの代入
		result=ERROR;
			//loginDAOの引数にloginUserIdとloginPasswordを格納を入れて、実行させる
			//
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
			//sessionにMap型で値を入れる(loginUserという名前の2つの情報が入ったloginDTO)
		session.put("loginUser",loginDTO);


		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){	//Object型をloginDTO型に型変換をして、更にLoginFlgの情報を取り出した(true)
			result=SUCCESS;										//1行上の条件式がtrueなら、executeメソッドはSUCCESSを返す
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();	//更にbuyItemDTO内に商品情報を格納しておく

			session.put("login_user_id",loginDTO.getLoginId());//sessionにMap型で情報を格納
			session.put("id",buyItemDTO.getId());				//上記同様
			session.put("buyItem_name",buyItemDTO.getItemName());//上記同様
			session.put("buyItem_price",buyItemDTO.getItemPrice());//上記同様

			return result;//if文の条件が一致した場合のreturn(SUCCESSを返す)
		}
		return result;//if文の条件が一致しなかった場合のreturn(ERRORを返す)

	}

	//下記全てのメソッドはどのタイミングで使われている？？？
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

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}

/**
 * LoginActionではログインするための処理（データベース内で情報を引き出すなど）の実行や、
 * ログインに成功した場合に表示させる商品情報の準備をする
**/
