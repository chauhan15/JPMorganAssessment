package com.jpmorgan.reporting.mainapplication;

import java.util.Set;

import com.jpmorgan.reporting.datefinder.TradeSettlementDateFinder;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;
import com.jpmorgan.reporting.tradeinstructionsdetails.TradeInstructionData;
import com.jpmorgan.reporting.tradingreport.TradingReportGenerator;

public class MainApplication {

	public static void main(String[] args) {
		final Set<TradeInstructions> tradeInstructions = TradeInstructionData.getTradeInstructionsData();
		TradeSettlementDateFinder.calculateSettlementDates(tradeInstructions);
		System.out.println("**************JP MORGAN TRADE REPORT**************");
		System.out.println("*********Incoming Amount Report*********");
		System.out.println(TradingReportGenerator.generateDailyIncomingAmount(tradeInstructions, new StringBuilder()));
		System.out.println("*********Outgoing Amount Report*********");
		System.out.println(TradingReportGenerator.generateDailyOutgoingAmount(tradeInstructions, new StringBuilder()));
		System.out.println("*********Incoming Ranking Report*********");
		System.out.println(TradingReportGenerator.generateDailyIncomingRanking(tradeInstructions, new StringBuilder()));
		System.out.println("*********Outgoing Ranking Report*********");
		System.out.println(TradingReportGenerator.generateDailyOutgoingRanking(tradeInstructions, new StringBuilder()));
	}

}
