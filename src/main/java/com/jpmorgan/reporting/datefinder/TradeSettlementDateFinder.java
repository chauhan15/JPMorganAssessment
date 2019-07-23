package com.jpmorgan.reporting.datefinder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Set;

import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;

public class TradeSettlementDateFinder {

	static LocalDate nextSettlementDate = null;

	public static void calculateSettlementDate(TradeInstructions tradeInstructions) {
		tradeInstructions.getCurrency();
		tradeInstructions.getCurrency();
		if (tradeInstructions.getCurrency().equals(Currency.getInstance("AED"))
				|| tradeInstructions.getCurrency().equals(Currency.getInstance("SAR"))) {
			nextSettlementDate = findFirstWorkingDateForArabics(tradeInstructions.getSettlementDate());
		}

		else {
			nextSettlementDate = findFirstWorkingDateForNonArabics(tradeInstructions.getSettlementDate());
		}
		if (nextSettlementDate != null) {
			tradeInstructions.setSettlementDate(nextSettlementDate);
		}
	}

	private static LocalDate findFirstWorkingDateForNonArabics(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		int daysToAdd = 0;
		if (DayOfWeek.SATURDAY.equals(day)) {
			daysToAdd = 2;
		} else if (DayOfWeek.SUNDAY.equals(day)) {
			daysToAdd = 1;
		}
		return date.plusDays(daysToAdd);
	}

	private static LocalDate findFirstWorkingDateForArabics(LocalDate date) {
		DayOfWeek day = date.getDayOfWeek();
		int daysToAdd = 0;
		if (DayOfWeek.FRIDAY.equals(day)) {
			daysToAdd = 2;
		} else if (DayOfWeek.SATURDAY.equals(day)) {
			daysToAdd = 1;
		}
		return date.plusDays(daysToAdd);
	}

	public static void calculateSettlementDates(Set<TradeInstructions> tradeInstructions) {
		tradeInstructions.forEach(TradeSettlementDateFinder::calculateSettlementDate);
	}
}
