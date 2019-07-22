package com.jpmorgan.reporting.tradingreport;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.jpmorgan.reporting.calculator.Rank;
import com.jpmorgan.reporting.calculator.IncomingAmountCalculator;
import com.jpmorgan.reporting.calculator.IncomingAmountRankingCalculator;
import com.jpmorgan.reporting.calculator.OutgoingAmountCalculator;
import com.jpmorgan.reporting.calculator.OutgoingAmountRankingCalculator;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class TradingReportGenerator {

	public static StringBuilder generateDailyOutgoingAmount(Set<TradeInstructions> instructions,
			StringBuilder stringBuilder) {
		final Map<LocalDate, BigDecimal> dailyOutgoingAmount = OutgoingAmountCalculator
				.calculateDailyOutgoingAmount(instructions);

		stringBuilder.append("Settlement Date|Trade Amount\n").append("****************************************\n");

		for (LocalDate date : dailyOutgoingAmount.keySet()) {
			stringBuilder.append(date).append("       |      ").append(dailyOutgoingAmount.get(date)).append("\n");
		}

		return stringBuilder;
	}

	public static StringBuilder generateDailyIncomingAmount(Set<TradeInstructions> instructions,
			StringBuilder stringBuilder) {
		final Map<LocalDate, BigDecimal> dailyOutgoingAmount = IncomingAmountCalculator
				.calculateDailyIncomingAmount(instructions);

		stringBuilder

		.append("Settlement Date | Trade Amount \n").append("***********************************\n");

		for (LocalDate date : dailyOutgoingAmount.keySet()) {
			stringBuilder.append(date).append("       |      ").append(dailyOutgoingAmount.get(date)).append("\n");
		}

		return stringBuilder;
	}

	public static StringBuilder generateDailyOutgoingRanking(Set<TradeInstructions> instructions,
			StringBuilder stringBuilder) {
		final Map<LocalDate, LinkedList<Rank>> dailyOutgoingRanking = OutgoingAmountRankingCalculator
				.calculateDailyOutgoingRanking(instructions);

		stringBuilder.append("Date of Settlement|Entity Rank|Entity name\n")
				.append("****************************************\n");

		for (LocalDate date : dailyOutgoingRanking.keySet()) {
			for (Rank entityRank : dailyOutgoingRanking.get(date)) {
				stringBuilder.append(date).append("   |      ").append(entityRank.getEntityRank()).append("     |    ")
						.append(entityRank.getEntityName()).append("\n");
			}
		}

		return stringBuilder;
	}

	public static StringBuilder generateDailyIncomingRanking(Set<TradeInstructions> instructions,
			StringBuilder stringBuilder) {
		final Map<LocalDate, LinkedList<Rank>> dailyIncomingRanking = IncomingAmountRankingCalculator
				.calculateDailyIncomingRanking(instructions);

		stringBuilder.append("Date of Settlement|Entity Rank|Entity name\n")
				.append("********************************************\n");

		for (LocalDate date : dailyIncomingRanking.keySet()) {
			for (Rank entityRank : dailyIncomingRanking.get(date)) {
				stringBuilder.append(date).append("   |      ").append(entityRank.getEntityRank()).append("     |    ")
						.append(entityRank.getEntityName()).append("\n");
			}
		}

		return stringBuilder;
	}
}
