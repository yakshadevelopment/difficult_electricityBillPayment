package java9.diff.app2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main 
{
    public static void main( String[] args ) throws Exception
    {
    	Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Number of consumers bill to prepare:");
		int no=Integer.parseInt(scanner.nextLine());
		if(no<=0)
		{
			System.out.println("invalid input");
			System.exit(0);
		}
		Set<Consumer> consumerSet=new TreeSet<Consumer>();
		for(int i=0;i<no;i++)
		{
			int j=i+1;
		  System.out.println("Enter details of consumer number "+j+":");
		  String input=scanner.nextLine();
		  String arr[]=input.split(",");
		  Consumer consumer=new Consumer(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],arr[4]);
		  String value=BillService.billAmountCalcultion(consumer);
		  consumer.setBillAmount(value);
		  String discountFine=BillService.discountFineCalculation(consumer);
		  consumer.setDiscountFine(discountFine);
		  consumer.setFinalPayment(BillService.totalPaymentCalculation(consumer));
		  consumerSet.add(consumer);
		  }
		System.out.println(String.format("%-5s %-20s %-15s %-15s %-15s %-10s %-10s %-10s","ID","NAME","UNIT-CONSUME","DUE-DATE","PAY-DATE","BILL-AMOUNT","DISCOUNT/FINE","FINAL AMOUNT"));
		Stream<Consumer> consumers=consumerSet.stream();
		consumers.forEach(System.out::println);
    }
}
