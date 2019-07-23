package com.jpmorgan.reporting.calculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import com.jpmorgan.reporting.predicates.BuyingPredicate;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class OutgoingAmountCalculator {

	public static Map<LocalDate, BigDecimal> calculateDailyOutgoingAmount(Set<TradeInstructions> tradeInstructions) {
		return DailyAmountCalculator.calculateDailyAmount(tradeInstructions, BuyingPredicate.buyingTradingInstructions);
	}

}
