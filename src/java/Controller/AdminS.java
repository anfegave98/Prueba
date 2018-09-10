/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AdminDAO;
import Model.Admin;
import Util.Encription;
import Util.createDatabaseDAO;
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
public class AdminS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminS at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            AdminDAO a = new AdminDAO("AABGJJMO_BiStock_" + 1);
            Gson g = new Gson();
            if (op.equalsIgnoreCase("getall")) {
                ArrayList<Admin> admins = a.getAllAdmins();
                String pasareEsto = g.toJson(admins);
                out.print(pasareEsto);

            }
            if (op.equalsIgnoreCase("get")) {
                String email = request.getParameter("email");
                Admin e = a.getByEmail(email);
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(AdminS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            AdminDAO a = new AdminDAO("AABGJJMO_BiStock_" + 1);
            Encription e = new Encription();
            Gson g = new Gson();
            if (op.equalsIgnoreCase("create")) {
                if (!a.getEmail(request.getParameter("email"))) {
                    Admin admin = new Admin();
                    admin.setPassword(e.encription(request.getParameter("password")));
                    admin.setEmail(request.getParameter("email"));
                    admin.setName(request.getParameter("name"));
                    admin.setLast_name(request.getParameter("last_name"));
                    out.println(a.createAdmin(admin));
                } else {
                    out.println("Email ya existente");
                }
            }
            if (op.equalsIgnoreCase("deleted")) {
                String email = request.getParameter("email");
                a.deleteAdmin(email);

            }
            if (op.equalsIgnoreCase("update")) {
                Admin admin = new Admin();
                admin.setEmail(request.getParameter("email"));
                admin.setName(request.getParameter("name"));
                admin.setLast_name(request.getParameter("last_name"));
                a.updateAdmin(admin);

            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(AdminS.class.getName()).log(Level.SEVERE, null, ex);
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