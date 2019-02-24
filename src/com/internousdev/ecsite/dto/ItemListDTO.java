package com.internousdev.ecsite.dto;

public class ItemListDTO {
	public String id;
	public String itemName;
	public String totalPrice;
	public String totalStock;
	public String insert_date;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getTotalStock() {
		return totalStock;
	}
	public void setTotalCount(String totalStock) {
		this.totalStock = totalStock;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

}
