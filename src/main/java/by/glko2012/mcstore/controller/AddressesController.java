package by.glko2012.mcstore.controller;


import by.glko2012.mcstore.dao.AddressesDAO;
import by.glko2012.mcstore.dao.factory.DAOFactory;
import by.glko2012.mcstore.model.Addresses;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddressesController", urlPatterns = {"/AddressesController"})


public class AddressesController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String edit = "WEB-INF/Address.jsp";
    private static String insert = "WEB-INF/AddressInsert.jsp";
    private static String list_address = "WEB-INF/listAddress.jsp";
    private AddressesDAO addressesDAOImpl;

    public AddressesController() {
       // super();
        addressesDAOImpl = DAOFactory.getInstance().getAddressesDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int productId = Integer.parseInt(request.getParameter("addressID"));

            addressesDAOImpl.removeAddress(productId);

            forward = list_address;
            request.setAttribute("addresses", addressesDAOImpl.getAddresses());

        } else if ("edit".equalsIgnoreCase(action)) {
           forward = edit;
            int addressID = Integer.parseInt(request.getParameter("addressID"));
            Addresses address = addressesDAOImpl.getAddressById(addressID);
            request.setAttribute("address", address);

        } else if ("listAddress".equalsIgnoreCase(action)) {
            forward = list_address;
            request.setAttribute("addresses", addressesDAOImpl.getAddresses());

        } else if ("insert".equalsIgnoreCase(action)) {


           forward = insert;
           request.setAttribute("nextIncrement", addressesDAOImpl.getNextAi());

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Addresses addresses = new Addresses();
       //addresses.setaddressID(Integer.valueOf(request.getParameter("addressID")));
        addresses.setstreet_name(request.getParameter("street_name"));
        addresses.setstreet_number(request.getParameter("street_number"));
        String addressId = request.getParameter("addressID");

        if (addressId == null || addressId.isEmpty()) {
            addressesDAOImpl.addAddress(addresses);
        } else {
            addresses.setaddressID(Integer.parseInt(addressId));
            addressesDAOImpl.updateAddress(addresses);
        }

        response.sendRedirect(request.getContextPath() + "AddressesController?action=listAddress");

    }

}
