/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.State_assetDAO;
import Model.State_asset;
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
 * @author super
 */
public class State_assetS extends HttpServlet {

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
            State_assetDAO s = new State_assetDAO("AABGJJMO_BiStock_" + 1);

            if (op.equalsIgnoreCase("create")) {
                State_asset state_asset = new State_asset();
                state_asset.setAsset_store_id(Integer.parseInt(request.getParameter("asset_store_id")));
                state_asset.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                state_asset.setDescription(request.getParameter("description"));
                state_asset.setAdmin_id(Integer.parseInt(request.getParameter("admin_id")));
                out.println(s.createState_asset(state_asset));
                
                
                
                
                

            }

        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(State_assetS.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

}
