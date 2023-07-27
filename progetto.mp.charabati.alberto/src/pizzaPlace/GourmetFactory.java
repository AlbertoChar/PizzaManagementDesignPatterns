package pizzaPlace;

public class GourmetFactory implements PizzaFactoryInterface {

	@Override
	public Pizza createMargheritaPizza() {
		return new GourmetMargherita();
	}

	@Override
	public Pizza createPepperoniPizza() {
		return new GourmetPepperoni();
	}

}
