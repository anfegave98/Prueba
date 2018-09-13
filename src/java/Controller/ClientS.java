/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ClientDAO;
import Model.Client;
import Util.Encription;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anfeg
 */
public class ClientS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            //            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            ClientDAO a = new ClientDAO("AABGJJMO_BiStock_" + company_id);
            ClientDAO a = new ClientDAO("AABGJJMO_BiStock_" + 1);
            Gson g = new Gson();
            if (op.equalsIgnoreCase("getall")) {
                ArrayList<Client> clients = a.getAll();
                String pasareEsto = g.toJson(clients);
                out.print(pasareEsto);
            }
            if (op.equalsIgnoreCase("get")) {
                String email = request.getParameter("email");
                Client e = a.getByEmail(email);
                if (e == null) {
                    out.print(false);
                } else {
                    String pasareEsto = g.toJson(e);
                    out.print(pasareEsto);
                }
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            //            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            ClientDAO a = new ClientDAO("AABGJJMO_BiStock_" + company_id);
            ClientDAO a = new ClientDAO("AABGJJMO_BiStock_" + 1);
            Encription e = new Encription();
            System.out.println(op+"-----------" + request.getParameter("email"));
            if (op.equalsIgnoreCase("create")) {
                if (!a.getEmail(request.getParameter("email"))) {
                    Client client = new Client();
                    client.setPassword(e.encription(request.getParameter("password")));
                    client.setEmail(request.getParameter("email"));
                    client.setName(request.getParameter("name"));
                    client.setLast_name(request.getParameter("last_name"));
                    out.print(a.createClient(client));
                } else {
                    out.print("Email ya existente");
                }
            }
            if (op.equalsIgnoreCase("deleted")) {
                String email = request.getParameter("email");
                a.deleteClient(email);

            }
            if (op.equalsIgnoreCase("update")) {
                Client client = new Client();
                client.setEmail(request.getParameter("email"));
                client.setName(request.getParameter("name"));
                client.setLast_name(request.getParameter("last_name"));
                a.updateClient(client);

            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(ClientS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
