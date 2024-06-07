/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.financeirorest.dto;

import java.util.Date;

/**
 *
 * @author victo
 */
public class ExceptionResponse {
    private String msg;
    private Date dtException;
    private String path;
    private String httpStatus;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String msg, Date dtException, String path, String httpStatus) {
        this.msg = msg;
        this.dtException = dtException;
        this.path = path;
        this.httpStatus = httpStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDtException() {
        return dtException;
    }

    public void setDtException(Date dtException) {
        this.dtException = dtException;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
    
    
}
