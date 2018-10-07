/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Util.Attribute;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author green
 */
public class AttributesS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            ArrayList<Attribute> atributos = new ArrayList<>();
            switch (op) {
                case "getClient":
                    atributos.add(new Attribute("Nombres de cliente", "name", "textocorto", "Texto de ayuda para el parámetro", true, false, true));
                    atributos.add(new Attribute("Apellidos de cliente", "last_name", "textocorto", "Texto de ayuda para el parámetro", true, false, true));
                    atributos.add(new Attribute("Email de cliente", "email", "email", "Texto de ayuda para el parámetro", true, true, true));
                    atributos.add(new Attribute("Contraseña de cliente", "password", "password", "Texto de ayuda para el parámetro", true, false, false));
                    break;
                case "getAdmin":
                    atributos.add(new Attribute("Nombres", "name", "textocorto", "Texto de ayuda para el nombre", true, false, true));
                    atributos.add(new Attribute("Apellidos", "last_name", "textocorto", "Texto de ayuda para el apellido", true, false, true));
                    atributos.add(new Attribute("Email", "email", "email", "Texto de ayuda para el email", true, true, true));
                    atributos.add(new Attribute("Contraseña", "password", "password", "Texto de ayuda para la contraseña", true, false, false));
                    break;
                case "getAsset":
                    // atributos.add(new Attribute("ID", "asset_id", "textocorto", "Nombre del activo", true, true, true));
                    atributos.add(new Attribute("Name", "name", "textocorto", "Nombre del activo", true, false, true));
                    atributos.add(new Attribute("Codebar", "codebar", "textocorto", "Codigo de barras", true, true, true));
                    atributos.add(new Attribute("Imagen Principal", "principal_picture", "foto", "Foto Principal", true, false, true));
                    atributos.add(new Attribute("Descripcion", "description", "textolargo", "Descripcion del activo", true, false, true));
                    atributos.add(new Attribute("Disponible", "available", "entero", "Cuántos hay en la tienda", true, false, false));
                    //atributos.add(new Attribute("Disponibles", "available", "entero", "Cantidad de activo disponible", true, false, true));
                    break;
                case "getStore":
                    atributos.add(new Attribute("Nombre","name","textocorto","Nombre de la tienda",true,true,true));
                    atributos.add(new Attribute("Prestamo","lend","checkbox","Su tienda realiza prestamos?", true, false, true));
                    atributos.add(new Attribute("Direccion","address","textocorto","Direccion de la tienda", true, false, true));
                    atributos.add(new Attribute("Telefono 1","phone_1","textocorto","Telefono de la tienda", true, false, true));
                    atributos.add(new Attribute("Telefono 2","phone_2","textocorto","Telefono opcional de la tienda", true, false, true));
                    atributos.add(new Attribute("Correo","email","textocorto","Email de la tienda", true, false, true));
                    atributos.add(new Attribute("Principal","principal","checkbox","Direccion de la tienda", true, false, true));
                    
                default:
                    break;
            }
            out.print(new Gson().toJson(atributos));

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
