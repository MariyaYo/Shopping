package Shoping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeSet;

import Shoping.Product.Type;
import Shoping.Product.IName;
import Shoping.Product.InBroiProducts;
import Shoping.Product.InKgProducts;

public class Shop {
	
	private String name;
	private String adress;
	private double money;
	private HashMap<Type, HashMap<IName, TreeSet<Product>>> AllProducts;
	private int numberOfProducts;
	Random rn = new Random();
	
	Shop(String name, String adress, double money){
		this.name = name;
		this.adress = adress;
		this.money = money;
		AllProducts = new HashMap<>();
		this.numberOfProducts = rn.nextInt(50)+100;
	}
	
	void addProducts(ArrayList<InKgProducts> list){
		for(InKgProducts a : list){
			if(!AllProducts.containsKey(a.getTypeOfProduct())){
				AllProducts.put(a.getTypeOfProduct(), new HashMap<>());
			}
			if(!AllProducts.get(a.getTypeOfProduct()).containsKey(a.getProductNameKg())){
				AllProducts.get(a.getTypeOfProduct()).put(a.getProductNameKg(), new TreeSet<>());
			}
			AllProducts.get(a.getTypeOfProduct()).get(a.getProductNameKg()).add(a);
		}
	}	
	
	void addProductsBroi(ArrayList<InBroiProducts> list){
		for(InBroiProducts a : list){
			if(!AllProducts.containsKey(a.getTypeOfProduct())){
				AllProducts.put(a.getTypeOfProduct(), new HashMap<>());
			}
			if(!AllProducts.get(a.getTypeOfProduct()).containsKey(a.getProductNameBroi())){
				AllProducts.get(a.getTypeOfProduct()).put(a.getProductNameBroi(), new TreeSet<>());
			}
			AllProducts.get(a.getTypeOfProduct()).get(a.getProductNameBroi()).add(a);
		}
	}
	
	void takeMoneyFormClient(ArrayList<Product> list){
		double money = 0;
		for (Product a : list) {
			money += a.getPrice();
		}
		this.money += money;
		for (Product a : list) {
			//for every item in the shopping cart
			for (Iterator<HashMap<IName, TreeSet<Product>>> it = AllProducts.values().iterator(); it.hasNext();) {
				HashMap<IName, TreeSet<Product>> b = it.next();
				for (Iterator <TreeSet<Product>> it2 = b.values().iterator(); it2.hasNext();) {
					if(a.equals(it2)){
						it2.remove();
					}
				}
			}
		}
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}
	
	Product randomProduct(){
		for (Iterator<HashMap<IName, TreeSet<Product>>> it = AllProducts.values().iterator(); it.hasNext();) {
			HashMap<IName, TreeSet<Product>> b = it.next();
			for (Iterator <TreeSet<Product>> it2 = b.values().iterator(); it2.hasNext();) {
				for(Product p : it2.next()){
					return p;
					
				}
			}
		}
		return null;
		
	}
	
	void Print(){
		System.out.println("===================All Products===================");
		for(Entry <Type, HashMap<IName, TreeSet<Product>>> a : AllProducts.entrySet()){
			System.out.println("Everything selling in : " + a.getKey());
			for(Entry<IName, TreeSet<Product>> b : a.getValue().entrySet()){
				System.out.println("         -" + b.getKey() +  "  made from: ");
				System.out.println("              " + b.getValue().toString());
			}
		}
		System.out.println();
	}
}
