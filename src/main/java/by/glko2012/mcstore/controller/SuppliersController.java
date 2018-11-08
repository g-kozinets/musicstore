package by.glko2012.mcstore.controller;


import by.glko2012.mcstore.dao.AddressesDAO;
import by.glko2012.mcstore.dao.ManufacturersDAO;
import by.glko2012.mcstore.dao.SuppliersDAO;
import by.glko2012.mcstore.dao.factory.DAOFactory;
import by.glko2012.mcstore.model.Addresses;
import by.glko2012.mcstore.model.Manufacturers;
import by.glko2012.mcstore.model.Suppliers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SuppliersController", urlPatterns = {"/SuppliersController"})


public class SuppliersController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String edit = "WEB-INF/Suppliers.jsp";
    private static String insert = "WEB-INF/Suppliers.jsp";
    private static String list_address = "WEB-INF/listSupplier.jsp";
    private SuppliersDAO suppliersDAOimpl;

    public SuppliersController() {
        suppliersDAOimpl = DAOFactory.getInstance().getSuppliersDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int suppl_id = Integer.parseInt(request.getParameter("suppl_id"));

            suppliersDAOimpl.removeSupplier(suppl_id);

            forward = list_address;
            request.setAttribute("suppliers", suppliersDAOimpl.getSuppliers());

        } else if ("edit".equalsIgnoreCase(action)) {
            forward = edit;
            int suppl_id = Integer.parseInt(request.getParameter("suppl_id"));
            Suppliers supplier = suppliersDAOimpl.getSupplierById(suppl_id);
            request.setAttribute("suppliers", supplier);

        } else if ("listSupplier".equalsIgnoreCase(action)) {
            forward = list_address;
            request.setAttribute("suppliers", suppliersDAOimpl.getSuppliers());

        } else if ("insert".equalsIgnoreCase(action)) {


            forward = insert;
            //request.setAttribute("nextIncrement", manufacturersDAOImpl.getNextAi());

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Suppliers supplier = new Suppliers();
        //addresses.setaddressID(Integer.valueOf(request.getParameter("addressID")));
        supplier.setSuppl_name(request.getParameter("suppl_name"));
        supplier.setSuppl_location(request.getParameter("suppl_location"));
        supplier.setDelivery_price(Double.valueOf(request.getParameter("delivery_price")));
        String suppl_id = request.getParameter("suppl_id");

        if (suppl_id == null || suppl_id.isEmpty()) {
            suppliersDAOimpl.addSupplier(supplier);
        } else {
            supplier.setSuppl_id(Integer.parseInt(suppl_id));
            suppliersDAOimpl.updateSupplier(supplier);
        }

        response.sendRedirect(request.getContextPath() + "SuppliersController?action=listSupplier");

    }

}
