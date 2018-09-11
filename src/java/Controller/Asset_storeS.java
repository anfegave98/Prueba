/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Asset_storeDAO;
import Model.Asset_store;
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
public class Asset_store_storeS extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            //            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            Asset_storeDAO a = new Asset_storeDAO("AABGJJMO_BiStock_" + company_id);
            Asset_storeDAO a = new Asset_storeDAO("AABGJJMO_BiStock_" + 1);
            Gson g = new Gson();
            if (op.equalsIgnoreCase("getall")) {
                ArrayList<Asset_store> assets = a.getAllAsset_store();
                String pasareEsto = g.toJson(assets);
                out.print(pasareEsto);

            }
            if (op.equalsIgnoreCase("getById")) {
                int asset_id = Integer.parseInt(request.getParameter("asset_id"));
                Asset_store e = a.readAsset_store(asset_id);
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
            if (op.equalsIgnoreCase("getByCodebar")) {
                String codebar = request.getParameter("asset_id");
                Asset_store e = a.readAsset_storeByCodebar(codebar);
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(AdminS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Asset_store_storeS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Asset_store_storeS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
