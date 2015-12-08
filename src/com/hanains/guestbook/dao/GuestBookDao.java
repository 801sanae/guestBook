package com.hanains.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanains.guestbook.vo.GuestBookVo;

public class GuestBookDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	private Connection getConnection()throws SQLException{
		Connection conn = null;

		//1. 드라이버 로딩(class 로딩) 동적로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. DB 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "webdb", "webdb");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return conn;
	}

	//TODO
	public void insert(GuestBookVo vo){
		try{
			//1. 드라이버 로딩(class 로딩) 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. DB 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "webdb", "webdb");

			//3. statement준비
			String sql = "insert into guestbook values("
					+ "GUESTBOOK_SEQ.NEXTVAL,?,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);

			//4. binding
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());
			//5. sql실행
			pstmt.executeQuery();
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로딩 실패 : " + e1);
		} catch (SQLException e2) {
			System.out.println("DB 연결 실패 : " + e2);
		} finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException s){s.printStackTrace();}
		}
	}
	//TODO
	public void delete(GuestBookVo vo){
		try{
			System.out.println("::"+"delete start");
			//1. 드라이버 로딩(class 로딩) 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. DB 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "webdb", "webdb");

			//3. statement준비
			String sql = "delete from guestbook where no=? and password=?"; 

			pstmt = conn.prepareStatement(sql);
			//4. binding
			pstmt.setInt(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());
			//5. sql실행
			pstmt.executeQuery();
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로딩 실패 : " + e1);
		} catch (SQLException e2) {
			System.out.println("DB 연결 실패 : " + e2);
		} finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException s){s.printStackTrace();}
		}
		System.out.println("::"+"delete finish");
	}
	//TODO
	public List<GuestBookVo> getlist(){
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();

		try{
			//1. 드라이버 로딩(class 로딩) 동적로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. DB 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "webdb", "webdb");
			//3. statement 생성
			stmt = conn.createStatement();

			//4. sql 실행
			String sql = "select no,name,password,message,to_char(reg_date, 'YYYY-MM-DD HH:MI:SS') "
					+ "from guestbook";		
			rs = stmt.executeQuery(sql);

			//5. 결과가져오기
			while(rs.next()){
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String message = rs.getString(4);
				String reg_date = rs.getString(5);

				GuestBookVo vo = new GuestBookVo();

				vo.setNo(no);
				vo.setName(name);
				vo.setMessage(message);
				vo.setPassword(password);
				vo.setReg_date(reg_date);

				list.add(vo);
			}

		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로딩 실패 : " + e1);
		} catch (SQLException e2) {
			System.out.println("DB 연결 실패 : " + e2);
		} finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException s){s.printStackTrace();}
		}
		return list;
	}
}
