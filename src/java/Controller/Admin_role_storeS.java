/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AdminDAO;
import Dao.Admin_role_storeDAO;
import Model.Admin;
import Model.Admin_role_store;
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
public class Admin_role_storeS extends HttpServlet {

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
            if (op.equalsIgnoreCase("assign")) {
                AdminDAO a = new AdminDAO("AABGJJMO_BiStock_" + 1);
                Admin_role_store adrost = new Admin_role_store();
                if (!a.getEmail(request.getParameter("email"))) {
                    out.println(false);
                } else {
                    adrost.setAdmin_id((a.readAdmin(request.getParameter("email"))).getAdmin_id());
                    Admin_role_storeDAO ars = new Admin_role_storeDAO("AABGJJMO_BiStock_" + 1);
                    adrost.setRole_admin_id(Integer.parseInt(request.getParameter("role_admin_id")));
                    adrost.setStore_id(Integer.parseInt(request.getParameter("store_id")));
                    out.println(ars.createAdmin_role_store(adrost));
                }
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(Admin_role_storeS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
