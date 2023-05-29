package repositorio;

import conn.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class RepFuncionario {
    
    Connection con;

    public boolean inserir(Funcionario funcionario){
        
        con = ConexaoMySql.getConexao(); 
        
        String sql = "insert into funcionario (nome,"
                 + "cpf,rg,sexo,rua,numero,bairro,"
                 + "telefone,senha,data_nacimento) values "
                 + "(?,?,?,?,?,?,?,?,md5(?),?)";
         try{
             con.setAutoCommit(false);
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setString(1, funcionario.getNome());
             stmt.setString(2, funcionario.getCpf());
             stmt.setString(3, funcionario.getRg());
             stmt.setString(4, String.valueOf(funcionario.getSexo()));
             stmt.setString(5, funcionario.getRua());
             stmt.setString(6, funcionario.getNumero());
             stmt.setString(7, funcionario.getBairro());
             stmt.setString(8, funcionario.getTelefone());
             stmt.setString(9, funcionario.getSenha());
             stmt.setString(10,funcionario.dataTostringsql());
             
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
    
  public List<Funcionario> retornar(){
      
      con = ConexaoMySql.getConexao();
      List<Funcionario> funcionarios = new ArrayList<>();
      
      String sql = "select * from funcionario order by id desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Funcionario funcionario = new Funcionario();
              
              funcionario.setId(rs.getInt("id"));
              funcionario.setNome(rs.getString("nome"));
              funcionario.setCpf(rs.getString("cpf"));
              funcionario.setRg(rs.getString("rg"));
              funcionario.setDatanasci(rs.getTimestamp("data_nacimento").toLocalDateTime());
              funcionario.setSexo(rs.getString("sexo"));
              funcionario.setBairro(rs.getString("bairro"));
              funcionario.setRua(rs.getString("rua"));
              funcionario.setNumero(rs.getString("numero"));
              funcionario.setTelefone(rs.getString("telefone"));
              funcionario.setSenha(rs.getString("senha"));
              
              funcionarios.add(funcionario);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return funcionarios;
  }  
  
      public boolean atualizar(Funcionario funcionario) {

        con = ConexaoMySql.getConexao();
        String sql = "update funcionario set senha = md5(?), "
                + "rua = ?, telefone = ?, bairro = ?, numero = ?, nome = ?,"
                + "sexo = ?, cpf = ?, rg = ?, data_nacimento = ? where id = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, funcionario.getSenha());
            stmt.setString(2, funcionario.getRua());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getBairro());
            stmt.setString(5, funcionario.getNumero());
            stmt.setString(6, funcionario.getNome());
            stmt.setString(7, funcionario.getSexo());
            stmt.setString(8, funcionario.getCpf());
            stmt.setString(9, funcionario.getRg());
            stmt.setString(10, funcionario.dataTostringsql());          
            stmt.setInt(11, funcionario.getId());
             
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
  
    
  
  public boolean excluir(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "delete from funcionario where id = ?";
      
      try{
          
          con.setAutoCommit(false);
          PreparedStatement stmt = con.prepareStatement(sql);
          
          stmt.setInt(1, id);
          
          stmt.execute();
          con.commit();
          ConexaoMySql.fecharConexao();
      
          return true;   
      }catch(SQLException ex){
          
          return false;
      }
        
  }
  
   public int login(String cpf, String senha){
      
      con = ConexaoMySql.getConexao();
      int ret = 0;
      
      String sql = "select count(*) as total from funcionario where cpf = '"+cpf+"' and senha = md5('"+senha+"')";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);

          while(rs.next()){
              ret = rs.getInt("total");
          }
        
        
         
          
      }catch(SQLException ex){
          return ret;
      }
      
      ConexaoMySql.fecharConexao();
      return ret;
  }
   
   public String logado(String cpf, String senha){
      
      con = ConexaoMySql.getConexao();
      String ret="";
      
      String sql = "select nome from funcionario where cpf = '"+cpf+"' and senha = md5('"+senha+"')";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);

          while(rs.next()){
              ret = rs.getString("nome");
          }
        
        
         
          
      }catch(SQLException ex){
          return ret;
      }
      
      ConexaoMySql.fecharConexao();
      return ret;
  }
   
    
    
}
    

