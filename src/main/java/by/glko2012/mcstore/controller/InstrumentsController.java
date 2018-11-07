package by.glko2012.mcstore.controller;

import by.glko2012.mcstore.dao.InstrumentsDAO;
import by.glko2012.mcstore.dao.factory.DAOFactory;
import by.glko2012.mcstore.model.Instruments;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InstrumentsController", urlPatterns = {"/InstrumentsController"})


public class InstrumentsController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String edit = "WEB-INF/Instrument.jsp";
    private static String insert = "WEB-INF/Instrument.jsp";
    private static String list_instruments = "WEB-INF/listInstrument.jsp";
    private InstrumentsDAO instrumentsDAOImpl;

    public InstrumentsController() {
        super();
        instrumentsDAOImpl = DAOFactory.getInstance().getInstrumentsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int productId = Integer.parseInt(request.getParameter("addressID"));

            instrumentsDAOImpl.removeInstrument(productId);

            forward = list_instruments;
            request.setAttribute("instruments", instrumentsDAOImpl.getInstruments());

        } else if ("edit".equalsIgnoreCase(action)) {
            forward = edit;
            int addressID = Integer.parseInt(request.getParameter("instrumentID"));
            Instruments instrument = instrumentsDAOImpl.getInstrumentById(addressID);
            request.setAttribute("address", instrument);

        } else if ("listInstrument".equalsIgnoreCase(action)) {
            forward = list_instruments;
            request.setAttribute("instruments", instrumentsDAOImpl.getInstruments());

        } else if ("insert".equalsIgnoreCase(action)) {


            forward = insert;
            request.setAttribute("nextIncrement", instrumentsDAOImpl.getNextAi());

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Instruments instruments = new Instruments();
        //addresses.setaddressID(Integer.valueOf(request.getParameter("addressID")));
        instruments.setInst_name(request.getParameter("Inst_name"));
        instruments.setType(request.getParameter("Type"));
        instruments.setManufFK_id(Integer.valueOf(request.getParameter("ManufFK_id")));
        instruments.setSupplFK_id(Integer.valueOf(request.getParameter("SupplFK_id")));
        instruments.setPrice(Integer.valueOf(request.getParameter("Price")));
        String instrumentId = request.getParameter("instrumentID");

        if (instrumentId == null || instrumentId.isEmpty()) {
            instrumentsDAOImpl.addInstrument(instruments);
        } else {
            instruments.setInstrumentID(Integer.parseInt(instrumentId));
            instrumentsDAOImpl.updateInstrument(instruments);
        }

        response.sendRedirect(request.getContextPath() + "AddressesController?action=listAddress");

    }

}
