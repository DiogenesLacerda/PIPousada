package repositorio;

import conn.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class RepCliente {

    Connection con;

    public boolean inserir(Cliente cliente) {

        con = ConexaoMySql.getConexao();

        String sql = "insert into cliente (nome,"
                + "cpf,rg,sexo,telefone,data_nacimento,status) values "
                + "(?,?,?,?,?,?,?)";
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, String.valueOf(cliente.getSexo()));
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.dataTostringsql());
            stmt.setInt(7, 1);

            stmt.execute();
            con.commit();
            ConexaoMySql.fecharConexao();

            return true;
        } catch (Exception ex) {
            try {
                con.rollback();
                System.err.println(ex.getMessage());
                return false;
            } catch (SQLException exSql) {
                System.err.println(exSql.getMessage());
            }
        }

        return true;
    }

    public List<Cliente> retornar() {

        con = ConexaoMySql.getConexao();
        List<Cliente> clientes = new ArrayList<>();

        String sql = "select * from cliente where status = 1 order by id desc";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDatanasci(rs.getTimestamp("data_nacimento").toLocalDateTime());
                cliente.setSexo(rs.getString("sexo"));
                cliente.setTelefone(rs.getString("telefone"));

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            return null;
        }

        ConexaoMySql.fecharConexao();

        return clientes;
    }

    public boolean atualizar(Cliente cliente) {

        con = ConexaoMySql.getConexao();
        String sql = "update cliente set telefone = ?, nome = ?,"
                + "sexo = ?, cpf = ?, rg = ?, data_nacimento = ? where id = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, cliente.getTelefone());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getSexo());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getRg());
            stmt.setString(6, cliente.dataTostringsql());
            stmt.setInt(7, cliente.getId());

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

    public List<Cliente> pesquisar(String valor, String tipoPesquisa) {

        con = ConexaoMySql.getConexao();
        List<Cliente> clientes = new ArrayList<>();

        String sql = "";

        if (tipoPesquisa.equals("nome")) {
            sql = "select * from cliente where status = 1 and nome like '%" + valor + "%'";
        } else if (tipoPesquisa.equals("cpf")) {
            sql = "select * from cliente where status = 1 and cpf = '" + valor + "'";
        }

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDatanasci(rs.getTimestamp("data_nacimento").toLocalDateTime());
                cliente.setSexo(rs.getString("sexo"));
                cliente.setTelefone(rs.getString("telefone"));

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            return null;
        }

        ConexaoMySql.fecharConexao();

        return clientes;
    }

    public Cliente pesquisarreservar(String valor) {

        con = ConexaoMySql.getConexao();

        String sql = "select * from cliente where status = 1 and cpf = '" + valor + "'";
        Cliente cliente = new Cliente();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setDatanasci(rs.getTimestamp("data_nacimento").toLocalDateTime());
                cliente.setSexo(rs.getString("sexo"));
                cliente.setTelefone(rs.getString("telefone"));
            }

            ConexaoMySql.fecharConexao();
            return cliente;

        } catch (SQLException ex) {
            return null;
        }

    }

    public boolean excluir(int id) {

        con = ConexaoMySql.getConexao();
        String sql = "update cliente set status = ? where id = ?";

        try {

            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, 0);
            stmt.setInt(2, id);

            stmt.execute();
            con.commit();
            ConexaoMySql.fecharConexao();

            return true;
        } catch (SQLException ex) {

            return false;
        }

    }

}
