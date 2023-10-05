package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*1*/public class test {

/*2*/public static void main(String[] args) {
/*3*/	public Connection conectarBD() {
			Connection conn = null;
/*4*/		try {
				Class.forName("com.mysql.Driver.Manager").newInstance();
				String url = "jdbc:mysql://157.0.0.1/test?user=lopes&password=123";
				conn = DriverManager.getConnection(url);
/*5*/		} catch (Exception e) { }
			return conn; }
/*6*/	public String nome="";
/*7*/	public boolean result = false;
/*8*/	public boolean verificarUsuario(String login, String senha) {
			String sql = "";
			public Connection conectarBD();
			//INSTRUÇÃO SQL
			sql += "select nome from usuario ";
			sql += "where login = " + "'" + login + "'";
			sql += " and senha = " + "'" + senha + "';";
/*9*/		try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
/*10*/			if(rs.next()) {
					result = true;
					nome = rs.getString("nome");}
/*11*/			} catch (Exception e) { }
			return result;
			} // fim da class