package java9.diff.app2;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class BillService {
	public static String discountFineCalculation (Consumer consumer) throws Exception
	{
		String discountFine="";
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		Date dueDate=simpleDateFormat.parse(consumer.getDueDate());
		Calendar calendar=Calendar.getInstance();
		 calendar.setTime(dueDate);
		 int year=calendar.get(Calendar.YEAR);
		 int month=calendar.get(Calendar.MONTH)+1;
		 int day=calendar.get(Calendar.DATE);
		 LocalDate dateDue=LocalDate.of(year, month, day);
		 Date actualDate=simpleDateFormat.parse(consumer.getActualPayDate());
			calendar.setTime(actualDate);
			  year=calendar.get(Calendar.YEAR);
			  month=calendar.get(Calendar.MONTH)+1;
			  day=calendar.get(Calendar.DATE);
			 LocalDate dateActual=LocalDate.of(year, month, day);
			 Period difference=Period.between(dateDue,dateActual);
		 int dayDifference=difference.getDays();
		 
		 if(dayDifference<0)
		 {
			 double value=Double.parseDouble(consumer.getBillAmount());
			 value=(value/10.00)*(-1.00);
			 
			 discountFine=new DecimalFormat("0.00").format(value);
		 }
		 else if(dayDifference<=3)
			 discountFine="0.00";
		 else if(dayDifference>3)
		 {
			 discountFine=new DecimalFormat("0.00").format(dayDifference*100.00);
		 }

		return discountFine;
	}
	public static String billAmountCalcultion(Consumer consumer)
	{
		double billValue=0.0;
		int consumption=Integer.parseInt(consumer.getUnitConsumed());
		if(consumption<=200)
		billValue=300.00;
		else if(consumption<=500)
		{
			int remain=consumption-200;
			billValue=300.00+(remain*1.25);
			
		}
		else if(consumption<=1000)
		{
			int remain=consumption-500;
			billValue=300.00+((500-200)*1.25)+(remain*1.00);
		}
		else 
		{
			int remain=consumption-1000;
			billValue=300.00+((500-200)*1.25)+((1000-500)*1.00)+(remain*0.75);
	
		}
		DecimalFormat decimalFormat=new DecimalFormat("0.00");
		String billPayment=decimalFormat.format(billValue);		
		return billPayment;
	}
	public static String totalPaymentCalculation(Consumer consumer)
	{
		double value=Double.parseDouble(consumer.getBillAmount());
        value=value+Double.parseDouble(consumer.getDiscountFine());
    	DecimalFormat decimalFormat=new DecimalFormat("0.00");
		String finalPayment=decimalFormat.format(value);		
		return finalPayment;
		
	}

}
