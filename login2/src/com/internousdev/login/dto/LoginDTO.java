package com.internousdev.login.dto;

public class LoginDTO {
	private int id;
	private String name;
	private String password;
	//このクラスにはこういう変数(データ)があるよ

	public int getId(){
		return id;
	}
	//もしActionクラスがgetIdで呼び出した時、このフィールドを返すよ
	public void setId(int id){
		this.id = id;
	}
	/*もしDAOクラスがsetInt(id)で呼び出した時、このフィールドにDAO
	クラスが取得した情報を格納するよ*/

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

}
