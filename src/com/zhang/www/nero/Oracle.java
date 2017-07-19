package com.zhang.www.nero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Collections;

public class Oracle {
	public static void main(String[] args) throws SQLException{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "root", "root");
			Statement stmt = conn.createStatement();
			try {
				PreparedStatement ps = conn.prepareStatement("select * from student where ID = ? ");
				ps.setString(1, "00128");
				ResultSet rs = ps.executeQuery();
				System.out.println(11);
				while(rs.next()){
					System.out.print(rs.getString(1) + " ");
					System.out.print(rs.getString(2) + " ");
					System.out.print(rs.getString(3) + " ");
					System.out.println(rs.getString(4));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				System.out.println("close.");
				conn.close();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
