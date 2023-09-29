# Teste de Caixa Branca

## Descrição
O testes de caixa branca basicamente é uma tecnica de análise de código, na qual envolve o conhecimento da estrutura interna do código para conseguir gerar os cenários de possíveis erros. 

## Utilidade
Este tipo de teste garante que a camada lógica do software e a camada externa esteja em pleno funcionamento, sempre de acordo com os padrões e regras estabelecidas.

## Código utilizado no teste
```
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Teste {

	public static void main(String[] args) {
		public Connection conectarBD() {
			Connection conn = null;
			try {
				Class.forName("com.mysql.Driver.Manager").newInstance();
				String url = "jdbc:mysql://157.0.0.1/test?user=lopes&password=123";
				conn = DriverManager.getConnection(url);
			} catch (Exception e) { }
			return conn; }
		public String nome="";
		public boolean result = false;
		public boolean verificarUsuario(String login, String senha) {
			String sql = "";
			public Connection conectarBD();
			//INSTRUÇÃO SQL
			sql += "select nome from usuario ";
			sql += "where login = " + "'" + login + "'";
			sql += " and senha = " + "'" + senha + "';";
			try {
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) {
					result = true;
					nome = rs.getString("nome");}
				} catch (Exception e) { }
			return result;
			} //fim da class
		}

	}

}
```

## Erros localizados durante análise
- O nome da classe do driver MySQL está errado.
- A exceção Exception é genérica demais.
- Falta de boas práticas na estrutura do código como um todo.
- O método conectarBD() é desnecessário.
- As variáveis nome e result não têm valor inicial.
- O método verificarUsuario() não fecha a conexão com o banco de dados.
- Má administração da formatação.
- Utilização errada do método Catch.

## Observações e Requisitos
Não foi possível rodar o código por conta da quantidade de erros excessiva em sua construção. Foi utilizada a IDE Eclipse e versão 19 do JDK.
