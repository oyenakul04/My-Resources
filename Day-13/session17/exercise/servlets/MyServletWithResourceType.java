package my.site.my_site.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.extensions=json",
                "sling.servlet.selectors=mynewservlet",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.resourceTypes=/apps/mysite/components/page" })
public class MyServletWithResourceType extends SlingSafeMethodsServlet {

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
