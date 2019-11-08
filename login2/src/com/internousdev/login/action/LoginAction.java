package com.internousdev.login.action;

import java.sql.SQLException;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	//struts2が持ってるActionSupportクラスを継承するよ

	private String name;
	private String password;
	/*このクラスにはこういう変数(データ)があるよ
	 * JSPファイルから受け取る値でもあるよ*/

	public String execute() throws SQLException{
		String ret = ERROR;
		//retに初期値としてERRORを入れておくよ

		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		//インスタンス化したよ

		dto = dao.select(name, password);
		/*①JSPから取得したデータを引数として、
		 *　LoginDAOクラスの中のselectメソッドを呼び出すよ
		 *②DAOで取得した結果をLoginDTOに入れるよ*/

		if(name.equals(dto.getName())){
			//JSPから取得したnameがdtoからgetした値と一緒か確認してるよ
			if(password.equals(dto.getPassword())){
			//nameがあっていたら、同じくpasswordも一緒か確認するよ
				ret = SUCCESS;
				//どっちも合っていたら、戻り値のretをSUCCESSに書き換えるよ
			}
		}
		return ret;
		//呼び出し元にretの内容(ERRORかSUCCESS)を返すよ
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
		/*this.name、つまりJSPでユーザが入力し、ここで受け取った情報が、
		 * このくらすのnameフィールドに格納されるよ*/
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

}
