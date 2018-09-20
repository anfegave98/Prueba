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
            ArrayList<Attribute> atributos= new ArrayList<>();
            switch(op){
                case "getClient":
                    atributos.add(new Attribute("Email", "email","textocorto", "Correo electronico", true, true, true));
                    atributos.add(new Attribute("Name", "name","textocorto", "nombre de pila", true, false, true));
                    atributos.add(new Attribute("Last name", "last_name","textocorto", "apellido", true, false, true));
                    break;
                case "getAdmin":
                    atributos.add(new Attribute("Email", "email","textocorto", "Correo electronico", true, true, true));
                    atributos.add(new Attribute("Name", "name","textocorto", "nombre de pila", true, false, true));
                    atributos.add(new Attribute("Last name", "last_name","textocorto", "apellido", true, false, true));
                    break;
                case "getAsset":
                    atributos.add(new Attribute("Name", "name","textocorto", "Nombre del activo", true, true, true));
                    atributos.add(new Attribute("Codebar", "codebar","textocorto", "Codigo de barras", true, false, true));
                    atributos.add(new Attribute("Imagen Principal", "principal_picture","foto", "Foto Principal", true, false, true));
                    atributos.add(new Attribute("Descripcion", "description","textolargo", "Descripcion del activo", true, false, true));
                    atributos.add(new Attribute("Disponibles", "available","entero", "Cantidad de activo disponible", true, false, true));
                    break;
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
