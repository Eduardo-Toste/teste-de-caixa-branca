package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*1*/public class test {

/*2*/public static void main(String[] args) {
/*3*/	public Connection conectarBD() {
/*4*/		Connection conn = null;
			try {
				Class.forName("com.mysql.Driver.Manager").newInstance();
				String url = "jdbc:mysql://157.0.0.1/test?user=lopes&password=123";
/*5*/			conn = DriverManager.getConnection(url);
			} catch (Exception e) { }
			return conn; }
/*6*/	public String nome="";
/*7*/	public boolean result = false;
/*8*/	public boolean verificarUsuario(String login, String senha) {
/*9*/			String sql = ""; 
/*10*/			public Connection conectarBD();
			//INSTRUÇÃO SQL
/*11*/		sql += "select nome from usuario ";
/*12*/		sql += "where login = " + "'" + login + "'";
/*13*/		sql += " and senha = " + "'" + senha + "';";
			try {
/*14*/			Statement st = conn.createStatement();
/*15*/			ResultSet rs = st.executeQuery(sql);
/*16*/			if(rs.next()) {
/*17*/				result = true;
/*18*/				nome = rs.getString("nome");}
				} catch (Exception e) { }
			return result;
			} // fim da class