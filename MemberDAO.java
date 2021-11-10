package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {			//DB와 연동
	private Connection conn; 		//연결객체
	private PreparedStatement ps;	//전송객체
	private ResultSet rs;			//결과객체
	
	//DB접속 : ojdbc8.jar(C:\oracle18c\dbhomeXE\jdbc\lib) → WebContent > WEB-INF > lib : 복&붙 ▶ 정적로딩
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//동적로딩
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception!!!");
		}
		return conn;
	}//getConn()
	
	
	
	
	
	
	
	
	
	
	
}//class
