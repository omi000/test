package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;

//		executeメソッド
	public String execute(){
//		result変数にloginの代入
		String result="login";
//		もしsessionにidというキーがあれば中身の実行？
		if(session.containsKey("id")){
//		DAOのインスタンス化
			BuyItemDAO buyItemDAO=new BuyItemDAO();
//		DTOにDAOのgetBuyItemInfoメソッドの内容を代入する
			BuyItemDTO buyItemDTO=buyItemDAO.getBuyItemInfo();
//		sessionにDTOに代入した値をそれぞれ名前をつけて格納する
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());
//		if文実行が出来たばあいはresultにSUCCESSを代入し直す
			result=SUCCESS;
		}
//		loginかSUCCESSがはいったresultをstruts.xmlに返す
		return result;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

//	public Map<String,Object> getSession(){
//		return session;
//	}
}
