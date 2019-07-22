package com.jpmorgan.reporting.tradeinstructionsdetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import com.jpmorgan.reporting.tradeinstructions.TradeFlag;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class TradeInstructionData {

	public static Set<TradeInstructions> getTradeInstructionsData() {
		return new HashSet<>(Arrays
				.asList(new TradeInstructions("foo", TradeFlag.BUY, LocalDate.of(2016, 1, 1), LocalDate.of(2016, 1, 2),
						Currency.getInstance("SGD"), BigDecimal.valueOf(0.50), 200, BigDecimal.valueOf(100.25)),

		new TradeInstructions("bar", TradeFlag.SELL, LocalDate.of(2016, 1, 5), LocalDate.of(2016, 1, 07),
				Currency.getInstance("AED"), BigDecimal.valueOf(0.22), 450, BigDecimal.valueOf(150.5)),

		new TradeInstructions("foo1", TradeFlag.SELL, LocalDate.of(2016, 2, 10), LocalDate.of(2016, 2, 13),
				Currency.getInstance("SAR"), BigDecimal.valueOf(0.27), 150, BigDecimal.valueOf(856.8)),

		new TradeInstructions("bar1", TradeFlag.SELL, LocalDate.of(2016, 4, 5), LocalDate.of(2016, 4, 9),
				Currency.getInstance("EUR"), BigDecimal.valueOf(0.34), 50, BigDecimal.valueOf(900.59)),

		new TradeInstructions("foo2", TradeFlag.BUY, LocalDate.of(2016, 3, 10), LocalDate.of(2016, 3, 15),
				Currency.getInstance("EUR"), BigDecimal.valueOf(0.34), 20, BigDecimal.valueOf(100.36))));

	}

}
