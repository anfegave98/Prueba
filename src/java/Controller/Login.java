/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AdminDAO;
import Dao.ClientDAO;
import Dao.CompanyDAO;
import Util.Encription;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
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
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Encription e = new Encription();
            String op = request.getParameter("op");
            if (op.equalsIgnoreCase("in")) {
                //int company_id = Integer.parseInt(request.getParameter("company_id"));
                String email = request.getParameter("email");
                String password = e.encription(request.getParameter("password"));
                CompanyDAO c = new CompanyDAO("BiStock");
                if (c.is(email, password)) {
                    request.getSession().setAttribute("company", c.readCompany(email));
                    out.println("Company");
                } else {
                    AdminDAO a = new AdminDAO("AABGJJMO_BiStock_" + 1);
//                AdminDAO a = new AdminDAO("AABGJJMO_BiStock_"+company_id);
                    if (a.is(email, password)) {
                        request.getSession().setAttribute("admin", a.readAdmin(email));
                        out.println("Admin");
                    } else {
                        ClientDAO cl = new ClientDAO("AABGJJMO_BiStock_" + 1);
//                    ClientDAO cl = new ClientDAO("AABGJJMO_BiStock_" + company_id);
                        if (cl.is(email, password)) {
                            request.getSession().setAttribute("client", cl.readClient(email));
                            out.println("Client");
                        } else {
                            out.println(false);
                        }
                    }
                }
            }
            if(op.equalsIgnoreCase("out")){
                request.getSession().setAttribute("company", null);
                request.getSession().setAttribute("admin", null);
                request.getSession().setAttribute("client", null);        
            }
        } catch (NoSuchAlgorithmException | SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
