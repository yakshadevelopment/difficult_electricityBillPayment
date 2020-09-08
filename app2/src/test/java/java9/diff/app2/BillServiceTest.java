package java9.diff.app2;

import static org.junit.Assert.*;

import org.junit.Test;


import static java9.diff.app2.TestUtils.*;
public class BillServiceTest {

	@Test
	public void testDiscountFineCalculation() throws Exception {
		Consumer consumer1=new Consumer(3214,"Ryan Stewert","1010","03-08-2020","08-08-2020");
		Consumer consumer2=new Consumer(4321,"Lucy Sarley","990","05-08-2020","03-08-2020");
		Consumer consumer3=new Consumer(4767,"John Miller","950","03-08-2020","05-08-2020");

		String value1=BillService.discountFineCalculation(consumer1);
		String value=BillService.billAmountCalcultion(consumer2);
		consumer2.setBillAmount(value);
		String value2=BillService.discountFineCalculation(consumer2);
		
		String value3=BillService.discountFineCalculation(consumer3);
		yakshaAssert(currentTest(),(value1.equals("500.00")?"true":"false"),businessTestFile);
		yakshaAssert(currentTest(),(value2.equals("-116.50")?"true":"false"),businessTestFile);
		yakshaAssert(currentTest(),(value3.equals("0.00")?"true":"false"),businessTestFile);
	}

	@Test
	public void testBillAmountCalcultion() throws Exception {
		Consumer consumer1=new Consumer(3214,"Ryan Stewert","1010","03-08-2020","08-08-2020");
		Consumer consumer2=new Consumer(4321,"Lucy Sarley","990","05-08-2020","03-08-2020");
		Consumer consumer3=new Consumer(4767,"John Miller","950","03-08-2020","05-08-2020");
		String value1=BillService.billAmountCalcultion(consumer1);
		String value2=BillService.billAmountCalcultion(consumer2);
		String value3=BillService.billAmountCalcultion(consumer3);
			
		yakshaAssert(currentTest(),(value1.equals("1182.00")?"true":"false"),businessTestFile);
		yakshaAssert(currentTest(),(value2.equals("1165.00")?"true":"false"),businessTestFile);
		yakshaAssert(currentTest(),(value3.equals("1125.00")?"true":"false"),businessTestFile);
	}
	
	@Test
    public void testExceptionConditon() throws Exception{
	 yakshaAssert(currentTest(),true,boundaryTestFile);
      }

	@Test
	public void testBoundaryCondition() throws Exception {
	  yakshaAssert(currentTest(),true,exceptionTestFile);
   }





}
