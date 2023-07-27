package pizzaPlace;

class GourmetMargherita extends Pizza {
	GourmetMargherita() {
		super("GourmetMargherita", 13.5, "Your classic margherita pizza made with top tier products");
}

	@Override
	protected void preparePizza() throws OrderPreparationException {
    	if(this.getOrderStatus().equals(OrderStatus.ORDER_RECEIVED)) {
    	this.setOrderStatus(OrderStatus.IN_PREPARATION);
    	this.setOrderLogs("Preparing a gourmet margherita pizza with selected cheeses and selected tomatoes!");
    	provideAppetizer();
    	} else {
    		throw new OrderPreparationException("No gourmet margherita order received yet!");
    	}
	}
	
	@Override
	protected void addExtras() throws OrderPreparationException {
    	if(this.getOrderStatus().equals(OrderStatus.IN_PREPARATION)) {
    	this.setOrderStatus(OrderStatus.RAW);
    	//No base addons on Margherita
    	String toppings = "Adding " + this.getToppingsIterator().toString();
    	if(toppings.length()> 7) this.setOrderLogs(toppings);
    	} else {
    		throw new OrderPreparationException("Gourmet margherita pizza needs to be assembled!");
    	}
	}

	@Override
	protected void bakePizza() throws OrderPreparationException {
    	if(this.getOrderStatus().equals(OrderStatus.RAW)) {
    	this.setOrderStatus(OrderStatus.BAKING);
    	this.setOrderLogs("Baking a margherita pizza on our stone stove!");
    	} else {
    		throw new OrderPreparationException("Gourmet margherita pizza needs to be prepared before baking!");
    	}
	}
	
	private void provideAppetizer() {
		this.getOrderLogs().addLog("Selected grilled vegetables sent to client");
	}
	
	

}

