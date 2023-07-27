package pizzaPlace;

class GourmetPepperoni extends Pizza {
	GourmetPepperoni() {
		super("GourmetPepperoni", 14.5, "Your classic pepperoni pizza made with top tier products");
}

protected void preparePizza() throws OrderPreparationException {
	if(this.getOrderStatus().equals(OrderStatus.ORDER_RECEIVED)) {
	this.setOrderStatus(OrderStatus.IN_PREPARATION);
	getOrderLogs().addLog("Gourmet pepperoni pizza being prepared");
	provideAppetizer();
	} else {
		throw new OrderPreparationException("Gourmet pepperoni order not received yet!");
	}
}

@Override
protected void addExtras() throws OrderPreparationException {
	if(this.getOrderStatus().equals(OrderStatus.IN_PREPARATION)) {
	this.setOrderStatus(OrderStatus.RAW);
	getOrderLogs().addLog("Adding the best pepperoni to the pizza!");
	String toppings = "Adding " + this.getToppingsIterator().toString();
	if(toppings.length()> 7) getOrderLogs().addLog(toppings);
	} else {
		throw new OrderPreparationException("Gourmet pepperoni needs to be assembled!");
	}
}

@Override
protected void bakePizza() throws OrderPreparationException {
	if(this.getOrderStatus().equals(OrderStatus.RAW)) {
	this.setOrderStatus(OrderStatus.BAKING);
	getOrderLogs().addLog("Baking a pepperoni pizza on our stone stove!");
	} else {
		throw new OrderPreparationException("Gourmet pepperoni needs to be prepared before baking!");
	}
}

private void provideAppetizer() {
	this.getOrderLogs().addLog("Selected grilled vegetables sent to client");
}
	
	

}
