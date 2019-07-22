package com.jpmorgan.reporting.calculator;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class DailyAmountCalculator {

	public static Map<LocalDate, BigDecimal> calculateDailyAmount(Set<TradeInstructions> instructions,
			Predicate<TradeInstructions> predicate) {
		return instructions.stream().filter(predicate).collect(groupingBy(TradeInstructions::getSettlementDate,
				mapping(TradeInstructions::getTradeAmount, reducing(BigDecimal.ZERO, BigDecimal::add))));
	}
	
}
