package com.jpmorgan.reporting.predicates;

import java.util.function.Predicate;

import com.jpmorgan.reporting.tradeinstructions.TradeFlag;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class BuyingPredicate {

	public final static Predicate<TradeInstructions> buyingTradingInstructions = tradeInstructions -> tradeInstructions
			.getTradeFlag().equals(TradeFlag.BUY);

}
