
package br.unipar.financeirorest.Controller;

import br.unipar.financeirorest.Exceptions.ValidacaoException;
import br.unipar.financeirorest.Model.Categoria;
import br.unipar.financeirorest.Service.CategoriaService;
import br.unipar.financeirorest.dto.CategoriaRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

@Path("categoria")
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaController {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(CategoriaRequest categoria, @Context HttpServletRequest request) throws SQLException, NamingException, ValidacaoException{
        CategoriaService categoriaService = new CategoriaService();
        Categoria categoriaDomain = categoriaService.insert(Categoria.requestToCategoria(categoria));
        
        return Response.created(URI.create(request.getRequestURI()+"/"+categoriaDomain.getId())).build();
    }
    
    @PUT
    @Path("id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Categoria categoria, @Context HttpServletRequest request) throws SQLException, NamingException, ValidacaoException{
        CategoriaService categoriaService = new CategoriaService();
        Categoria categoriaDomain = categoriaService.update(categoria);
        
        return Response.created(URI.create(request.getRequestURI() + "/" + categoriaDomain.getId())).build();
    }
    
    @DELETE
    @Path("id")
    public Response delete(@PathParam("id") int id, @Context HttpServletRequest request) throws SQLException, SQLException, NamingException, ValidacaoException{
        CategoriaService categoriaService = new CategoriaService();
        categoriaService.delete(id);
        
        return Response.noContent().build();
    }
    
    @GET
    @Path("id")
    public Response findById(@PathParam("id") int id, @Context HttpServletRequest request) throws SQLException, NamingException{
        CategoriaService categoriaService = new CategoriaService();
        Categoria categoria = categoriaService.findById(id);
        
        return Response.ok(categoria).build();
    }
    
    @GET
    public Response findAll(@QueryParam("descricao") String descricao, @Context HttpServletRequest request) throws SQLException, NamingException{
        CategoriaService categoriaService = new CategoriaService();
        List<Categoria> lista = new ArrayList<>();
        lista = categoriaService.findAll();
        
        return Response.ok(lista).build();
    }
}
