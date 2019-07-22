package com.jpmorgan.reporting.calculator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.junit.Test;

import com.jpmorgan.reporting.datefinder.TradeSettlementDateFinder;
import com.jpmorgan.reporting.tradeinstructions.TradeFlag;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;


public class IncomingAmountCalculatorTest {

	
	public static Set<TradeInstructions> getTradeInstructionsData() {
		return new HashSet<>(Arrays
				.asList(new TradeInstructions("foo", TradeFlag.BUY, LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 2),
						Currency.getInstance("SGD"), BigDecimal.valueOf(0.50), 200, BigDecimal.valueOf(100.25)),

		new TradeInstructions("bar", TradeFlag.SELL, LocalDate.of(2016, 1, 5), LocalDate.of(2016, 1, 07),
				Currency.getInstance("SAR"), BigDecimal.valueOf(1), 450, BigDecimal.valueOf(1)),

		new TradeInstructions("foo1", TradeFlag.SELL, LocalDate.of(2016, 1, 5), LocalDate.of(2016, 1, 07),
				Currency.getInstance("SAR"), BigDecimal.valueOf(1), 150, BigDecimal.valueOf(1)),

		new TradeInstructions("bar1", TradeFlag.BUY, LocalDate.of(2016, 4, 5), LocalDate.of(2016, 4, 9),
				Currency.getInstance("EUR"), BigDecimal.valueOf(0.34), 50, BigDecimal.valueOf(900.59)),

		new TradeInstructions("foo2", TradeFlag.BUY, LocalDate.of(2016, 3, 10), LocalDate.of(2016, 3, 15),
				Currency.getInstance("EUR"), BigDecimal.valueOf(0.34), 20, BigDecimal.valueOf(100.36))));

		
	}
	@Test
	public void dailyAmountCalculatorTest(){
		TradeSettlementDateFinder.calculateSettlementDates(getTradeInstructionsData());
		
		final Map<LocalDate, BigDecimal> dailyIncomingAmount =
                IncomingAmountCalculator.calculateDailyIncomingAmount(getTradeInstructionsData());

        assertEquals(1, dailyIncomingAmount.size());
        assertTrue(Objects.equals(dailyIncomingAmount.get(LocalDate.of(2016, 1, 7)), BigDecimal.valueOf(600.00).setScale(2, BigDecimal.ROUND_HALF_EVEN)));
       
        
		
	}

}
