package com.internousdev.login.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/logindb2_kudo";

	private static String user = "root";
	private static String password = "mysql";
	//MｙSQLにアクセスする為に必要な情報を変数に入れているよ

	public Connection getConnection(){
		Connection con = null;
		//conを一度初期化するよ

		try{
			Class.forName(driverName);
			con = (Connection)DriverManager.getConnection(url,user,password);
			//ドライバーをロードして、さっき情報を入れた変数を使ってMySQLに接続するよ
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			//まずまずしてクラスがないよ！って時にエラー結果を表示するよ
		}catch(SQLException e){
			e.printStackTrace();
			//SQLでの例外的なエラーがでちゃったら結果を表示するよ
		}
		return con;
		//MySQLに接続した結果を呼び出した元に返すよ
	}

}
