/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AssetDAO;
import Dao.Asset_storeDAO;
import Model.Asset;
import Model.Asset_store;
import Util.Asset_available_report;
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
public class AssetS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            //            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            AssetDAO a = new AssetDAO("AABGJJMO_BiStock_" + company_id);
            AssetDAO a = new AssetDAO("AABGJJMO_BiStock_" + 1);
            Gson g = new Gson();
            if (op.equalsIgnoreCase("get")) {
                ArrayList<Asset> assets = a.getAllAsset();
                String pasareEsto = g.toJson(assets);
                out.print(pasareEsto);

            }
            if (op.equalsIgnoreCase("getById")) {
                int asset_id = Integer.parseInt(request.getParameter("asset_id"));
                Asset e = a.readAsset(asset_id);
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
            if (op.equalsIgnoreCase("getByCodebar")) {
                String codebar = request.getParameter("asset_id");
                Asset e = a.readAssetByCodebar(codebar);
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
            if (op.equalsIgnoreCase("getall")) {
                ArrayList<Asset_available_report> assets = a.getAllAvailable();
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            //            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            AssetDAO a = new AssetDAO("AABGJJMO_BiStock_" + company_id);
            AssetDAO a = new AssetDAO("AABGJJMO_BiStock_" + 1);
            if (op.equalsIgnoreCase("create")) {
                if (!a.getCodebar(request.getParameter("codebar"))) {
                    Asset asset = new Asset();
                    if (request.getParameter("asset_parent_id").equals("")) {
                        asset.setAsset_parent_id(0);
                        asset.setName(request.getParameter("name"));
                        asset.setCodebar(request.getParameter("codebar"));
                        asset.setPrincipal_picture(request.getParameter("principal_picture"));
                        asset.setDescription(request.getParameter("description"));
                        out.println(a.createAsset(asset));
                    } else {
                        asset.setAsset_parent_id(Integer.parseInt(request.getParameter("asset_parent_id")));
                        asset.setName(request.getParameter("name"));
                        asset.setCodebar(request.getParameter("codebar"));
                        asset.setPrincipal_picture(request.getParameter("principal_picture"));
                        asset.setDescription(request.getParameter("description"));
                        out.println(a.createAsset(asset));
                    }
                    Asset_store as=new Asset_store();
                    as.setAsset_id(a.readAssetByCodebar(request.getParameter("codebar")).getAsset_id());
                    as.setAvaliable(Integer.parseInt(request.getParameter("available")));
                    as.setStore_id(Integer.parseInt(request.getParameter("store_id")));
                    //            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            Asset_storeDAO a = new Asset_storeDAO("AABGJJMO_BiStock_" + company_id);
                    Asset_storeDAO asset_store=new Asset_storeDAO("AABGJJMO_BiStock_" + 1);
                    asset_store.createAsset_store(as);
                } else {
                    out.println("Asset ya existe");
                }
            }
            if (op.equalsIgnoreCase("deleted")) {
                String codebar = request.getParameter("codebar");
                a.deleteAsset(codebar);
                
            }
            if (op.equalsIgnoreCase("update")) {
                String codebar = request.getParameter("codebar");
                Asset x =a.readAssetByCodebar(codebar);
                if (x.getCodebar().equals(codebar)) {
                    out.println("Codebar ya existente");
                } else {              
                    Asset asset = new Asset();
                    asset.setAsset_id(Integer.parseInt(request.getParameter("asset_id")));
                    asset.setAsset_parent_id(Integer.parseInt(request.getParameter("asset_parent_id")));
                    asset.setName(request.getParameter("name"));
                    asset.setCodebar(request.getParameter("codebar"));
                    asset.setPrincipal_picture(request.getParameter("principal_picture"));
                    asset.setDescription(request.getParameter("description"));
                    a.updateAsset(asset); 
                    
                }
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(AssetS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
