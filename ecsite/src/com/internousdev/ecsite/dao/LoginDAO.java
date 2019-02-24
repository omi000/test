package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private LoginDTO loginDTO=new LoginDTO();

//	getLoginUserInfoメソッド
	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
//	変数sqlにSQL文を代入(login_user_transactionmテーブルの中にlogin_idとlogin_passが一致しているものがあるか)
		String sql="SELECT * FROM login_user_transaction where login_id=? AND login_pass=?";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
//	sql文のパラメータにActionで入れた値をいれる
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet=preparedStatement.executeQuery();

//	sql文を実行した際にデータベース内に情報があれば、
			if(resultSet.next()){
//	loginDTOにSQLを実行したときに一致したデータの値を各メソッドに代入する
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
//	SQl文を実行したときにlogin_idの値がnullでなければ
				if(!(resultSet.getString("login_id").equals(null))){
//	loginDTOのsetLoginFlgメソッドにtrueを代入する
					loginDTO.setLoginFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
//	結果をloginDTOに返す
		return loginDTO;
	}

//	public LoginDTO getLoginDTO(){
////		return loginDTO;
//	}

}
