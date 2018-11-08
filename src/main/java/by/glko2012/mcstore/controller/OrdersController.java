package by.glko2012.mcstore.controller;


import by.glko2012.mcstore.dao.AddressesDAO;
import by.glko2012.mcstore.dao.OrdersDAO;
import by.glko2012.mcstore.dao.factory.DAOFactory;
import by.glko2012.mcstore.model.Addresses;
import by.glko2012.mcstore.model.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrdersController", urlPatterns = {"/OrdersController"})


public class OrdersController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String edit = "WEB-INF/Orders.jsp";
    private static String insert = "WEB-INF/Orders.jsp";
    private static String list_address = "WEB-INF/listOrders.jsp";
    private OrdersDAO ordersDAOimpl;

    public OrdersController() {
        ordersDAOimpl = DAOFactory.getInstance().getOrdersDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int order_id = Integer.parseInt(request.getParameter("order_id"));

            ordersDAOimpl.removeOrder(order_id);

            forward = list_address;
            request.setAttribute("orders", ordersDAOimpl.getOrders());

        } else if ("edit".equalsIgnoreCase(action)) {
            forward = edit;
            int order_id = Integer.parseInt(request.getParameter("order_id"));
            Orders order = ordersDAOimpl.getOrderById(order_id);
            request.setAttribute("order", order);

        } else if ("listOrder".equalsIgnoreCase(action)) {
            forward = list_address;
            request.setAttribute("orders", ordersDAOimpl.getOrders());

        } else if ("insert".equalsIgnoreCase(action)) {


            forward = insert;
            //request.setAttribute("nextIncrement", ordersDAOimpl.getNextAi());

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Orders orders = new Orders();
        //addresses.setaddressID(Integer.valueOf(request.getParameter("addressID")));
        orders.setOrder_name(request.getParameter("order_name"));
        orders.setInstrFK_id(Integer.valueOf(request.getParameter("instrFK_id")));
        orders.setAddressFK_id(Integer.valueOf(request.getParameter("addressFK_id")));
        orders.setTotal_price(Double.valueOf(request.getParameter("total_price")));
        String order_id = request.getParameter("order_id");

        if (order_id == null || order_id.isEmpty()) {
            ordersDAOimpl.addOrder(orders);
        } else {
            orders.setOrder_id(Integer.parseInt(order_id));
            ordersDAOimpl.updateOrder(orders);
        }

        response.sendRedirect(request.getContextPath() + "OrdersController?action=listOrder");

    }

}
