package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	
	private Product product;
	
	public OrderItem() {}
	
	public OrderItem(Integer quantity, Double price, Product product) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal(){
		Double subTotal = this.getProduct().getPrice()*this.getQuantity();
		
		return subTotal;
	}
	
	@Override
	public String toString() {
		return this.product.getName() +", "+ "$" + String.format("%.2f", this.product.getPrice()) + ", Quantity: " + this.getQuantity() + ", Subtotal: $" + String.format("%.2f", subTotal());
	}
	
	
}
