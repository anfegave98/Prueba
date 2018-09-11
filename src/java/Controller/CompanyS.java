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
 * @author FiJus
 */
public class CompanyS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            CompanyDAO a = new CompanyDAO("BiStock");
            Gson g = new Gson();
            if (op.equalsIgnoreCase("getall")) {
                ArrayList<Company> companys = a.getAllCompanys();
                String pasareEsto = g.toJson(companys);
                out.print(pasareEsto);

            }
            if (op.equalsIgnoreCase("get")) {
                String email = request.getParameter("email");
                Company e = a.getByEmail(email);
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(CompanyS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String op = request.getParameter("op");
            Encription e = new Encription();
            CompanyDAO c = new CompanyDAO("BiStock");
            if (op.equalsIgnoreCase("create")) {
                if (!c.getEmail(request.getParameter("email"))) {
                    Company company = new Company();
                    company.setName(request.getParameter("name"));
                    company.setPrimary_color(request.getParameter("primary_color"));
                    company.setAccent_color(request.getParameter("accent_color"));
                    company.setSector_id(Integer.parseInt(request.getParameter("sector_id")));
                    company.setLogo(request.getParameter("logo"));
                    company.setEmail(request.getParameter("email"));
                    company.setPassword(e.encription(request.getParameter("password")));
                    company.setBasic_color(Boolean.parseBoolean(request.getParameter("basic_color")));
                    company.setCompany_id(c.createCompany(company));
                    String baseDeDatos = "AABGJJMO_BiStock_" + company.getCompany_id();
                    createDatabaseDAO cd = new createDatabaseDAO(baseDeDatos);
                    request.getSession().setAttribute("company", company);
                    out.println(cd.createDatabase("AABGJJMO_BiStock_" + company.getCompany_id()));
                } else {
                    out.println(false);
                }
            }
            if (op.equalsIgnoreCase("deleted")) {
                int company_id = Integer.parseInt(request.getParameter("company_id"));
                c.deleteCompany(company_id);

            }
            if (op.equalsIgnoreCase("update")) {
                String name = request.getParameter("name");
                Company x = c.getByEmail(request.getParameter("email"));
                Company company = new Company();
                company.setCompany_id(Integer.parseInt(request.getParameter("company_id")));
                company.setName(request.getParameter("name"));
                company.setPrimary_color(request.getParameter("primary_color"));
                company.setAccent_color(request.getParameter("accent_color"));
                company.setSector_id(Integer.parseInt(request.getParameter("sector_id")));
                company.setLogo(request.getParameter("logo"));
                company.setBasic_color(Boolean.parseBoolean(request.getParameter("basic_color")));
                if (x.getName().equals(name)) {
                    c.updateCompanyWithoutName(company);
                } else {
                    c.updateCompany(company);
                }
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
