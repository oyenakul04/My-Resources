package my.site.my_site.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import com.adobe.cq.export.json.ComponentExporter;

@Model(adaptables = { SlingHttpServletRequest.class },
        adapters = { ComponentExporter.class },
        resourceType = { "training/components/structure/pagehero", "training/components/content/hero" },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = { "json" })
public class Hero implements ComponentExporter
{
    protected static final String RESOURCE_TYPE_1 = "training/components/structure/pagehero";
    protected static final String RESOURCE_TYPE_2 = "training/components/content/hero";
    private String style;
    @ValueMapValue(name = "jcr:title")
    private String title;
    @ValueMapValue
    private String heading;
    @ValueMapValue
    private String buttonLabel;
    @ValueMapValue
    private String buttonLinkTo;
    @ValueMapValue
    private String fileReference;
    @Inject
    protected Resource resource;

    @PostConstruct
    private void initModel() {
        String imgPath = this.fileReference;
        if (imgPath == null && this.resource != null) {
            final Resource res = this.resource.getChild("file");
            if (res != null) {
                imgPath = res.getPath();
            }
        }
        if (imgPath != null && !imgPath.isEmpty()) {
            this.style = "background-image:url(" + imgPath + ");";
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getHeading() {
        return this.heading;
    }

    public String getButtonLabel() {
        return this.buttonLabel;
    }

    public String getButtonLinkTo() {
        return this.buttonLinkTo;
    }

    public String getStyle() {
        return this.style;
    }

    public String getExportedType() {
        return this.resource.getResourceType();
    }
}