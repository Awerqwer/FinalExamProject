package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTest {

	@Test
	public void TestTotalAmountSaved() {
		Retirement r1 = new Retirement(40,0.07,20,0.02,10000.0,2642.0);
		assertEquals(r1.TotalAmountSaved(),1454485.55,0.01);
	}
	
	@Test
	public void TestAmountToSave() {
		Retirement r2 = new Retirement(40,0.07,20,0.02,10000.0,2642.0);
		assertEquals(r2.AmountToSave(),554.13,0.01);
	}

}