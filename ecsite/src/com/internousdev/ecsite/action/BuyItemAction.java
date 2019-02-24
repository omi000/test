package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private int count;
	private String pay;
//	executeメソッド(buyItem.jspで購入ボタンを押すと実行される)
	public String execute(){
//	resultにSUCCESSの代入
		String result=SUCCESS;
//	sessionに購入個数をcountという名前で格納
		session.put("count",count);
//	sessionに格納したものをString型でとりだして、int型に変換したものを各変数に代入する
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
// 	sessionにトータル金額をtotal_priceという名前で格納する
		session.put("total_price",intCount * intPrice);
//	payment変数
		String payment;
//	もしbuyitem.jspで指定した値が(value)1なら
		if(pay.equals("1")){
//	paymentに現金払いを代入してsessionにpayというキーで格納する
			payment="現金払い";
			session.put("pay",payment);
//	if文の条件に一致しなかったら、paymentにクレジットカードを代入してsessionにpayというキーで格納する
		}else{
			payment="クレジットカード";
			session.put("pay",payment);
		}
//	結果をstruts.xmlに返す
		return result;
	}

	public int getCount(){
		return count;
	}

	public void setCount(int count){
		this.count=count;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay){
		this.pay=pay;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}




}
