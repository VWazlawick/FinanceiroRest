package br.unipar.financeirorest.Repositories;

import br.unipar.financeirorest.Infrastructure.ConnectionFactory;
import br.unipar.financeirorest.Model.Transacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;


public class TransacaoRepository {
    private static final String INSERT = 
            "INSERT INTO transacao(descricao valor, data, idcategoria) VALUES(?,?,?,?)";
    private static final String UPDATE = 
            "UPDATE transacao SET descricao = ? AND valor= ? AND data = ? AND idcategoria = ? WHERE id = ?";
    private static final String DELETE = 
            "DELETE transacao WHERE id = ?";
    private static final String FIND_ALL = 
            "SELECT * FROM transacao";
    private static final String FIND_BY_ID = 
            "SELECT * FROM transacao WHERE id = ?";
    
    public Transacao insert(Transacao transacao) throws NamingException, SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1, transacao.getDescricao());
            pstmt.setDouble(2, transacao.getValor());
            pstmt.setDate(3, new java.sql.Date(transacao.getData().getTime()));
            pstmt.setInt(4, transacao.getCategoria().getId());
            
            pstmt.executeUpdate();
            
            rs = pstmt.getGeneratedKeys();
            
            rs.next();
            
            transacao.setId(rs.getInt(1));
            
        }  finally {
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
        return transacao;
    }
    
    public Transacao update(Transacao transacao) throws NamingException, SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setString(1, transacao.getDescricao());
            pstmt.setDouble(2, transacao.getValor());
            pstmt.setDate(3, new java.sql.Date(transacao.getData().getTime()));
            pstmt.setInt(4, transacao.getCategoria().getId());
            pstmt.setInt(1, transacao.getId());
            
            pstmt.executeQuery();
        } finally {
            if(conn!=null){
                conn.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
        }
        return transacao;
    }
    
    
}
