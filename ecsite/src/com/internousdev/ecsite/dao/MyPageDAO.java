package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();

//	List型の戻り値があるgetMyPageUserInfoメソッド
	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id)throws SQLException{
//	【List型】の変数myPageDTOを生成する
		ArrayList<MyPageDTO> myPageDTO=new ArrayList<MyPageDTO>();
//	変数sqlにSQL文の代入(6つの情報の取得をuser_buy_item_transactionとitem_info_transactionを結合したテーブルからパラメータに引き渡される商品IDとユーザーIDで検索さらにそのテーブルの形は購入した時間が新しい順のかたちにする)
		String sql="SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id=iit.id WHERE ubit.item_transaction_id=? AND ubit.user_master_id=? ORDER BY insert_date DESC";
		try{
//	sql文のパラメータを指定して、実行(ユーザーの購入履歴が新しい順に6つの項目がのっている形になる)
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,user_master_id);

			ResultSet resultSet=preparedStatement.executeQuery();
//	出来上がったテーブルの1番目からおわるまで繰り返される
			while(resultSet.next()){
//	MyPageDTO型の変数dtoの生成
				MyPageDTO dto=new MyPageDTO();
//	dtoにSQL文で取得した情報をString型で各【メソッド】に代入する。
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setTotalPrice(resultSet.getString("total_price"));
				dto.setTotalCount(resultSet.getString("total_count"));
				dto.setPayment(resultSet.getString("pay"));
				dto.setInsert_date(resultSet.getString("insert_date"));
//	【List型】のmyPageDTOにdtoの値を追加する
				myPageDTO.add(dto);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return myPageDTO;
	}
//	buyItemHistoryメソッド(MyPageActionから引数が引き渡されたときに実行するメソッド)
	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{
// 変数sqlにSQL文の代入(user_buy_item_transactionテーブルのパラメータに引き渡される、商品IDとユーザーIDで一致しているものがあればそのテーブル情報を削除する)
		String sql="DELETE FROM user_buy_item_transaction WHERE item_transaction_id=? AND user_master_id=?";

		PreparedStatement preparedStatement;
//	resultに0を代入する。(初期値)
		int result=0;
//	SQL文の実行
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,item_transaction_id);
			preparedStatement.setString(2,user_master_id);
//	削除した件数をresultに代入する。
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return result;

	}


}
