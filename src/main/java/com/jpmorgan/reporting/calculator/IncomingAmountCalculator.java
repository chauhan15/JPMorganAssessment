package com.jpmorgan.reporting.calculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import com.jpmorgan.reporting.predicates.SellingPredicate;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class IncomingAmountCalculator {
	public static Map<LocalDate, BigDecimal> calculateDailyIncomingAmount(Set<TradeInstructions> tradeInstructions) {
		return DailyAmountCalculator.calculateDailyAmount(tradeInstructions, SellingPredicate.sellingTradingInstructions);
	}
}
