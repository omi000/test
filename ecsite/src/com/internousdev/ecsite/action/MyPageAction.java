package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private MyPageDAO myPageDAO=new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

//	executeメソッド
	public String execute()throws SQLException{
//	もしsessionにid(商品id)がなければERRORをかえす
		if(!session.containsKey("id")){
			return ERROR;
		}
//	もしdeleteFlgがnullなら
		if(deleteFlg==null){
//	sessionにある情報2つを(商品IDとユーザーID)各変数に代入する
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();
//	myPageListにmyPageDAOのgetMyPageUserInfoメソッドの引数を指定して実行して返ってくる値を代入する
			myPageList=myPageDAO.getMyPageUserInfo(item_transaction_id,user_master_id);
		}else if(deleteFlg.equals("1")){
			delete();
		}
// resultにSUCCESSを代入して、struts.xmlに返す
		String result=SUCCESS;
		return result;
	}

//	deleteメソッド(削除ボタンが押されたときに実行されるメソッド)
	public void delete() throws SQLException{
//	sessionの商品IDとユーザーIDを取り出して変数に代入する
		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();
//	int型変数resにmyPageDAOのbuyItemHistoryDeleteメソッドに引数を渡して実行した戻り値を代入する
		int res=myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);
//	上記で実行されたbuyItemHistoryメソッドがうまく実行された場合はresに0が代入されている。
//	messageに文を代入する
		if(res>0){
			myPageList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<MyPageDTO> getMyPageList(){
		return this.myPageList;
	}

	public String getMessage(){
		return this.message;
	}

	public void setMessage(String message){
		this.message=message;
	}
}
