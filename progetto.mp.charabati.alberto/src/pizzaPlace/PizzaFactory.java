package pizzaPlace;

public class PizzaFactory implements PizzaFactoryInterface {

	@Override
	public Pizza createMargheritaPizza() {
		return new MargheritaPizza();
	}

	@Override
	public Pizza createPepperoniPizza() {
		return new PepperoniPizza();
	}

}
