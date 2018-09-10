/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ClientDAO;
import Dao.LendDAO;
import Dao.Lend_itemsDAO;
import Model.Company;
import Model.Lend;
import Model.Lend_items;
import Util.queryLend;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/**
 *
 * @author FiJus
 */
public class LendS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            //Company company = (Company) request.getSession().getAttribute("company");
            //StoreDAO s = new StoreDAO("AABGJJMO_BiStock_" + company.getCompany_id());
            LendDAO ld = new LendDAO("AABGJJMO_BiStock_" + 1);
            Gson g = new Gson();
            if (op.equalsIgnoreCase("create")) {
                Lend l = new Lend();
                l.setAdmin_role_store_id(Integer.parseInt(request.getParameter("admin_role_store_id")));
                l.setClient_id(Integer.parseInt(request.getParameter("client_id")));
                //Date d=(Date) request.getParameter("devolution_date");
                int mayor = ld.createLend(l);
                if (mayor != 0) {
                    Lend_itemsDAO ldi = new Lend_itemsDAO("AABGJJMO_BiStock_" + 1);
                    String lend_items = request.getParameter("lend_items");
                    System.out.println(lend_items);
                    List<queryLend> list_items = new Gson().fromJson(lend_items, new TypeToken<List<queryLend>>() {}.getType());
                    for(queryLend q: list_items){
                        Lend_items item=new Lend_items();
                        item.setLend_id(mayor);
                        item.setAsset_store_id(q.getAsset_store_id());
                        item.setLend_quantity(q.getLend_quantity());
                        ldi.createLend_items(item);
                    }
                    out.println("I did it");
                }
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(LendS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
