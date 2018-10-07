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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            StoreDAO s = new StoreDAO("AABGJJMO_BiStock_1");
            Gson g = new Gson();
            switch (op) {
                case "get":
                    out.print(new Gson().toJson(s.readStore(request.getParameter("pk"))));
                    break;
                case "getall":
                    out.print(new Gson().toJson(s.readAll()));
                    break;
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(StoreS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            Company company = (Company) request.getSession().getAttribute("company");
            StoreDAO s = new StoreDAO("AABGJJMO_BiStock_" + company.getCompany_id());
            //StoreDAO s = new StoreDAO("AABGJJMO_BiStock_"+1);
            Gson g = new Gson();
            //if (!s.existsOne(company.getCompany_id())) {
            switch (op) {
                case "create":
                    if (!s.exists(request.getParameter("name"))) {
                        Store store = new Store();
                        store.setName(request.getParameter("name"));
                        store.setLend(true);
                        store.setAddress(request.getParameter("address"));
                        store.setPhone_1(request.getParameter("phone_1"));
                        store.setPhone_2(request.getParameter("phone_2"));
                        store.setEmail(request.getParameter("email"));
                        store.setPrincipal(true);
                        out.print(s.createStore(store));
                    }
                    break;
                case "update":
                    Store store = new Store();
                    store.setName(request.getParameter("name"));
                    store.setAddress(request.getParameter("address"));
                    store.setPhone_1(request.getParameter("phone_1"));
                    store.setPhone_2(request.getParameter("phone_2"));
                    store.setEmail(request.getParameter("email"));
                    out.print(s.updateStore(store));
                    break;
                case "delete":
                    String name = request.getParameter("pk");
                    out.print(s.deleteStore(name));
                default:
                    break;
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(StoreS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
