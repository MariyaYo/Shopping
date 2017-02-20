package Shoping;

import java.util.ArrayList;
import java.util.Random;

import Shoping.Product.InBroiProducts;
import Shoping.Product.InBroiProducts.ProductNameBroi;
import Shoping.Product.InKgProducts;
import Shoping.Product.InKgProducts.ProductNameKg;

public class Main {
	static Random rn = new Random();
	static String[] names = { "Na Baba", "Brand name1", "ShopBrand", "OtherBrand", "BIO" };

	public static void main(String[] args) {

		 class A {

		}
		 class B {

			B() {
				System.out.println(this.getClass());
				System.out.println(this.hashCode());
				System.out.println(super.getClass());
				System.out.println(super.hashCode());
			}
		}
		B b = new B();

		Shop shop = new Shop("Billa", "Pernik", 0);
		ArrayList<InKgProducts> listOfProducts = new ArrayList<>();
		ArrayList<InBroiProducts> listOfProductsbr = new ArrayList<>();

		for (int i = 0; i < shop.getNumberOfProducts(); i++) {
			boolean type = rn.nextBoolean();
			if (type) {
				listOfProductsbr.add(generateProductbr());
			} else {
				listOfProducts.add(generateProductKg());
			}
		}

		shop.addProducts(listOfProducts);
		shop.addProductsBroi(listOfProductsbr);
		shop.Print();

		Client customer = new Client("shop", 500);
		for (int i = 0; i < customer.getMaxIntemsToBuy(); i++) {
			Product randomproduct = shop.randomProduct();
			if (randomproduct instanceof InBroiProducts) {
				InBroiProducts rand = (InBroiProducts) randomproduct;
				customer.addProductbroiToShopingCart(rand);
			} else {
				InKgProducts rand = (InKgProducts) randomproduct;
				customer.addProductToShopingCart(rand);
			}

		}

		customer.removeProductbroiToShopingCart();
		customer.removeProductToShopingCart();

		customer.Pay(customer.getShopingCart());
		shop.takeMoneyFormClient(customer.getShopingCartbr());
		customer.creanShopingCart(customer.getShopingCart());

		shop.Print();
	}

	static InBroiProducts generateProductbr() {
		InBroiProducts x = new InBroiProducts(names[rn.nextInt(names.length)], rn.nextDouble() + rn.nextInt(10),
				ProductNameBroi.values()[rn.nextInt(ProductNameBroi.values().length)]);
		return x;

	}

	static InKgProducts generateProductKg() {
		InKgProducts x = new InKgProducts(names[rn.nextInt(names.length)], rn.nextDouble() + rn.nextInt(10),
				ProductNameKg.values()[rn.nextInt(ProductNameKg.values().length)]);
		return x;
	}
}
