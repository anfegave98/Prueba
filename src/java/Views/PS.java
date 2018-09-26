/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juand
 */
public class PS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
//            int company_id=Integer.parseInt(request.getSession().getAttribute("company_id"));
//            AdminDAO a = new AdminDAO("AABGJJMO_BiStock_" + company_id);
            AdminDAO a = new AdminDAO("AABGJJMO_BiStock_" + 1);
            Gson g = new Gson();
            if (op.equalsIgnoreCase("getall")) {
                ArrayList<Admin> admins = a.getAllAdmins();
                String pasareEsto = g.toJson(admins);
                out.print(pasareEsto);

            }
            if (op.equalsIgnoreCase("get")) {
                String email = request.getParameter("pk");
                Admin e = a.getByEmail(email);
                String pasareEsto = g.toJson(e);
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
//            AdminDAO a = new AdminDAO("AABGJJMO_BiStock_" + company_id);
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

                    boolean exito = a.createAdmin(admin);

                    // INCRUSTADO DE ADMIN ROLE STORE S
                    if (exito) {
                        Admin_role_store adrost = new Admin_role_store();
                        adrost.setAdmin_id((a.readAdmin(request.getParameter("email"))).getAdmin_id());
                        Admin_role_storeDAO ars = new Admin_role_storeDAO("AABGJJMO_BiStock_" + 1);
                        adrost.setRole_admin_id(1);
                        adrost.setStore_id(1);
                        out.print(ars.createAdmin_role_store(adrost));
                    } else {
                        out.print(false);
                    }

                } else {
                    out.print(false);
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
}
