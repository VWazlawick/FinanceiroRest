/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.financeirorest.Provider;

import br.unipar.financeirorest.Exceptions.ValidacaoException;
import br.unipar.financeirorest.dto.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Date;

@Provider
public class ValidacaoExceptionProvider implements ExceptionMapper<ValidacaoException>{

    @Context
    private HttpServletRequest request;
    
    @Override
    public Response toResponse(ValidacaoException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), 
                new Date(), request.getRequestURI(), Response.status(Response.Status.BAD_REQUEST).toString());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
    }
    
}
