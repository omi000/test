/*sessionにstock(stock,購入する数)、buyItem_price(intStock*intPrice,トータル金額)、pay(payment,支払い方法)を格納。
**
*/

package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class BuyItemAction extends ActionSupport implements SessionAware{


	//フィールド変数
	private int stock;
	private String pay;
	public Map<String,Object> session;
	private String result;

	//executeメソッド
	public String execute(){
	//result変数にSUCCESSを代入
		result=SUCCESS;

		//sessionにMap型でstockというキーでユーザーが選択した個数を格納する
		session.put("stock", stock);
		//int 型のintStock変数にsessionのstockをString型で取り出してint型に型変換したものを代入する
		int intStock=(Integer)session.get("stock");
		//int intStock=Integer.parseInt(session.get("stock").toString());
//		int型のintPrice変数にsessioのbuyItem_priceをString型で取り出してint型に型変換したものを代入する
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		//sessionの"buyItem_price"のキーの値を単価の金額から、トータル金額に書き換える
		session.put("buyItem_price",intStock * intPrice);
		//String型のローカル変数payment
		String payment;

		//equalsは文字列の比較　payが1ならpayment変数に現金払いと代入し、sessionにpayキーで格納する
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay",payment);
		//それ以外ならpayment変数にクレジットカードと代入し、sessionにpayキーで格納する
		}else{
			payment="クレジットカード";
			session.put("pay",payment);
		}
		//結果をstruts.xmlに返す
		return result;
	}
	public int getStock(){
		return stock;
	}
	public void setStock(int stock){
		this.stock=stock;
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

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}


}
