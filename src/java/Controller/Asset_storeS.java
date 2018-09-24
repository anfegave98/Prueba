/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AssetDAO;
import Dao.Asset_storeDAO;
import Model.Asset_store;
import Util.Asset_available_report;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
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
 * @author FiJus
 */
public class Asset_storeS extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            //            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            Asset_storeDAO a = new Asset_storeDAO("AABGJJMO_BiStock_" + company_id);
            Asset_storeDAO a = new Asset_storeDAO("AABGJJMO_BiStock_" + 1);
            AssetDAO as = new AssetDAO("AABGJJMO_BiStock_" + 1);
            Gson g = new Gson();
            System.out.println("hola perrras");
            if (op.equalsIgnoreCase("getById")) {
                int asset_id = Integer.parseInt(request.getParameter("asset_id"));
                out.print(g.toJson(as.getOneAvailable(asset_id)));
            }
            if (op.equalsIgnoreCase("getByCodebar")) {
                out.print(g.toJson(as.getOneAvailable(request.getParameter("codebar"))));
            }
            if (op.equalsIgnoreCase("getall")) {
                ArrayList<Asset_available_report> assets = as.getAllAvailable();
                String pasareEsto = g.toJson(assets);
                out.print(pasareEsto);

            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(AdminS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
