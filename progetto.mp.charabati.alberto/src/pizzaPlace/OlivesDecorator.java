package pizzaPlace;

public class OlivesDecorator extends PizzaDecorator {
    protected OlivesDecorator(IPizza decoratedPizza) throws ToppingAlreadyAddedException {
    	super(PizzaToppingsManager
    			.checkAndAddTopping(decoratedPizza, OlivesDecorator.class));
    }
    
    @Override
    public double getPrice() {
    	return decoratedPizza.getPrice() + 0.75;
    }

	@Override
	public String getDescription() {
		return decoratedPizza.getDescription() + " with olives";
	}
	
	public String toString() {
		return "Olives";
	}

}
