package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO=new BuyItemCompleteDAO();

//	executeメソッド
	public String execute()throws SQLException{
//	buyItemCompleteDAOのbuyItemInfoの引数を指定して実行する(データベースに情報が格納される)
		buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("login_	user_id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("pay").toString());
//	resultにSUCCESSを代入する
		String result=SUCCESS;
//	結果をstruts.xmlに返す
		return result;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}


}
