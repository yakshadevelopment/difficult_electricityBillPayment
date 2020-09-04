package java9.diff.app2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer  implements Comparable<Consumer>{
	private Integer id;
	private String name;
	private String unitConsumed;
	private String dueDate; 
	private String actualPayDate;
	private String discountFine;
	private String billAmount;
	private String finalPayment;
	public Consumer(Integer id, String name, String unitConsumed,String dueDate,String actualPayDate) {
		super();
		this.id = id;
		this.name = name;
		this.unitConsumed = unitConsumed;
		this.dueDate=dueDate;
		this.actualPayDate=actualPayDate;
	}
	@Override
	public String toString() {
		String output=String.format("%-5s %-20s %-15s %-15s %-15s %-10s %-15s %-10s",id,name,unitConsumed,dueDate,actualPayDate,billAmount,discountFine,finalPayment);
		return output;
	}
	
	
	public int compareTo(Consumer other)
	{
		return this.id.compareTo(other.id);
	}
}
