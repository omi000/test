package com.internousdev.template.dao;import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {

	//getLoginUserInfoメソッド　引数にはユーザーが入れた値が情報が入る
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){

		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		LoginDTO loginDTO=new LoginDTO();

	//sql変数にデータベースのlogin_user_transactionテーブルのlogin_idとlogin_passを検索するためのSQL文を代入する。
		String sql="SELECT * FROM login_user_transaction where login_id=? AND login_pass=?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			//ユーザーが入れた情報をデータベース内で検索する準備
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);//☆SQL文のパラメータに指定した値を挿入することができる。

			//検索の実行 resultsetを使うと、SQL文でのデータベース内検索が実行される？？？
			ResultSet resultSet=preparedStatement.executeQuery();


			if(resultSet.next()){//1つ目の項目から見つかるまで探す(2つの情報が一致しているものを探す) もしあったら下を実行
				loginDTO.setLoginId(resultSet.getString("login_id"));//loginDTOのsetLoginIdにデータベース内のlogin_id情報を入れてフィールド変数に代入させる
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));//上記同様
				loginDTO.setUserName(resultSet.getString("user_name"));//上記同様

				if(!(resultSet.getString("login_id").equals(null))){//データベース内で検索した結果のlogin_idの値がnullでなければ
					loginDTO.setLoginFlg(true);						//loginDTOの変数LoginFlgにtrueを代入する
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return loginDTO;//この結果をloginDTOに返す　　　　？？？上記の実行だけではDTOに情報が入らない？？？
	}

}