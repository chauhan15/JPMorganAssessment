package com.jpmorgan.reporting.calculator;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.jpmorgan.reporting.predicates.BuyingPredicate;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class OutgoingAmountRankingCalculator {

	public static Map<LocalDate, LinkedList<Rank>> calculateDailyOutgoingRanking(
			Set<TradeInstructions> tradeInstructions) {
		return EntitiesRankingCalculator.calculateEntitiesRank(tradeInstructions,
				BuyingPredicate.buyingTradingInstructions);
	}

}
