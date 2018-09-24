/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.Asset_storeDAO;
import Dao.Asset_store_reportDAO;
import Dao.State_assetDAO;
import Model.Asset_store;
import Model.Asset_store_report;
import Model.State_asset;
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
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class State_assetS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            Gson g = new Gson();
            Asset_store_reportDAO dao = new Asset_store_reportDAO("AABGJJMO_BiStock_" + 1);
            if (op.equalsIgnoreCase("report")) {
                //            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            AdminDAO a = new AdminDAO("AABGJJMO_BiStock_" + company_id);
                out.print(new Gson().toJson(dao.Generate_asset_store_report(Integer.parseInt(request.getParameter("store_id")))));
            }
            if(op.equalsIgnoreCase("getall")){
                out.print(new Gson().toJson(dao.getItems()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(State_assetS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(State_assetS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(State_assetS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
//            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            State_assetDAO a = new State_assetDAO("AABGJJMO_BiStock_" + company_id);
            State_assetDAO s = new State_assetDAO("AABGJJMO_BiStock_" + 1);

            if (op.equalsIgnoreCase("create")) {
                State_asset state_asset = new State_asset();
                state_asset.setAsset_store_id(Integer.parseInt(request.getParameter("asset_store_id")));
                state_asset.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                state_asset.setDescription(request.getParameter("description"));
                state_asset.setAdmin_id(Integer.parseInt(request.getParameter("admin_id")));
                s.createState_asset(state_asset);

//              int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//              Asset_storeDAO a = new Asset_storeDAO("AABGJJMO_BiStock_" + company_id);
                Asset_storeDAO asset_storedao = new Asset_storeDAO("AABGJJMO_BiStock_" + 1);
                int id_store = asset_storedao.readAsset_store(Integer.parseInt(request.getParameter("asset_store_id"))).getStore_id();

                Asset_store asset_store = asset_storedao.readAsset_store(asset_storedao.readAsset_store(Integer.parseInt(request.getParameter("asset_store_id"))).getAsset_id(), id_store);

                //asset_store.setAvaliable(asset_store.getAvaliable() - state_asset.getQuantity());
                asset_store.setNo_avaliable(asset_store.getNo_avaliable() + state_asset.getQuantity());
                asset_storedao.updateAsset_store(asset_store);
                out.println("ok");
            }
            if (op.equalsIgnoreCase("remove")) {
                State_asset state_asset = s.readState_asset(Integer.parseInt(request.getParameter("state_asset_id")));
                int devolution_quantity = Integer.parseInt(request.getParameter("devolution_quantity"));
                state_asset.setDevolution_quantity(state_asset.getDevolution_quantity() + devolution_quantity);
                if (state_asset.getDevolution_quantity() == state_asset.getQuantity()) {
                    state_asset.setDeleted(true);
                }
                s.updateState_asset(state_asset);
//            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            Asset_storeDAO a = new Asset_storeDAO("AABGJJMO_BiStock_" + company_id);
                Asset_storeDAO asset_storedao = new Asset_storeDAO("AABGJJMO_BiStock_" + 1);
                int id_store = asset_storedao.readAsset_store(Integer.parseInt(request.getParameter("asset_store_id"))).getStore_id();
                Asset_store asset_store = asset_storedao.readAsset_store(asset_storedao.readAsset_store(Integer.parseInt(request.getParameter("asset_store_id"))).getAsset_id(), id_store);
                asset_store.setNo_avaliable(asset_store.getNo_avaliable() - devolution_quantity);
                asset_storedao.updateAsset_store(asset_store);
                out.println("ok");

            }
            
            if(op.equalsIgnoreCase("removeAll")){
                State_asset state_asset = s.readState_asset(Integer.parseInt(request.getParameter("state_asset_id")));
                state_asset.setDevolution_quantity(state_asset.getQuantity());
                state_asset.setDeleted(true);
                s.updateState_asset(state_asset);
                Asset_storeDAO asset_storedao = new Asset_storeDAO("AABGJJMO_BiStock_" + 1);
                int id_store = asset_storedao.readAsset_store(state_asset.getAsset_store_id()).getStore_id();
                Asset_store asset_store = asset_storedao.readAsset_store(asset_storedao.readAsset_store(state_asset.getAsset_store_id()).getAsset_id(), id_store);
                asset_store.setNo_avaliable(asset_store.getNo_avaliable() - state_asset.getDevolution_quantity());
                asset_storedao.updateAsset_store(asset_store);
                out.print(true);
            }

        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(State_assetS.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

}
