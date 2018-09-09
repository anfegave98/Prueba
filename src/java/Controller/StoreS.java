/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.StoreDAO;
import Model.Company;
import Model.Store;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FiJus
 */
public class StoreS extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            //Company company = (Company) request.getSession().getAttribute("company");
            //StoreDAO s = new StoreDAO("AABGJJMO_BiStock_" + company.getCompany_id());
            StoreDAO s = new StoreDAO("AABGJJMO_BiStock_"+1);
            Gson g = new Gson();
            //if (!s.existsOne(company.getCompany_id())) {
            if (!s.existsOne()) {
                if (op.equalsIgnoreCase("create")) {
                    Store store=new Store();
                    store.setName(request.getParameter("name"));
                    store.setSell(false);
                    store.setLend(true);
                    store.setRental(false);
                    store.setAddress(request.getParameter("address"));
                    store.setPhone_1(request.getParameter("phone_1"));
                    store.setPhone_2(request.getParameter("phone_2"));
                    store.setEmail(request.getParameter("email"));
                    store.setPrincipal(true);
                    out.println(s.createStore(store));
                }
            }else{
                out.println("Ya existe tienda principal");
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(StoreS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
