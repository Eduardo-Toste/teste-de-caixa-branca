package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe Test é responsável por conectar a um banco de dados MySQL e verificar um usuário.
 */
public class Test {

    /**
     * Método para estabelecer uma conexão com o banco de dados MySQL.
     * @return A conexão com o banco de dados ou null se ocorrer um erro na conexão.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // Configuração da URL de conexão com o banco de dados
            String url = "jdbc:mysql://157.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Nome do usuário recuperado após a verificação.
     */
    public String nome = "";

    /**
     * Resultado da verificação do usuário.
     */
    public boolean result = false;

    /**
     * Verifica a existência de um usuário no banco de dados.
     * @param login O nome de usuário a ser verificado.
     * @param senha A senha do usuário a ser verificada.
     * @return true se o usuário existe no banco de dados, false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        Connection conn = conectarBD();
        if (conn == null) {
            return false;
        }

        String sql = "SELECT nome FROM usuario " +
                     "WHERE login = '" + login + "' " +
                     "AND senha = '" + senha + "';";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fecha a conexão com o banco de dados
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
