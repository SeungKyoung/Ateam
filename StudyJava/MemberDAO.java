package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {			//DB와 연동
	private Connection conn;		//연결 객체
	private PreparedStatement ps;	//전송 객체
	private ResultSet rs;			//결과 객체
	
	//DB접속 : ojdbc8.jar  c: 오라클18c안에 있는거 웹컨텐트 web-inf>lib : 복붙 -> 정적 로딩
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
