package Shoping;

import java.util.Random;

public abstract class Product{
	interface IName{};
	enum Type {KG, BROI}

	private String name;
	private double price;
	private Type typeOfProduct;
	Random rn = new Random();

	Product(String name, double price, Type typeOfProduct) {
		this.name = name;
		this.price = price;
		this.typeOfProduct = typeOfProduct;
	}

	static class InKgProducts extends Product implements Comparable<InKgProducts> {
		enum ProductNameKg implements IName{MEAT, CHEESE, FISH}
		private ProductNameKg productNameKg;
		double quantity;

		InKgProducts(String name, double price, ProductNameKg TypeOfproduktName) {
			super(name, price, Type.KG);
			this.productNameKg = TypeOfproduktName;
			this.quantity = rn.nextDouble()+rn.nextInt(10);
		}

		public ProductNameKg getProductNameKg() {
			return productNameKg;
		}

		@Override
		public int compareTo(InKgProducts a) {
			return this.getName().compareTo(a.getName());
		}

		@Override
		public String toString() {
			return this.getName() + "quantity" +Math.floor(this.quantity);
		}
		
	}
	
	

	public double getPrice() {
		return price;
	}

	static class InBroiProducts extends Product implements Comparable<InBroiProducts>{
		enum ProductNameBroi implements IName{BEER, BOOK, CHAIR}
		private ProductNameBroi productNameBroi;
		int quantity;

		InBroiProducts(String name, double price, ProductNameBroi TypeOfproduktName) {
			super(name, price, Type.BROI);
			this.productNameBroi = TypeOfproduktName;
			this.quantity = rn.nextInt(10);
		}

		public ProductNameBroi getProductNameBroi() {
			return productNameBroi;
		}

		@Override
		public int compareTo(InBroiProducts a) {
			return this.getName().compareTo(a.getName());
		}
		@Override
		public String toString() {
			return this.getName() + "quantity" +this.quantity;
		}
		
		

	}


	public String getName() {
		return name;
	}
	public Type getTypeOfProduct() {
		return typeOfProduct;
	}
	@Override
	abstract public String toString();


}
