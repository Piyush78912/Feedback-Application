package feedback_app.session.manage;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/servlet1")
public class Request1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "Piyush";
        String userid = "1234";

        Cookie cookie = new Cookie("username", username);
        Cookie cookie1 = new Cookie("userid", userid);

        cookie.setMaxAge(10 * 60); // Sets the age of the username cookie to 10 minutes
        cookie1.setMaxAge(5 * 60); // Sets the age of the userid cookie to 5 minutes

        resp.addCookie(cookie); 
        resp.addCookie(cookie1);
        
        //http session:
        HttpSession session = req.getSession();
        session.setAttribute("userSecret", UUID.randomUUID().toString());
        
       
        
        //session.setAttribute("userid", userid);
        session.setMaxInactiveInterval(10*60);
        
        ServletConfig servletConfig = getServletConfig();
        
        ServletContext servletContext = servletConfig.getServletContext();
        
        String appName = servletContext.getInitParameter("app_name");
        String userName = servletConfig.getInitParameter("userName");
        
        
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Cookie set successfully</h1>");
        
        resp.getWriter().print("""
        		<h1>Context Params : %s</h1>
        		<h1>Init Params : %s </h1>
        		""".formatted(appName,userName));
    }
}
