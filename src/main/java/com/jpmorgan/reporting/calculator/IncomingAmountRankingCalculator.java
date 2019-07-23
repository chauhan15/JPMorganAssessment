package com.jpmorgan.reporting.calculator;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.jpmorgan.reporting.predicates.SellingPredicate;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class IncomingAmountRankingCalculator {

	public static Map<LocalDate, LinkedList<Rank>> calculateDailyIncomingRanking(
			Set<TradeInstructions> tradeInstructions) {
		return EntitiesRankingCalculator.calculateEntitiesRank(tradeInstructions,
				SellingPredicate.sellingTradingInstructions);
	}

}
