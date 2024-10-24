/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.HoaDAO;
import dao.LoaiDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ManageProduct", urlPatterns = {"/ManageProduct"})
public class ManageProduct extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HoaDAO hoaDAO = new HoaDAO();
        LoaiDAO loaiDAO = new LoaiDAO();

        String action = "LIST";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }

        //xét các trường hợp của các chức năng
        switch (action) {
            case "LIST":
                //trả về giao diện liệt kê danh sách sản phẩm quản trị
                //System.out.println("LIST");
                request.setAttribute("dsHoa", hoaDAO.getAll()); //Chuyển dữ liệu cho JSP (VIEW)
                request.getRequestDispatcher("Admin/list_product.jsp").forward(request, response);
                break;

            case "ADD":
                //trả về giao diện thêm mới sản phảm
                request.setAttribute("dsLoai", loaiDAO.getAll()); //Chuyển dữ liệu cho JSP (VIEW)
                request.getRequestDispatcher("Admin/add_product.jsp").forward(request, response);
                break;

            case "EDIT":
                //trả về giao diện cập nhật sản phảm
                //System.out.println("EDIT");
                request.getRequestDispatcher("Admin/edit_product.jsp").forward(request, response);

                break;

            case "DELETE":
                //Xử lý xoá sản phẩm
                //System.out.println("DELETE");
                request.getRequestDispatcher("Admin/edit_product.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
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
        processRequest(request, response);
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
