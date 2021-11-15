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
	
	
	//DB접속 해제
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("디비클로즈 예외처리 에러");
		}
	}


	public int memberInsert(MemberDTO dto) {
		conn = getConn();		//DB접속
		String sql = "insert into Member values(?, ?, ?, ?, ?, ?)";		//sql 문장 작성
		int succ = 0;			//sql 문장의 성공여부 판단하기 위한 변수
		try {
			ps = conn.prepareStatement(sql);			//전송객체 생성
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getTel());
			succ = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("멤버 인설트 예외 처리 에러 발생");
		}finally {
			dbClose();
		}
		return succ;
		
	}//memberInsert()
	
	
	
	

}//class
