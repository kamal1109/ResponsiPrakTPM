package com.example.covid2021.model.faskes;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Respon_faskes {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private List<Data_faskes> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(List<Data_faskes> data){
		this.data = data;
	}

	public List<Data_faskes> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"Respon_faskes{" +
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}