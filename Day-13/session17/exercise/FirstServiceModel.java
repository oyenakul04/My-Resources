package my.site.my_site.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import my.site.my_site.core.services.MathematicsOperations;

@Model(adaptables = Resource.class)
public class FirstServiceModel {

	@Inject
	MathematicsOperations mathematicsOperations;

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

	private int sum;

	private int multiplication;

	@PostConstruct
	public void init() {
		sum = mathematicsOperations.additionsOperation(firstNumber, secondNumber);
		multiplication = mathematicsOperations.multiplicationOperation(firstNumber, secondNumber);
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

	public int getSum() {
		return sum;
	}

	public int getMultiplication() {
		return multiplication;
	}

}
