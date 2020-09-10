package java9.diff.app2;




public class Consumer  implements Comparable<Consumer>{
	private Integer id;
	private String name;
	private String unitConsumed;
	private String dueDate; 
	private String actualPayDate;
	private String discountFine;
	private String billAmount;
	private String finalPayment;
	
	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Consumer(Integer id, String name, String unitConsumed, String dueDate, String actualPayDate,
			String discountFine, String billAmount, String finalPayment) {
		super();
		this.id = id;
		this.name = name;
		this.unitConsumed = unitConsumed;
		this.dueDate = dueDate;
		this.actualPayDate = actualPayDate;
		this.discountFine = discountFine;
		this.billAmount = billAmount;
		this.finalPayment = finalPayment;
	}

	public Consumer(Integer id, String name, String unitConsumed,String dueDate,String actualPayDate) {
		super();
		this.id = id;
		this.name = name;
		this.unitConsumed = unitConsumed;
		this.dueDate=dueDate;
		this.actualPayDate=actualPayDate;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnitConsumed() {
		return unitConsumed;
	}

	public void setUnitConsumed(String unitConsumed) {
		this.unitConsumed = unitConsumed;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getActualPayDate() {
		return actualPayDate;
	}

	public void setActualPayDate(String actualPayDate) {
		this.actualPayDate = actualPayDate;
	}

	public String getDiscountFine() {
		return discountFine;
	}

	public void setDiscountFine(String discountFine) {
		this.discountFine = discountFine;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getFinalPayment() {
		return finalPayment;
	}

	public void setFinalPayment(String finalPayment) {
		this.finalPayment = finalPayment;
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
