
package DAL;

import Modelo.DesmatamentoAmaz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DesmatamentoAmazDAO {
    
     private Conexao conexao = new Conexao();
     private String mensagem;
     
    public List<DesmatamentoAmaz> pesquisarDesmatamentoAno(DesmatamentoAmaz desmatamentoAmaz)
    {
        this.mensagem = "";
        List<DesmatamentoAmaz> listaDesma = new ArrayList<>();
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "select * from DesmatamentoAmaz where ano like ?";
            PreparedStatement stmt = con.prepareStatement(instrucaoSql);
            stmt.setInt(1, desmatamentoAmaz.getAno());
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next())
            {
                DesmatamentoAmaz DesmatamentoAmazLista = new DesmatamentoAmaz();
                
                DesmatamentoAmazLista.setAno(resultset.getInt("ano"));
                DesmatamentoAmazLista.setAreaDesmatada(resultset.getInt("areaDesmatada"));
                DesmatamentoAmazLista.setEstado(resultset.getString("estado"));
                listaDesma.add(DesmatamentoAmazLista);
            }
            conexao.desconectar();
        
           
        }
        catch (Exception e)
        {
            this.mensagem = conexao.mensagem + "\n" + e.getMessage();
        }
        return listaDesma;
    }
    
    public List<DesmatamentoAmaz> pesquisarTudo(DesmatamentoAmaz desmatamentoAmaz)
    {
    
        this.mensagem = "";
        List<DesmatamentoAmaz> listaDesma = new ArrayList<>();
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "select top 50 * from DesmatamentoAmaz";
            PreparedStatement stmt = con.prepareStatement(instrucaoSql);
           
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next())
            {
                DesmatamentoAmaz DesmatamentoAmazLista = new DesmatamentoAmaz();
                
                DesmatamentoAmazLista.setAno(resultset.getInt("ano"));
                DesmatamentoAmazLista.setAreaDesmatada(resultset.getInt("areaDesmatada"));
                DesmatamentoAmazLista.setEstado(resultset.getString("estado"));
                listaDesma.add(DesmatamentoAmazLista);
            }
            conexao.desconectar();
        
           
        }
        catch (Exception e)
        {
            this.mensagem = conexao.mensagem + "\n" + e.getMessage();
        }
        return listaDesma;
    
    
    }
     
    public String getMensagem()
    {
        return mensagem;
    }
    
    
}
