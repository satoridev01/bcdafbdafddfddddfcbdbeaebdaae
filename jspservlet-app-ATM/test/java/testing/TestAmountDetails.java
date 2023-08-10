package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.AccountDetails;
import service.AmountDetails;

public class TestAmountDetails {
	AmountDetails amtdetails = new AmountDetails();
	
	@Test
	public void testWithdrawAmountMethod() {
		assertEquals(5000,amtdetails.withdrawAmount(5000, 10000),0);
		assertEquals(0,amtdetails.withdrawAmount(5000, 5000),0);
		try {
			amtdetails.withdrawAmount(-500, -500);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDepositAmountMethod() {
		assertEquals(15000,amtdetails.depositAmount(5000, 10000),0);
		assertEquals(0,amtdetails.depositAmount(0, 0),0);
		try {
			amtdetails.depositAmount(-500, -500);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAccountBalanceMethod() {
		assertEquals(5000,amtdetails.accountBalance(5000),0);
		assertEquals(0,amtdetails.accountBalance(0),0);
		try {
			amtdetails.accountBalance(-500);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
