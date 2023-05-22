package com.telusko.ProductSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ProductSpringApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = SpringApplication.run(ProductSpringApplication.class, args);

		ProductService service =context.getBean(ProductService.class);



		// Printing menu options
		System.out.println( "Press 1 -> get all products "+"\n"+
				"Press 2 -> get particular product " + "\n"+
				"Press 3 -> product with text" + "\n" +
				"Press 4 -> product with place " + "\n" +
				"Press 5 -> product with warrenty "+"\n"+
				"Press 6 -> Add the data to the DB (DO IT ONLY ONCE)");
		// Reading user input
		switch(sc.nextInt()){
			case 1:
				// Case 1: Get all products
				printResults(service.getAllProducts());
				System.out.println("==============================================");
				System.out.println("All the products.");
				break;
			case 2:
				// Case 2: Get particular product
				System.out.println("Enter the product name - ");
				System.out.println( service.getProduct(sc.next()));
				System.out.println("==============================================");
				System.out.println("The product you asked for ");
				break;
			case 3:
				// Case 3: Search products by text
				System.out.println("Enter the text for product search - ");
				printResults(service.searchByText(sc.next()));
				System.out.println("==============================================");
				System.out.println("All the products that matched the text");
				break;
			case 4:
				// Case 4: Search products by place
				System.out.println("Enter the product Place - ");
				printResults(service.searchByPlace(sc.next()));
				System.out.println("==============================================");
				System.out.println("All the products that matched the place");
				break;
			case 5:
				// Case 5: Search products by warranty
				System.out.println("Enter the product warrenty year - ");
				printResults(service.searchByWarranty(sc.nextInt()));
				System.out.println("==============================================");
				System.out.println("All the products that matched the warrenty");
				break;
			case 6:
				service.addProduct(new Product("Type C", "Cable", "Black Drawer", 2024));
				service.addProduct(new Product("MacStudio", "Computer", "White Table", 2025));
				service.addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
				service.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
				service.addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
				service.addProduct(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
				service.addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
				service.addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
				service.addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
				service.addProduct(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
				service.addProduct(new Product("Java Black Book", "Cable", "Shelf", 2024));
				service.addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
				service.addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
				service.addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
				service.addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));
				System.out.println("==============================================");
				System.out.println("Dummy data added to the DB");
				break;

			default:
				// Invalid choice
				System.out.println("Invalid Choice!!!");


		}
	}

	private static void printResults(List<Product> products) {
		for (Product product : products) {
			System.out.println(product);
		}
	}
}
