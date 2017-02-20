package Shoping;

import java.util.ArrayList;
import java.util.Random;

import Shoping.Product.InBroiProducts;
import Shoping.Product.InKgProducts;

public class Client {
	private String shopName;
	private double money;
	private int maxIntemsToBuy;
	private ArrayList<Product> shopingCart;
	private double howMuchCostkg;
	private ArrayList<Product> shopingCartbr;
	private double howMuchCostbr;
	Random rn = new Random();
	
	Client(String shopName, double money){
		this.shopName = shopName;
		this.money = money;
		this.maxIntemsToBuy = 5;
		shopingCart = new ArrayList<>();
		shopingCartbr = new ArrayList<>();
	}
	
	void addProductToShopingCart(InKgProducts a){
		this.shopingCart.add(a);
		this.howMuchCostkg += a.getPrice();
 
	}
	void removeProductToShopingCart(){
		if(this.money/2 < this.howMuchCostbr){
			this.shopingCart.remove(this.shopingCart.size());
		}
	}
	
	
	void addProductbroiToShopingCart(InBroiProducts a){
		this.shopingCartbr.add(a);
		this.howMuchCostbr += a.getPrice();

	}
	void removeProductbroiToShopingCart(){
		if(this.money/2 <this.howMuchCostkg){
			this.shopingCartbr.remove(this.shopingCartbr.size());
		}
	}
	
	void Pay(ArrayList<Product> list){
		double money = 0;
		for (Product a : list) {
			money += a.getPrice();
		}
		this.money -= money;
	}
	void creanShopingCart(ArrayList<Product> list){
		this.shopingCart.clear();
	}

	public int getMaxIntemsToBuy() {
		return maxIntemsToBuy;
	}

	public ArrayList<Product> getShopingCart() {
		return shopingCart;
	}

	public double getMoney() {
		return money;
	}

	public ArrayList<Product> getShopingCartbr() {
		return shopingCartbr;
	}
	
	
}
