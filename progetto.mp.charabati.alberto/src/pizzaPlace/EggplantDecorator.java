package pizzaPlace;


public class EggplantDecorator extends PizzaDecorator {
    protected EggplantDecorator(IPizza decoratedPizza) throws ToppingAlreadyAddedException {
    	super(PizzaToppingsManager
    			.checkAndAddTopping(decoratedPizza, EggplantDecorator.class));
    }
    
    @Override
    public double getPrice() {
    	return decoratedPizza.getPrice() + 1.5;
    }

    @Override
	public String getDescription() {
		return decoratedPizza.getDescription() + " with eggplant";
	}
	
	public String toString() {
		return "Eggplant";
	}
	
}
