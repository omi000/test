package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;
import com.internousdev.template.util.DateUtil;


public class BuyItemCompleteDAO {

		//DateUtilのインスタンス化
		private DateUtil dateUtil=new DateUtil();

		private String sql="INSERT INTO user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?)";

		public void buyItemInfo(String item_transaction_id,String user_master_id,String total_price,String total_count,String pay)throws SQLException{
				DBConnector dbConnector=new DBConnector();
				Connection connection=dbConnector.getConnection();
				
				
				//引数に入ったActionクラスから引き渡された値と、dateUttilの値をSQL文のパラメータに当てはめる
				try{
					PreparedStatement preparedStatement=connection.prepareStatement(sql);
					preparedStatement.setString(1, item_transaction_id);
					preparedStatement.setString(2, total_price);
					preparedStatement.setString(3, total_count);
					preparedStatement.setString(4, user_master_id);
					preparedStatement.setString(5, pay);
					preparedStatement.setString(6, dateUtil.getDate());
				
				//SQL文を実行して、データベースに情報を格納する。
					preparedStatement.execute();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					connection.close();
				}
		}



}
