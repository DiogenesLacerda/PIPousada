package repositorio;

import conn.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Reserva;


public class RepReserva{
    
    Connection con;

    public boolean inserir(Reserva reserva){
        
        con = ConexaoMySql.getConexao(); 
        
        String sql = "insert into reserva (data_entrada,data_saida,cliente_id,"
                + "quarto_id,fpag_id,valor,observacoes,status)"
                + " values (?,?,?,?,?,?,?,?)";
         try{
             con.setAutoCommit(false);
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setString(1, reserva.dataentradaTostringsql());
             stmt.setString(2, reserva.datasaidaTostringsql());
             stmt.setInt(3, reserva.getClientid());
             stmt.setInt(4, reserva.getQuartoid());
             stmt.setInt(5, reserva.getFpagid());
             stmt.setDouble(6, reserva.getValor());
             stmt.setString(7, reserva.getObservacoes());
             stmt.setString(8, reserva.getStatus());
             
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
    
  public List<Reserva> retornar(){
      
      con = ConexaoMySql.getConexao();
      List<Reserva> reservas = new ArrayList<>();
      
      String sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id order by id desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Reserva reserva = new Reserva();
              
              reserva.setId(rs.getInt("id"));
              reserva.setDtentrada(rs.getTimestamp("data_entrada").toLocalDateTime());
              reserva.setDtsaida(rs.getTimestamp("data_saida").toLocalDateTime());
              reserva.setDtreserva(rs.getTimestamp("data_reserva").toLocalDateTime());
              reserva.setValor(rs.getDouble("valor"));
              reserva.setStatus(rs.getString("status"));
              reserva.setClientid(rs.getInt("cliente_id"));
              reserva.setQuartoid(rs.getInt("quarto_id"));
              reserva.setFpagid(rs.getInt("fpag_id"));
              reserva.setObservacoes(rs.getString("observacoes"));
              reserva.setCliente(rs.getString("nome"));
              reserva.setCliente_cpf(rs.getString("cpf"));
              reserva.setNumquarto(rs.getString("num_quarto"));
              reserva.setFpag(rs.getString("descricao"));
              
              

              
              reservas.add(reserva);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return reservas;
  }  
  
  public List<Reserva> reservasreservadas(){
      
      con = ConexaoMySql.getConexao();
      List<Reserva> reservas = new ArrayList<>();
      
      String sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id "
              + " and r.status = 'Reservada' and r.data_entrada > current_date order by id desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Reserva reserva = new Reserva();
              
              reserva.setId(rs.getInt("id"));
              reserva.setDtentrada(rs.getTimestamp("data_entrada").toLocalDateTime());
              reserva.setDtsaida(rs.getTimestamp("data_saida").toLocalDateTime());
              reserva.setDtreserva(rs.getTimestamp("data_reserva").toLocalDateTime());
              reserva.setValor(rs.getDouble("valor"));
              reserva.setStatus(rs.getString("status"));
              reserva.setClientid(rs.getInt("cliente_id"));
              reserva.setQuartoid(rs.getInt("quarto_id"));
              reserva.setFpagid(rs.getInt("fpag_id"));
              reserva.setObservacoes(rs.getString("observacoes"));
              reserva.setCliente(rs.getString("nome"));
              reserva.setCliente_cpf(rs.getString("cpf"));
              reserva.setNumquarto(rs.getString("num_quarto"));
              reserva.setFpag(rs.getString("descricao"));
              
              

              
              reservas.add(reserva);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return reservas;
  }  
  
  
  public List<Reserva> pesquisarreservadas(String valor, String tipoPesquisa){
      
      con = ConexaoMySql.getConexao();
      List<Reserva> reservas = new ArrayList<>();
      
      String sql ="";
             if(tipoPesquisa.equals("quarto")){
             sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id "
              + " and r.status = 'Reservada' and r.data_entrada > current_date and q.num_quarto = '"+valor+"'";
             }else if(tipoPesquisa.equals("cliente")){
              sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id "
              + " and r.status = 'Reservada' and r.data_entrada > current_date and c.nome like '%"+valor+"%'";
             }else if(tipoPesquisa.equals("numero")){
                 sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id "
              + " and r.status = 'Reservada' and r.data_entrada > current_date and r.id = '"+valor+"'";
             }
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Reserva reserva = new Reserva();
              
              reserva.setId(rs.getInt("id"));
              reserva.setDtentrada(rs.getTimestamp("data_entrada").toLocalDateTime());
              reserva.setDtsaida(rs.getTimestamp("data_saida").toLocalDateTime());
              reserva.setDtreserva(rs.getTimestamp("data_reserva").toLocalDateTime());
              reserva.setValor(rs.getDouble("valor"));
              reserva.setStatus(rs.getString("status"));
              reserva.setClientid(rs.getInt("cliente_id"));
              reserva.setQuartoid(rs.getInt("quarto_id"));
              reserva.setFpagid(rs.getInt("fpag_id"));
              reserva.setObservacoes(rs.getString("observacoes"));
              reserva.setCliente(rs.getString("nome"));
              reserva.setCliente_cpf(rs.getString("cpf"));
              reserva.setNumquarto(rs.getString("num_quarto"));
              reserva.setFpag(rs.getString("descricao"));
              
              

              
              reservas.add(reserva);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return reservas;
  }  
  
  public List<Reserva> reservasativa(){
      
      con = ConexaoMySql.getConexao();
      List<Reserva> reservas = new ArrayList<>();
      
      String sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id "
              + " and r.status = 'Reservada' and r.data_entrada <= current_date and r.data_saida >= current_date order by id desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Reserva reserva = new Reserva();
              
              reserva.setId(rs.getInt("id"));
              reserva.setDtentrada(rs.getTimestamp("data_entrada").toLocalDateTime());
              reserva.setDtsaida(rs.getTimestamp("data_saida").toLocalDateTime());
              reserva.setDtreserva(rs.getTimestamp("data_reserva").toLocalDateTime());
              reserva.setValor(rs.getDouble("valor"));
              reserva.setStatus(rs.getString("status"));
              reserva.setClientid(rs.getInt("cliente_id"));
              reserva.setQuartoid(rs.getInt("quarto_id"));
              reserva.setFpagid(rs.getInt("fpag_id"));
              reserva.setObservacoes(rs.getString("observacoes"));
              reserva.setCliente(rs.getString("nome"));
              reserva.setCliente_cpf(rs.getString("cpf"));
              reserva.setNumquarto(rs.getString("num_quarto"));
              reserva.setFpag(rs.getString("descricao"));
              
              

              
              reservas.add(reserva);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return reservas;
  }  
  
  
  public List<Reserva> reservaterminahoje(){
      
      con = ConexaoMySql.getConexao();
      List<Reserva> reservas = new ArrayList<>();
      
      String sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id "
              + " and r.status = 'Reservada' and r.data_saida = current_date order by id desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Reserva reserva = new Reserva();
              
              reserva.setId(rs.getInt("id"));
              reserva.setDtentrada(rs.getTimestamp("data_entrada").toLocalDateTime());
              reserva.setDtsaida(rs.getTimestamp("data_saida").toLocalDateTime());
              reserva.setDtreserva(rs.getTimestamp("data_reserva").toLocalDateTime());
              reserva.setValor(rs.getDouble("valor"));
              reserva.setStatus(rs.getString("status"));
              reserva.setClientid(rs.getInt("cliente_id"));
              reserva.setQuartoid(rs.getInt("quarto_id"));
              reserva.setFpagid(rs.getInt("fpag_id"));
              reserva.setObservacoes(rs.getString("observacoes"));
              reserva.setCliente(rs.getString("nome"));
              reserva.setCliente_cpf(rs.getString("cpf"));
              reserva.setNumquarto(rs.getString("num_quarto"));
              reserva.setFpag(rs.getString("descricao"));
              
              

              
              reservas.add(reserva);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return reservas;
  } 
  
  
  public List<Reserva> pesquisar(String valor, String tipoPesquisa){
      
      con = ConexaoMySql.getConexao();
      List<Reserva> reservas = new ArrayList<>();
      
      String sql = ""; 
      
       if(tipoPesquisa.equals("numero")){
       sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id and r.id= '"+valor+"'";
      }else if(tipoPesquisa.equals("cliente")){
       sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id and c.nome like '%"+valor+"%'";
      }else if(tipoPesquisa.equals("status")){
       sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id and r.status like '%"+valor+"%'";
      }else if(tipoPesquisa.equals("fpag")){
       sql = "select r.*, c.nome, c.cpf, q.num_quarto, f.descricao from reserva r, cliente c, quarto q, fpag f "
              + "where r.cliente_id = c.id and r.quarto_id = q.id and r.fpag_id = f.id and f.descricao like '%"+valor+"%'";
      }
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Reserva reserva = new Reserva();
              
              reserva.setId(rs.getInt("id"));
              reserva.setDtentrada(rs.getTimestamp("data_entrada").toLocalDateTime());
              reserva.setDtsaida(rs.getTimestamp("data_saida").toLocalDateTime());
              reserva.setDtreserva(rs.getTimestamp("data_reserva").toLocalDateTime());
              reserva.setValor(rs.getDouble("valor"));
              reserva.setStatus(rs.getString("status"));
              reserva.setClientid(rs.getInt("cliente_id"));
              reserva.setQuartoid(rs.getInt("quarto_id"));
              reserva.setFpagid(rs.getInt("fpag_id"));
              reserva.setObservacoes(rs.getString("observacoes"));
              reserva.setCliente(rs.getString("nome"));
              reserva.setCliente_cpf(rs.getString("cpf"));
              reserva.setNumquarto(rs.getString("num_quarto"));
              reserva.setFpag(rs.getString("descricao"));
              
              reservas.add(reserva);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return reservas;
  }
  
  
  
  
      public boolean atualizar(Reserva reserva) {

        con = ConexaoMySql.getConexao();
        String sql = "update reserva set observacoes = ? where id = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, reserva.getObservacoes());
            stmt.setInt(2, reserva.getId());
             
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
      
      
   public boolean finalizar(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "update reserva r, quarto q set r.status = ?, q.reservado = ? where "
              + "r.quarto_id = q.id and r.id = ?";
      
      try{
          
          con.setAutoCommit(false);
          PreparedStatement stmt = con.prepareStatement(sql);
          
          stmt.setString(1, "Finalizada");
          stmt.setInt(2, 0);
          stmt.setInt(3, id);
          
          stmt.execute();
          con.commit();
          ConexaoMySql.fecharConexao();
      
          return true;   
      }catch(SQLException ex){
          
          return false;
      }
        
  }
   
   public int retornarvenda() {

        con = ConexaoMySql.getConexao();
        int ret = 0;

        String sql = "select id as total from reserva order by id desc limit 1";

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
     
  public boolean cancelar(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "update reserva set status = ? where id = ?";
      
      try{
          
          con.setAutoCommit(false);
          PreparedStatement stmt = con.prepareStatement(sql);
          
          stmt.setString(1, "Cancelada");
          stmt.setInt(2, id);
          
          stmt.execute();
          con.commit();
          ConexaoMySql.fecharConexao();
      
          return true;   
      }catch(SQLException ex){
          
          return false;
      }
        
  }
  
  public int retornarTotalativas() {

        con = ConexaoMySql.getConexao();
        int ret = 0;

        String sql = "select count(*) as total from reserva where status = 'Reservada'"
                + " and data_entrada <= current_date and data_saida >= current_date order by id desc";

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
  
  public int retornarTotalreservadas() {

        con = ConexaoMySql.getConexao();
        int ret = 0;

        String sql = "select count(*) as total from reserva where "
                + "status = 'Reservada' and data_entrada > current_date order by id desc";

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
  
  public int retornarTotalTerminamHoje() {

        con = ConexaoMySql.getConexao();
        int ret = 0;

        String sql = "select count(*) as total from reserva where status = 'Reservada' "
                + "and data_saida = current_date order by id desc";

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
  
  
  public int periodoreservado(String dte, String dts, int id) {

        con = ConexaoMySql.getConexao();
        int ret = 0;

        String sql = "select count(*) as total from reserva where status = 'Reservada' "
                + "and quarto_id = '"+id+"' and ((data_entrada <= '"+dte+"' and data_saida >= '"+dte+"') "
                + "or (data_entrada <= '"+dts+"' and data_saida >= '"+dts+"') or (data_entrada >= '"+dte+"' and data_saida <= '"+dts+"'))";
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
  
}