package my.site.my_site.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import my.site.my_site.core.services.MathematicsOperations;

@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=JSON path based servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/pathbasedexample" })
public class PathBasedServlet extends SlingSafeMethodsServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Reference
	private transient MathematicsOperations mathematicsOperations;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		response.setContentType("Application/json");
		response.setCharacterEncoding("UTF-8");

		int sum = mathematicsOperations.additionsOperation(2, 3);
		try {
			response.setStatus(SlingHttpServletResponse.SC_OK);
			response.getWriter().write("value of sum is: " + sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
