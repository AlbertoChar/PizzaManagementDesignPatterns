package pizzaPlace;

class PepperoniPizza extends Pizza {
    PepperoniPizza() {
          super("PepperoniPizza", 10.5, "A delicious pizza topped with tomato sauce, mozzarella cheese, and slices of pepperoni");
    }

	@Override
	protected void preparePizza() throws OrderPreparationException {
    	if(this.getOrderStatus().equals(OrderStatus.ORDER_RECEIVED)) {
    	this.setOrderStatus(OrderStatus.IN_PREPARATION);
    	getOrderLogs().addLog("Preparing a pepperoni pizza!");
    	} else {
    		throw new OrderPreparationException("Pepperoni pizza order not received yet!");
    	}
	}
	
	@Override
	protected void addExtras() throws OrderPreparationException {
    	if(this.getOrderStatus().equals(OrderStatus.IN_PREPARATION)) {
    	this.setOrderStatus(OrderStatus.RAW);
    	getOrderLogs().addLog("Adding pepperoni to the pizza!");
    	String toppings = "Adding " + this.getToppingsIterator().toString();
    	if(toppings.length()> 7) getOrderLogs().addLog(toppings);
    	} else {
    		throw new OrderPreparationException("Pepperoni pizza needs to be assembled!");
    	}
	}

	@Override
	protected void bakePizza() throws OrderPreparationException {
    	if(this.getOrderStatus().equals(OrderStatus.RAW)) {
    	this.setOrderStatus(OrderStatus.BAKING);
    	getOrderLogs().addLog("Baking a pepperoni pizza!");
    	} else {
    		throw new OrderPreparationException("Pepperoni pizza needs to be prepared before baking!");
    	}
	}
    


}
