package repositorio;

import conn.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Quarto;


public class RepQuarto{
    
    Connection con;

    public boolean inserir(Quarto quarto){
        
        con = ConexaoMySql.getConexao(); 
        
        String sql = "insert into quarto (num_quarto,"
                 + "tipo,descricao,valor,reservado,status) values "
                 + "(?,?,?,?,?,?)";
         try{
             con.setAutoCommit(false);
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setString(1, quarto.getNumero());
             stmt.setString(2, quarto.getTipo());
             stmt.setString(3, quarto.getDescricao());
             stmt.setDouble(4, quarto.getValor());
             stmt.setInt(5, 0);
             stmt.setInt(6, 1);

             
             stmt.execute();
             con.commit();
             ConexaoMySql.fecharConexao();
             
            return true;
         }catch(Exception ex){
             try{
                 con.rollback();
                 System.err.println(ex.getMessage());
                 return false;
             }catch(SQLException exSql){
                 System.err.println(exSql.getMessage());
             }
         }
         
       return true;
    }
    
  public List<Quarto> retornar(){
      
      con = ConexaoMySql.getConexao();
      List<Quarto> quartos = new ArrayList<>();
      
      String sql = "select * from quarto where status = 1 order by id desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Quarto quarto = new Quarto();
              
              quarto.setId(rs.getInt("id"));
              quarto.setNumero(rs.getString("num_quarto"));
              quarto.setTipo(rs.getString("tipo"));
              quarto.setDescricao(rs.getString("descricao"));
              quarto.setValor(rs.getDouble("valor"));
              quarto.setReservado(rs.getInt("reservado"));

              
              quartos.add(quarto);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return quartos;
  }  
  
  
   public List<Quarto> disponiveisreservados(){
      
      con = ConexaoMySql.getConexao();
      List<Quarto> quartos = new ArrayList<>();
      
      String sql = "select distinct q.* from quarto q, reserva r where q.id = r.quarto_id and "
              + "r.data_entrada > CURRENT_DATE and r.status = 'Reservada' and q.reservado = 0 and q.status = 1";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Quarto quarto = new Quarto();
              
              quarto.setId(rs.getInt("id"));
              quarto.setNumero(rs.getString("num_quarto"));
              quarto.setTipo(rs.getString("tipo"));
              quarto.setDescricao(rs.getString("descricao"));
              quarto.setValor(rs.getDouble("valor"));

              
              quartos.add(quarto);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return quartos;
  }  
   
   public List<Quarto> disponiveis(){
      
      con = ConexaoMySql.getConexao();
      List<Quarto> quartos = new ArrayList<>();
      
      String sql = "select distinct q.* from quarto q, reserva r where "
              + "q.id = r.quarto_id and r.status != 'Reservada' and q.reservado = 0 and q.status = 1";
              
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Quarto quarto = new Quarto();
              
              quarto.setId(rs.getInt("id"));
              quarto.setNumero(rs.getString("num_quarto"));
              quarto.setTipo(rs.getString("tipo"));
              quarto.setDescricao(rs.getString("descricao"));
              quarto.setValor(rs.getDouble("valor"));

              
              quartos.add(quarto);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return quartos;
  }
   
     public List<Quarto> disponiveisparareservar(){
      
      con = ConexaoMySql.getConexao();
      List<Quarto> quartos = new ArrayList<>();
      
      String sql = "select distinct * from quarto where reservado = 0 and status = 1";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Quarto quarto = new Quarto();
              
              quarto.setId(rs.getInt("id"));
              quarto.setNumero(rs.getString("num_quarto"));
              quarto.setTipo(rs.getString("tipo"));
              quarto.setDescricao(rs.getString("descricao"));
              quarto.setValor(rs.getDouble("valor"));

              
              quartos.add(quarto);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return quartos;
  }
   
   public List<Quarto> pesquisardisponiveisr(String valor, String tipoPesquisa){
      
      con = ConexaoMySql.getConexao();
      List<Quarto> quartos = new ArrayList<>();
      
      String sql = ""; 
      
       if(tipoPesquisa.equals("tipo")){
       sql = "select distinct q.* from quarto q, reserva r where q.id = r.quarto_id and "
              + "r.data_entrada > CURRENT_DATE and q.reservado = 0 and r.status = 'Reservada' and q.status = 1 "
               + "and tipo like '%"+valor+"%'";
      }else if(tipoPesquisa.equals("numero")){
       sql = "select distinct q.* from quarto q, reserva r where q.id = r.quarto_id and "
              + "r.data_entrada > CURRENT_DATE and q.reservado = 0 and r.status = 'Reservada' and q.status = 1 "
               + "and num_quarto = '"+valor+"'";
      }
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Quarto quarto = new Quarto();
              
              quarto.setId(rs.getInt("id"));
              quarto.setNumero(rs.getString("num_quarto"));
              quarto.setTipo(rs.getString("tipo"));
              quarto.setDescricao(rs.getString("descricao"));
              quarto.setValor(rs.getDouble("valor"));

              
              quartos.add(quarto);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return quartos;
  }
   
   public List<Quarto> pesquisardisponiveis(String valor, String tipoPesquisa){
      
      con = ConexaoMySql.getConexao();
      List<Quarto> quartos = new ArrayList<>();
      
      String sql = ""; 
      
       if(tipoPesquisa.equals("tipo")){
       sql = "select distinct q.* from quarto q, reserva r where "
              + "q.id = r.quarto_id and r.status != 'Reservada' and "
               + "q.reservado = 0 and q.status = 1 and tipo like '%"+valor+"%'";
      }else if(tipoPesquisa.equals("numero")){
       sql = "select distinct q.* from quarto q, reserva r where "
              + "q.id = r.quarto_id and r.status != 'Reservada' and "
               + "q.reservado = 0 and q.status = 1 and num_quarto = '"+valor+"'";
      }
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Quarto quarto = new Quarto();
              
              quarto.setId(rs.getInt("id"));
              quarto.setNumero(rs.getString("num_quarto"));
              quarto.setTipo(rs.getString("tipo"));
              quarto.setDescricao(rs.getString("descricao"));
              quarto.setValor(rs.getDouble("valor"));

              
              quartos.add(quarto);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return quartos;
  }
   
      public boolean atualizar(Quarto quarto) {

        con = ConexaoMySql.getConexao();
        String sql = "update quarto set num_quarto = ?, tipo = ?,"
                + "descricao = ?, valor = ? where id = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, quarto.getNumero());
            stmt.setString(2, quarto.getTipo());
            stmt.setString(3, quarto.getDescricao());
            stmt.setDouble(4, quarto.getValor());         
            stmt.setInt(5, quarto.getId());
             
            stmt.execute();

            con.commit();
            ConexaoMySql.fecharConexao();

            return true;

        } catch (SQLException ex) {
            try {
                con.rollback();
                System.err.println(ex);
                return false;
            } catch (SQLException ex1) {
                System.err.println(ex1);
            }

            return false;
        }

    }
      
      
      public boolean atulaizarativo(){
       
       con = ConexaoMySql.getConexao();
      String sql = "update quarto q, reserva r set q.reservado = ? where q.id = r.quarto_id "
              + "and r.data_entrada <= current_date and r.data_saida >= current_date "
              + "and r.status = 'Reservada' and q.status = 1";
      
      try{
          
          con.setAutoCommit(false);
          PreparedStatement stmt = con.prepareStatement(sql);
          
          stmt.setInt(1, 1);
          
          stmt.execute();
          con.commit();
          ConexaoMySql.fecharConexao();
      
          return true;   
      }catch(SQLException ex){
          
          return false;
      }
       
   }
      
      public boolean atulaizardesativoauto(){
       
       con = ConexaoMySql.getConexao();
      String sql = "update quarto q, reserva r set q.reservado = ?, r.status = ? where q.id = r.quarto_id "
              + "and r.data_saida < current_date and r.status = 'Reservada' and q.status = 1";
      
      try{
          
          con.setAutoCommit(false);
          PreparedStatement stmt = con.prepareStatement(sql);
          
          stmt.setInt(1, 0);
          stmt.setString(2, "Finalizada");
          
          stmt.execute();
          con.commit();
          ConexaoMySql.fecharConexao();
      
          return true;   
      }catch(SQLException ex){
          
          return false;
      }
       
   }
      
      
  public int retornarTotalDisponivel() {

        con = ConexaoMySql.getConexao();
        int ret = 0;

        String sql = "select count(*) as total from quarto where reservado = 0 and status = 1";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ret = rs.getInt("total");
            }
        } catch (SQLException ex) {
            return ret;
        }

        ConexaoMySql.fecharConexao();

        return ret;
    } 
   
   public List<Quarto> pesquisar(String valor, String tipoPesquisa){
      
      con = ConexaoMySql.getConexao();
      List<Quarto> quartos = new ArrayList<>();
      
      String sql = ""; 
      
       if(tipoPesquisa.equals("tipo")){
       sql = "select * from quarto where status = 1 and tipo like '%"+valor+"%'";
      }else if(tipoPesquisa.equals("numero")){
       sql = "select * from quarto where status = 1 and num_quarto = '"+valor+"'";
      }
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Quarto quarto = new Quarto();
              
              quarto.setId(rs.getInt("id"));
              quarto.setNumero(rs.getString("num_quarto"));
              quarto.setTipo(rs.getString("tipo"));
              quarto.setDescricao(rs.getString("descricao"));
              quarto.setValor(rs.getDouble("valor"));
              quarto.setReservado(rs.getInt("reservado"));
              
              quartos.add(quarto);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return quartos;
  }
      
     
  public boolean excluir(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "update quarto set status = ? where id = ?";
      
      try{
          
          con.setAutoCommit(false);
          PreparedStatement stmt = con.prepareStatement(sql);
          stmt.setInt(1, 0);
          stmt.setInt(2, id);
          
          stmt.execute();
          con.commit();
          ConexaoMySql.fecharConexao();
      
          return true;   
      }catch(SQLException ex){
          
          return false;
      }
        
  }
  

}