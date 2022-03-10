package ca.sait.flightfindr.servlets;

import ca.sait.flightfindr.models.Account;
import ca.sait.flightfindr.models.Flight;
import ca.sait.flightfindr.dataaccess.FlightService;
import ca.sait.flightfindr.dataaccess.BookingService;
import java.io.IOException;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Handles booking requests.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @version January 25, 2021
 */
public class BookingServlet extends HttpServlet {

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
        request.setAttribute("account", request.getParameter("account"));
        request.setAttribute("code", request.getParameter("code"));
        
        request.getRequestDispatcher("/WEB-INF/booking.jsp").forward(request, response);
    }

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
        if (request.getParameter("code") != null) {
            try {
                FlightService flightService = new FlightService();
                BookingService bookingService = new BookingService();
                
                Account account = (Account) request.getSession().getAttribute("account");
                Flight flight = flightService.getByCode(request.getParameter("code"));
                
                if (flight != null) {
                    bookingService.createBooking(account, flight);
                    
                    String lastFourDigits = account.getCreditCard().substring(account.getCreditCard().length() - 4);
                    String costFormatted = String.format("$%.2f", flight.getCost());

                    request.setAttribute("lastFourDigits", lastFourDigits);
                    request.setAttribute("cost", costFormatted);
                } else {
                    throw new Exception("Flight code is invalid.");
                }
                
            } catch (Exception ex) {
                request.setAttribute("error", ex.getMessage());
                Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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

}
