package com.example.daily1.model.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

import androidx.room.Entity;

@SuppressWarnings("unused")
@Entity(tableName = "tbl_packs")
public class Pack  {

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("price")
	private int price;

	@SerializedName("url")
	private String url;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
	public String toString(){
		return
				"Pack{" +
						"id = '" + id + '\'' +
						",title = '" + title + '\'' +
						",price = '" + price + '\'' +
						",url = '" + url + '\'' +
						"}";
	}
}