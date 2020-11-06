package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date clientBirth = sdf.parse(sc.next());
		Client client = new Client(clientName, clientEmail, clientBirth);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		sc.nextLine();
		String orderStatus = sc.nextLine();
		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		Date Ordermoment = new Date();
		Order order = new Order(Ordermoment, OrderStatus.valueOf(orderStatus), client);
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter #"+ (i+1) +" item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String clientProduct = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			Product orderProduct = new Product(clientProduct, price);
			OrderItem orderItem = new OrderItem(quantity, price, orderProduct);
			order.addItem(orderItem);
		}
		
		System.out.println(order);
		
		
		
		sc.close();
	}
}