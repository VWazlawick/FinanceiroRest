/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.financeirorest.Repositories;

import br.unipar.financeirorest.Infrastructure.ConnectionFactory;
import br.unipar.financeirorest.Model.Categoria;
import br.unipar.financeirorest.Model.TipoCategoriaEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author victo
 */
public class CategoriaRepository {
    private static final String INSERT = 
            "INSERT INTO categoria(descricao, tpcategoria) VALUES(?,?)";
    private static final String UPDATE = 
            "UPDATE categoria SET descricao = ? AND tpcategoria = ? WHERE id = ?";
    private static final String DELETE = 
            "DELETE categoria wHERE id = ?";
    private static final String FIND_ALL = 
            "SELECT * FROM categoria";
    private static final String FIND_BY_ID = 
            "SELECT * FROM categoria WHERE id = ?";
    
    public Categoria insert(Categoria categoria) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, categoria.getDescricao());
            pstmt.setString(2, categoria.getTipo().name());
            
            pstmt.executeUpdate();
            
            rs = pstmt.getGeneratedKeys();
            
            rs.next();
            
            categoria.setId(rs.getInt(1));
            
        } finally {
            if(conn!=null){
                conn.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(rs!=null){
                rs.close();
            }
        }
        return categoria;
    }
    
    public Categoria update(Categoria categoria) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, categoria.getDescricao());
            pstmt.setString(2, categoria.getTipo().name());
            pstmt.setInt(3, categoria.getId());
            
            pstmt.executeQuery();
        } finally {
            if(conn!=null){
                conn.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
        }
        return categoria;
    }
    
    public Categoria findById(int id) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Categoria categoria = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                categoria = new Categoria(rs.getInt("id"), rs.getString("descricao"), 
                        TipoCategoriaEnum.valueOf(rs.getString("tpcategoria")));
            }
            
        } finally {
            if(conn!=null){
                conn.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(rs!=null){
                rs.close();
            }
        }
        return categoria;
    }
    
    public List<Categoria> findAll() throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Categoria> lista = new ArrayList<>();
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                lista.add(new Categoria(rs.getInt("id"), rs.getString("descricao"), 
                        TipoCategoriaEnum.valueOf(rs.getString("tpcategoria"))));
            }
        } finally {
            if(conn!=null){
                conn.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(rs!=null){
                rs.close();
            }
        }
        
        return lista;
    }
    
    public void delete(int id) throws SQLException, NamingException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DELETE);
            
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
        } finally {
            if(conn!=null){
                conn.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }

        }
    }
}
