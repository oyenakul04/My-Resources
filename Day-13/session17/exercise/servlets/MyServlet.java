package my.site.my_site.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = Servlet.class, property = {
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/myservlet" })
public class MyServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        response.setContentType("Application/json");
        response.setCharacterEncoding("UTF-8");

        response.setStatus(SlingHttpServletResponse.SC_OK);
        try {
            response.getWriter().write("This servelt is just saying hi to the world");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
