package com.jpmorgan.reporting.calculator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

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

public class OutgoingAmountCalculatorTest {

	
	public static Set<TradeInstructions> getTradeInstructionsData() {
		return new HashSet<>(Arrays
				.asList(new TradeInstructions("foo", TradeFlag.SELL, LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 5),
						Currency.getInstance("SGD"), BigDecimal.valueOf(1), 200, BigDecimal.valueOf(1)),

		new TradeInstructions("bar", TradeFlag.SELL, LocalDate.of(2016, 1, 5), LocalDate.of(2016, 1, 07),
				Currency.getInstance("SAR"), BigDecimal.valueOf(1), 450, BigDecimal.valueOf(1)),

		new TradeInstructions("foo1", TradeFlag.SELL, LocalDate.of(2016, 1, 5), LocalDate.of(2016, 1, 07),
				Currency.getInstance("SAR"), BigDecimal.valueOf(1), 150, BigDecimal.valueOf(1)),

		new TradeInstructions("bar1", TradeFlag.BUY, LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 7),
				Currency.getInstance("SAR"), BigDecimal.valueOf(1), 50, BigDecimal.valueOf(1)),

		new TradeInstructions("foo2", TradeFlag.BUY, LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 7),
				Currency.getInstance("SAR"), BigDecimal.valueOf(1), 20, BigDecimal.valueOf(1))));

		
	}
	@Test
	public void dailyAmountCalculatorTest(){
		TradeSettlementDateFinder.calculateSettlementDates(getTradeInstructionsData());
		
		final Map<LocalDate, BigDecimal> dailyOutGoingAmount =
                OutgoingAmountCalculator.calculateDailyOutgoingAmount(getTradeInstructionsData());

        assertEquals(1, dailyOutGoingAmount.size());
        assertTrue(Objects.equals(dailyOutGoingAmount.get(LocalDate.of(2016, 1, 7)), BigDecimal.valueOf(70.00).setScale(2, BigDecimal.ROUND_HALF_EVEN)));
       
        
		
	}

}
