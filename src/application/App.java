package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;

public class App {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		
		
		System.out.println("Enter client data:");
		
		System.out.print("Name: ");
		String name = scan.nextLine();
		
		System.out.print("Emai: ");
		String email = scan.next();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		
		Date birthDate = sdf.parse( scan.next());
		
		Client client = new Client(name, email, birthDate);
		
	
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(scan.next().toUpperCase());
		
		Order order = new Order(new Date(System.currentTimeMillis()), status, client);
		
		
		System.out.print("How many items to this order? ");
		int num = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < num; i++) {
			
			System.out.println("Enter #" + (i+1) + " item data: ");
			
			System.out.print("Product name: ");
			String productName = scan.nextLine();
			
			System.out.print("Product price: ");
			Double price = scan.nextDouble();
			scan.nextLine();
		
			
			System.out.print("Quantity: ");
			int quantity = scan.nextInt();
			scan.nextLine();
			
			Product product = new Product(productName, price);
			
			OrderItem orderItem = new OrderItem(quantity, price, product);
			
			order.addItem(orderItem);
			
		}
	
		
		System.out.println(order);
		
		scan.close();
		
	}

}
