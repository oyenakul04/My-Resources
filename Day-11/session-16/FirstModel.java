package my.site.my_site.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = Resource.class)
public class FirstModel {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	@ValueMapValue
	@Optional
	@Named("firstNumber")
	private int firstNumber;

	@Inject
	@ValueMapValue
	@Optional
	@Named("secondNumber")
	private int secondNumber;

	private boolean isTouch;

	@PostConstruct
	public void init() {
		//Business logic or any other initialization will come here
	}

	public int getFirstNumber() {
		return firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public boolean isTouch() {
		return isTouch;
	}

}
