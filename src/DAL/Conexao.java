package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection con;
    public String mensagem;
    
    public Connection conectar()
    {
        mensagem = "";
        try
        {
            if (con == null || con.isClosed())
            {
                con = DriverManager.getConnection(
                "jdbc:sqlserver://localhost\\LAPTOP-P3O96OG3\\SQLEXPRESS:1433;databaseName=Desmatamento", 
                "sa", "121027");
            }
        }
        catch (SQLException e)
        {
            mensagem = "Erro de conexão com BD";
        }
        return con;
    }
    
    public void desconectar()
    {
        try
        {
            if (!con.isClosed())
            {
                con.close();
            }
        }
        catch (SQLException e)
        {
            mensagem = "Erro ao fechar conexão";
        }
    }
    
}
