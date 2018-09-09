/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AssetDAO;
import Model.Asset;
import Util.Encription;
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
 * @author anfeg
 */
public class AssetS extends HttpServlet {

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
            out.println("<title>Servlet AssetS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AssetS at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
            AssetDAO a = new AssetDAO("AABGJJMO_BiStock_" + 1);
            Encription e = new Encription();
            if (op.equalsIgnoreCase("create")) {
                if (!a.getName(request.getParameter("name"))) {
                    Asset asset = new Asset();
                    if (request.getParameter("asset_parent_id") == "") {
                        asset.setAsset_parent_id(0);
                        asset.setName(request.getParameter("name"));
                        asset.setPrincipal_picture(request.getParameter("principal_picture"));
                        asset.setDescription(request.getParameter("description"));
                        out.println(a.createAsset(asset));
                    } else {
                        asset.setAsset_parent_id(Integer.parseInt(request.getParameter("asset_parent_id")));
                        asset.setName(request.getParameter("name"));
                        asset.setPrincipal_picture(request.getParameter("principal_picture"));
                        asset.setDescription(request.getParameter("description"));
                        out.println(a.createAsset(asset));
                    }
                } else {
                    out.println("Asset ya existe");
                }
            }
            if (op.equalsIgnoreCase("")) {

            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(AssetS.class.getName()).log(Level.SEVERE, null, ex);
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

