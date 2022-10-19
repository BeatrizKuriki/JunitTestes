package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	/*
	 * PARA FAZER TESTES VOCÊ DEVE UTILIZAR O PADRÃO AAA
	 * A - ARRANGE: INSTANCIE OS OBJETOS NECESSÁRIOS;
	 * A - ACT: EXECUTE AS AÇÕES NECESSÁRIAS;
	 * A - ASSERT: DECLARE O QUE DEVERIA ACONTECER (RESULTADO ESPERADO)
	 *  
	 * <AÇÃO> should <EFEITO> [when <CENÁRIO>]
	 */
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		//feito o arrange
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		//feito o act- execute as ações necessárias
		acc.deposit(amount);
		
		//assert - declarar o que deverá acontecer- no caso o saldo da conta deve ter 2% a menos como resultado
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		//arrange
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		//act
		acc.deposit(amount);
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
		
	}
	
	@Test
	public void fullWithdrawDShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		//act
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	
	}

}
