package by.glko2012.mcstore.controller;


import by.glko2012.mcstore.dao.ManufacturersDAO;
import by.glko2012.mcstore.dao.factory.DAOFactory;
import by.glko2012.mcstore.model.Manufacturers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManufacturersController", urlPatterns = {"/ManufacturersController"})


public class ManufacturersController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String edit = "WEB-INF/Manufacturers.jsp";
    private static String insert = "WEB-INF/Manufacturers.jsp";
    private static String list_address = "WEB-INF/listManufacture.jsp";
    private ManufacturersDAO manufacturersDAOImpl;

    public ManufacturersController() {
        manufacturersDAOImpl = DAOFactory.getInstance().getManufacturersDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int manuf_id = Integer.parseInt(request.getParameter("manuf_id"));

            manufacturersDAOImpl.removeManufacture(manuf_id);

            forward = list_address;
            request.setAttribute("manufacturers", manufacturersDAOImpl.getManufacturers());

        } else if ("edit".equalsIgnoreCase(action)) {
            forward = edit;
            int manuf_id = Integer.parseInt(request.getParameter("manuf_id"));
            Manufacturers manufacture = manufacturersDAOImpl.getManufactureById(manuf_id);
            request.setAttribute("manufacture", manufacture);

        } else if ("listManufacture".equalsIgnoreCase(action)) {
            forward = list_address;
            request.setAttribute("manufacturers", manufacturersDAOImpl.getManufacturers());

        } else if ("insert".equalsIgnoreCase(action)) {


            forward = insert;
            //request.setAttribute("nextIncrement", manufacturersDAOImpl.getNextAi());

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Manufacturers manufacturers = new Manufacturers();
        //addresses.setaddressID(Integer.valueOf(request.getParameter("addressID")));
        manufacturers.setName(request.getParameter("name"));
        manufacturers.setLocation(request.getParameter("location"));
        String addressId = request.getParameter("manuf_id");

        if (addressId == null || addressId.isEmpty()) {
            manufacturersDAOImpl.addManufacture(manufacturers);
        } else {
            manufacturers.setManuf_id(Integer.parseInt(addressId));
            manufacturersDAOImpl.updateManufacture(manufacturers);
        }

        response.sendRedirect(request.getContextPath() + "ManufacturersController?action=listAddress");

    }

}
