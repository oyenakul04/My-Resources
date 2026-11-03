package my.site.my_site.core.models;

import com.day.cq.wcm.api.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = "mysite/components/mylisting")
@Exporter(name = "jackson", extensions = "json")
public class MyListingModel {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private ResourceResolver resourceResolver;

    @Inject
    @ValueMapValue
    @Optional
    @Named("rootPagePath")
    private String rootPagePath;

    private Page rootPage;

    private List<Page> childPagesList= new ArrayList<>();

    @PostConstruct
    public void init() {
        logger.debug("Root page path selected from component is " + rootPagePath);

        //Business logic to get page object from page path.
        if(StringUtils.isNotBlank(rootPagePath)){
            Resource resource = resourceResolver.getResource(rootPagePath);
            Page rootPage = resource.adaptTo(Page.class);

            Iterator<Page> iterator = rootPage.listChildren();

            while (iterator.hasNext()) {
                Page childPage = iterator.next();
                if (childPage != null) {
                    childPagesList.add(childPage);
                }
            }
        }
    }

    public String getRootPagePath() {
        return rootPagePath;
    }

    public Page getRootPage() {
        return rootPage;
    }

    public List<Page> getChildPagesList() {
        return childPagesList;
    }
}
