package pizzaPlace;

class MargheritaPizza extends Pizza {
    MargheritaPizza() {
        super("MargheritaPizza", 9.5, "A classic pizza topped with tomato sauce, mozzarella cheese, and fresh basil leaves");
    }

	@Override
	protected void preparePizza() throws OrderPreparationException {
    	if(this.getOrderStatus().equals(OrderStatus.ORDER_RECEIVED)) {
    	this.setOrderStatus(OrderStatus.IN_PREPARATION);
    	this.setOrderLogs("Preparing a margherita pizza!");
    	} else {
    		throw new OrderPreparationException("No margherita pizza order received yet!");
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
    		throw new OrderPreparationException("Margherita pizza needs to be assembled!");
    	}
	}

	@Override
	protected void bakePizza() throws OrderPreparationException {
    	if(this.getOrderStatus().equals(OrderStatus.RAW)) {
    	this.setOrderStatus(OrderStatus.BAKING);
    	this.setOrderLogs("Baking a margherita pizza!");
    	} else {
    		throw new OrderPreparationException("Margherita pizza needs to be prepared before baking!");
    	}
	}
    

}
