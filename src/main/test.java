package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Esta classe, intitulada 'test', disponibiliza métodos para estabelecer conexão com um banco de dados MySQL
 * e examinar a presença de um usuário com base em um login e senha fornecidos.
 */
public class test {

    /**
     * Este método cria uma conexão com o banco de dados MySQL.
     *
     * @return Uma instância de conexão com o banco de dados MySQL.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // Configura a URL de conexão
            String url = "jdbc:mysql://157.0.0.1/test?user=lopes&password=123";
            // Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Lida com exceções, caso ocorram
        }
        return conn;
    }

    // Variáveis de instância para armazenar o nome e o resultado da verificação do usuário
    public String nome = "";
    public boolean result = false;

    /**
     * Este método verifica a presença de um usuário com base no login e senha fornecidos.
     *
     * @param login O nome de usuário a ser examinado.
     * @param senha A senha do usuário a ser verificada.
     * @return 'true' se o usuário existe e 'false' caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD(); // Obtém uma conexão com o banco de dados

        // INSTRUÇÃO SQL
        sql += "select nome from usuario ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Lida com exceções, caso ocorram
        }
        return result;
    }

    // Fim da classe 'test'