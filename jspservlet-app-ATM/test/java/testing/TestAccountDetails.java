package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.AccountDetails;

public class TestAccountDetails {
	
	@Test
	public void testSetInputsMethod() {
		AccountDetails accdetails = new AccountDetails("saving",2000,5000,5566);
		assertEquals("saving",accdetails.getAccountType());
		assertEquals(2000,accdetails.getWithdrawOrDepositAmount(),0);
		assertEquals(5000,accdetails.getAvailableBalance(),0);
		assertEquals(5566,accdetails.getPin());
		try {
			accdetails.setAccountType(null);
			accdetails.setWithdrawOrDepositAmount(-500);
			accdetails.setAvailableBalance(-500);
			accdetails.setPin(0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
