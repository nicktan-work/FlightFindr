package ca.sait.flightfindr.filters;

import ca.sait.flightfindr.models.Account;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Ensures user is authenticated.
 * @author Nick Hamnett <nick.hamnett@sait.ca>
 * @version January 25, 2021
 */
public class AuthenticationFilter implements Filter {
    public AuthenticationFilter() {
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    public void init(FilterConfig filterConfig) {
    }
    
    /**
     * Checks user has an associated Account.
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        Account account = (Account) httpRequest.getSession().getAttribute("account");
        
        if (account == null) {
            httpResponse.sendRedirect("/login");
            return;
        }
        
        chain.doFilter(request, response);
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }
}
