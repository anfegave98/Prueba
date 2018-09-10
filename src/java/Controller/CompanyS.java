/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.CompanyDAO;
import Model.Company;
import Util.Encription;
import Util.createDatabaseDAO;
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
public class CompanyS extends HttpServlet {

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
            if (op.equalsIgnoreCase("create")){
                CompanyDAO c = new CompanyDAO("BiStock");
                if (!c.getEmail(request.getParameter("email"))) {
                    Company company = new Company();
                    company.setName(request.getParameter("name"));
                    company.setPrimary_color(request.getParameter("primary_color"));
                    company.setAccent_color(request.getParameter("accent_color"));
                    company.setSector_id(Integer.parseInt(request.getParameter("sector_id")));
                    company.setLogo(request.getParameter("logo"));
                    company.setEmail(request.getParameter("email"));
                    Encription e = new Encription();
                    company.setPassword(e.encription(request.getParameter("password")));
                    company.setBasic_color(Boolean.parseBoolean(request.getParameter("basic_color")));
                    company.setCompany_id(c.createCompany(company));
                    String baseDeDatos="AABGJJMO_BiStock_"+company.getCompany_id();
                    createDatabaseDAO cd=new createDatabaseDAO(baseDeDatos);
                    request.getSession().setAttribute("company", company);
                    out.println(cd.createDatabase("AABGJJMO_BiStock_"+company.getCompany_id()));
                }else{
                    out.println(false);
                }
            }
            if(op.equalsIgnoreCase("")){
                
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Company.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(CompanyS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
