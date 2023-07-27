package pizzaPlace;


public abstract class Pizza implements IPizza {
    private final String name;
    private double price;
    private String description;
    private PizzaToppingsManager toppings;
    private EatStrategy eatStrategy;
    private OrderStatus orderStatus;
    private OrderLogs orderLogs;

    Pizza(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.toppings = new PizzaToppingsManager();
        orderStatus = OrderStatus.WAITING;
        this.orderLogs = new OrderLogs();
    }

    @Override
	public String getName() {
        return name;
    }

    @Override
	public double getPrice() {
        return price;
    }

    @Override
	public String getDescription() {
        return description;
    }

    public Iterable<PizzaDecorator> getToppingsIterator() {
        return this.toppings;
    }
    
    public void addTopping(PizzaDecorator topping) {
    	this.toppings.addTopping(topping);
    }

    protected final void PizzaOrderManagement() throws OrderPreparationException {
        getEatStrategy();
    	orderPizza();
        preparePizza();
        addExtras();
        bakePizza();
        servePizza();
    }

    protected void orderPizza() {
    	this.setOrderStatus(OrderStatus.ORDER_RECEIVED);
    	this.setOrderLogs("Pizza order has been received");
    }

    protected abstract void preparePizza() throws OrderPreparationException;
    
    protected abstract void addExtras() throws OrderPreparationException;

    protected abstract void bakePizza() throws OrderPreparationException;

    protected void servePizza() throws OrderPreparationException {
    	if(this.getOrderStatus().equals(OrderStatus.BAKING)) {
    	this.setOrderStatus(OrderStatus.READY);
    	this.setOrderLogs("Serving the pizza!");
    	} else {
    		throw new OrderPreparationException("Pizza not baked yet!");
    	}
    }

	public EatStrategy getEatStrategy() {
		return eatStrategy;
	}

	public void setEatStrategy(EatStrategy eatStrategy) {
		this.eatStrategy = eatStrategy;
	}
	
	protected double totalCost() {
		return eatStrategy.eatingStrategy(this);
	}

	protected OrderStatus getOrderStatus() {
		return orderStatus;
	}

	protected void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	protected OrderLogs getOrderLogs() {
		return orderLogs;
	}

	protected void setOrderLogs(String string) {
		this.orderLogs.addLog(string);
	}

}
