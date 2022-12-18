/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compraventacliente;

import java.util.Scanner;

/**
 *
 * @author silkn
 */
public class CompraVentaCliente {
    
    
    public static void main(String[] args) {
        int id_producto,precio,noprod,total;
        Scanner read = new Scanner(System.in);
        System.out.println("Inserte el ID del producto: ");
        id_producto=read.nextInt();
        System.out.println("Inserte el precio del producto ");
        precio=read.nextInt();
        System.out.println("Inserte el numero de producto ");
        noprod=read.nextInt();
        total=precio*noprod;
        System.out.println("El total del producto es: "+total);
        if(comprar(id_producto,precio,noprod,total)==true){
        int notarjeta;
        String nombre,codigoCVV;
        System.out.println("Proceso de pago");
        Scanner read2 = new Scanner(System.in);
        System.out.println("Inserte su numero de tarjeta: ");
        notarjeta=read2.nextInt();
        System.out.println("Inserte el nombre de la tarjeta: ");
        nombre=read2.next();
        System.out.println("Inserte el codigo CVV de la tarjeta: ");
        codigoCVV=read2.next();
        if(pagar(notarjeta,total,nombre,codigoCVV)==true){
        System.out.println("TRANSACCION EXITOSA");
        }else{
        System.out.println("TRANSACCION FALLIDA");
        }
        }else{
        System.out.println("TRANSACCION FALLIDA");
        }


    }
    private static boolean pagar(int numero_tarjeta, int monto, java.lang.String nombre, java.lang.String codigo_CVV) {
        org.me.compraventa.CompraVenta_Service service = new org.me.compraventa.CompraVenta_Service();
        org.me.compraventa.CompraVenta port = service.getCompraVentaPort();
        return port.pagar(numero_tarjeta, monto, nombre, codigo_CVV);
    }

    private static Boolean comprar(int id_producto, int precio, int numero_productos, int total) {
        org.me.compraventa.CompraVenta_Service service = new org.me.compraventa.CompraVenta_Service();
        org.me.compraventa.CompraVenta port = service.getCompraVentaPort();
        return port.comprar(id_producto, precio, numero_productos, total);
    }
    
}
