package com.jpmorgan.reporting.calculator;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class EntitiesRankingCalculator {
	
	public static Map<LocalDate, LinkedList<Rank>> calculateEntitiesRank(Set<TradeInstructions> instructions,
			Predicate<TradeInstructions> predicate) {
		final Map<LocalDate, LinkedList<Rank>> ranking = new HashMap<>();

		instructions.stream().filter(predicate).collect(groupingBy(TradeInstructions::getSettlementDate, toSet()))
				.forEach((date, dailyInstructionSet) -> {
					final AtomicInteger rank = new AtomicInteger(1);

					final LinkedList<Rank> ranks = dailyInstructionSet.stream()
							.sorted((a, b) -> b.getTradeAmount().compareTo(a.getTradeAmount()))
							.map(instruction -> new Rank(rank.getAndIncrement(), instruction.getTradingEntity(), date))
							.collect(toCollection(LinkedList::new));

					ranking.put(date, ranks);
				});

		return ranking;
	}

}
