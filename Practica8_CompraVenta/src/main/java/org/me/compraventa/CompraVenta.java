/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.compraventa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author silkn
 */
@WebService(serviceName = "CompraVenta")
public class CompraVenta {



    /**
     * Web service operation
     */
    @WebMethod(operationName = "pagar")
    public Boolean pagar(@WebParam(name = "numero_tarjeta") int numero_tarjeta, @WebParam(name = "monto") int monto, @WebParam(name = "nombre") String nombre, @WebParam(name = "codigo_CVV") String codigo_CVV) {
        String regex = "^[0-9]{3,4}";
        Pattern p=Pattern.compile(regex);
        
       
        //Verificamos los datos 
        if(monto>10000){
            System.out.println("Monto supera el limite de tarjeta");
        return false;
        } else if(codigo_CVV==null){
        System.out.println("Introduzca CVV valido");
            return false;
        }else{
        Matcher m = p.matcher(codigo_CVV);
        return m.matches();
        
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "comprar")
    public Boolean comprar(@WebParam(name = "id_producto") int id_producto, @WebParam(name = "precio") int precio, @WebParam(name = "numero_productos") int numero_productos, @WebParam(name = "total") int total) {
        
        return true;
    }
}
