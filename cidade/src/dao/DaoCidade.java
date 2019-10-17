/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Cidade;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DaoCidade {
     public static boolean inserir(Cidade objeto) {
        String sql = "INSERT INTO Cidade (sigla_estado, nome, numero_abitantes, data_emancipacao, distancia_capital, area_total) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSigla_estado());
            ps.setString(2, objeto.getNome());
            ps.setInt(3, objeto.getNumero_abitantes());
            ps.setDate(4, Date.valueOf(objeto.getData_emancipacao()));
            ps.setDouble(5, objeto.getDistancia_capital());
            ps.setDouble(6, objeto.getArea_total());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Cidade objeto = new Cidade();
        objeto.setSigla_estado("BR");
        objeto.setNome("Brasil");
        objeto.setNumero_abitantes(15);
        objeto.setData_emancipacao(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setDistancia_capital(1.50);
        objeto.setArea_total(1.50);
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     public static boolean alterar(Cidade objeto) {
        String sql = "UPDATE Cidade SET nome = ?, numero_abitantes = ?, area_total = ?, sigla_estado = ?, distancia_capital = ?, data_emancipacao = ?  WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome()); 
            ps.setInt(2, objeto.getNumero_abitantes());
            ps.setDouble(3, objeto.getArea_total());
            ps.setString(4, objeto.getSigla_estado());
            ps.setDouble(5, objeto.getDistancia_capital());
            ps.setDate(6, Date.valueOf(objeto.getData_emancipacao()));
            ps.setInt(7, objeto.getCodigo());
           
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static boolean excluir(Cidade objeto) {
        String sql = "DELETE FROM Cidade WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static List<Cidade> consultar() {
        List<Cidade> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, sigla_estado, numero_abitantes, area_total, distancia_capital, data_emancipacao FROM Cidade";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade objeto = new Cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("Codigo"));
                objeto.setNome(rs.getString("Nome"));
                objeto.setSigla_estado(rs.getString("Sigla_estado"));
                objeto.setNumero_abitantes(rs.getInt("Numero_abitantes"));
                objeto.setArea_total(rs.getDouble("Area_total"));
                objeto.setDistancia_capital(rs.getDouble("Distancia_capital"));
                objeto.setData_emancipacao(rs.getDate("data_emancipacao").toLocalDate());
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
      public static Cidade consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, sigla_estado, numero_abitantes, data_emancipacao, area_total, distancia_capital FROM Cidade WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade objeto = new Cidade();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                  objeto.setSigla_estado(rs.getString("Sigla_estado"));
                  objeto.setNumero_abitantes(rs.getInt("Numero_abitantes"));
                  objeto.setData_emancipacao(rs.getDate("data_emancipacao").toLocalDate());
                  objeto.setArea_total(rs.getDouble("Area_total"));
                  objeto.setDistancia_capital(rs.getDouble("Distancia_capital"));
                
                
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
