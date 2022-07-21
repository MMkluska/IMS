package com.qa.ims.persistence.domain;

public class Request {
	
	private Long id;
	private Long orderId;
	private Long itemId;
	private Long quantity;
	private Double orderPrice;

	public Request(Long orderId, Long itemId, Long quantity) {
		this.setOrderId(orderId);
		this.setItemId(itemId);
		this.setQuantity(quantity);
	}

	public Request(Long id, Long orderId, Long itemId, Long quantity) {
		this.setId(id);
		this.setOrderId(orderId);
		this.setItemId(itemId);
		this.setQuantity(quantity);
	}
	
	public Request(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Override
	public String toString() {
		return "Request ID: " + id + " Order ID: " + orderId + " Item ID: " + itemId + " Quantity " + quantity;
	}
	
	public String toStringCost() {
		return ("Total price is : " + orderPrice);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (getOrderId() == null) {
			if (other.getOrderId() != null)
				return false;
		} else if (!getOrderId().equals(other.getOrderId()))
			return false;
		if (getItemId() == null) {
			if (other.getItemId() != null)
				return false;
		} else if (!getItemId().equals(other.getItemId()))
			return false;
		if (getQuantity() == null) {
			if (other.getQuantity() != null)
				return false;
		} else if (!getQuantity().equals(other.getQuantity()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
