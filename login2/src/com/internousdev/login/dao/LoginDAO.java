package com.internousdev.login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;

public class LoginDAO {
	public LoginDTO select(String name,String password) throws SQLException{
		LoginDTO dto = new LoginDTO();
		DBConnector db = new DBConnector();
		//インスタンス化するよ
		Connection con = db.getConnection();
		//DBCクラスを呼び出してMySQLに接続するよ

		String sql ="select * from user where user_name=? and password=?";
		//変数sqlを定義したよ

	try{
		PreparedStatement ps = con.prepareStatement(sql);
		//conメソッドでMysqlに接続して、PreparedStatementに情報を入れるよ
		ps.setString(1, name);
		ps.setString(2, password);
		/*さっき定義した変数sqlのsql文の中にある
		 一つ目の？にname、二つ目の？にpasswordの情報が
		 はいるよ。情報はActionから送られてくるよ
		 */
		ResultSet rs = ps.executeQuery();
		//sql文の実行をするよ、戻り値はrsだよ

		if(rs.next()){
			dto.setName(rs.getString("user_name"));
			dto.setPassword(rs.getString("password"));
			/*DBの行を一行下にずらしてデータを抽出するよ
			 * sql文を実行してgetしたそれぞれのデータを
			 * dtoクラスのsetterを使ってdtoクラスに格納するよ */
		}
	}catch(SQLException e){
		e.printStackTrace();
		//SQLの例外的エラーが出たら表示するね
	}finally{
		con.close();
		//最後は接続を終了するよ
	}
	return dto;
	//dto、つまりLoginDTO(このクラスの結果)を呼び出し元のActionクラスに返すよ
	}

}
