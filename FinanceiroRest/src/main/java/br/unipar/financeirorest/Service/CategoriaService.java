/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.financeirorest.Service;

    import br.unipar.financeirorest.Exceptions.ValidacaoException;
import br.unipar.financeirorest.Model.Categoria;
import br.unipar.financeirorest.Repositories.CategoriaRepository;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author victo
 */
public class CategoriaService {
    public Categoria insert(Categoria categoria) throws SQLException, NamingException, ValidacaoException{
        validacaoInsertOrUpdate(categoria);
        
        return new CategoriaRepository().insert(categoria);
    }
    
    public Categoria update(Categoria categoria) throws SQLException, NamingException, ValidacaoException{
        validacaoInsertOrUpdate(categoria);
        
        return new CategoriaRepository().update(categoria);
    }
    
    public Categoria findById(int id) throws SQLException, NamingException{
        
        return new CategoriaRepository().findById(id);
    }
    
    public List<Categoria> findAll() throws SQLException, NamingException{
        
        return new CategoriaRepository().findAll();
    }
    
    public void delete(int id) throws SQLException, NamingException, ValidacaoException{
        
        if(id==0){
            throw new ValidacaoException("Informe um cliente para excluir!");
        }
        new CategoriaRepository().delete(id);
    }
    
    public void validacaoInsertOrUpdate(Categoria categoria) throws ValidacaoException{
        if(categoria.getDescricao().trim().isEmpty()){
            throw new ValidacaoException("Informe a descrição!");
        }
        if(categoria.getTipo()==null){
            throw new ValidacaoException("Informe o tipo da categoria!");
        }
    }
}

