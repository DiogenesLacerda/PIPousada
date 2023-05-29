package repositorio;

import conn.ConexaoMySql;
import static conn.ConexaoMySql.con;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Fpag;


public class RepFpag{
    
   public List<Fpag> retornar(){
      
      con = ConexaoMySql.getConexao();
      List<Fpag> pagamentos = new ArrayList<>();
      
      String sql = "select * from fpag order by id desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Fpag fpag = new Fpag();
              
              fpag.setId(rs.getInt("id"));
              fpag.setDescricao(rs.getString("descricao"));
              
              pagamentos.add(fpag);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return pagamentos;
  }  
}