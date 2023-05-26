package com.example.internetprojectpractice.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {

	static String URL = "jdbc:mysql://localhost:3306/jsp";
	static String USERNAME = "root";
	static String PWD = "123456";

	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(URL, USERNAME, PWD);
		return connection;
	}
	
	public static PreparedStatement createPreparedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		return pstmt;
	}

	// 实现通用的增删改
	public boolean executeUpdate(String sql, Object[] params) {
		boolean flag = false;

		try {
			
			pstmt=createPreparedStatement(sql,params);
			
			int count = pstmt.executeUpdate();
			if (count > 0) {
				flag = true;
				return flag;
			} else {
				flag = false;
				return flag;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return flag;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return flag;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (getConnection() != null)
					getConnection().close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	// 通用的查
	public ResultSet executequery(String sql, Object[] params) {

		try {
			pstmt = createPreparedStatement(sql,params);
			rs = pstmt.executeQuery();
			return rs;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		
	}
}
