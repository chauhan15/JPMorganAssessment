package com.jpmorgan.reporting.predicates;

import java.util.function.Predicate;

import com.jpmorgan.reporting.tradeinstructions.TradeFlag;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class SellingPredicate {

	public final static Predicate<TradeInstructions> sellingTradingInstructions = tradeInstructions -> tradeInstructions
			.getTradeFlag().equals(TradeFlag.SELL);
}
