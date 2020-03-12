package com.example.daily1.model.data;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class Material implements Serializable {

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("color")
	private String color;

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

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
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
			"Material{" +
			"id = '" + id + '\'' +
			",title = '" + title + '\'' +
			",color = '" + color + '\'' +
			",url = '" + url + '\'' +
			"}";
		}

}