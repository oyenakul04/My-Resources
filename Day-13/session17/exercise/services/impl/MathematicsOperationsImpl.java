package my.site.my_site.core.services.impl;

import org.osgi.service.component.annotations.Component;

import my.site.my_site.core.services.MathematicsOperations;

@Component(service = MathematicsOperations.class, immediate = true)
public class MathematicsOperationsImpl implements MathematicsOperations {

	@Override
	public int additionsOperation(int a, int b) {
		return a+b;
	}

	@Override
	public int multiplicationOperation(int a, int b) {
		return a*b;
	}

}
