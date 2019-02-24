package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private BuyItemDTO buyItemDTO=new BuyItemDTO();

//	Actionによって実行される
	public BuyItemDTO getBuyItemInfo(){
//sqlという変数に、sql文の代入(item_info_transactionテーブルの中のid、item_name、item_priceの情報を取得)
		String sql="SELECT id,item_name,item_price FROM item_info_transaction";

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
//	SQL文を実行したときに値が入っていたら
			if(resultSet.next()){
//	buyItemDTOにid、itemName、itemPriceをsetする
					buyItemDTO.setId(resultSet.getInt("id"));
					buyItemDTO.setItemName(resultSet.getString("item_name"));
					buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
//	buyItemDTOに結果を返す
		return buyItemDTO;
	}


}
