package com.jpmorgan.reporting.datefinder;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import org.junit.Test;

import com.jpmorgan.reporting.tradeinstructions.TradeFlag;
import com.jpmorgan.reporting.tradeinstructions.TradeInstructions;


public class TradeSettlementDateFinderTest {
	 LocalDate originalDateOfSettlement = null;

    @Test
    public void findSettlementDateForNonArabicsOnWorkingDay() throws Exception {
    	
    	originalDateOfSettlement = LocalDate.of(2016, 3, 10); 
    	final TradeInstructions tradeInstructions =	new TradeInstructions("foo2", TradeFlag.BUY, LocalDate.of(2016, 3, 9), originalDateOfSettlement,
				Currency.getInstance("EUR"), BigDecimal.valueOf(0.34), 20, BigDecimal.valueOf(100.36));
        TradeSettlementDateFinder.calculateSettlementDate(tradeInstructions);
        assertEquals(originalDateOfSettlement, tradeInstructions.getSettlementDate());
    }

    @Test
    public void findSettlementDateForNonArabicsOnNonWorkingDay() throws Exception {
    	originalDateOfSettlement = LocalDate.of(2016, 3, 20); 
    final TradeInstructions tradeInstructions =	new TradeInstructions("foo2", TradeFlag.BUY, LocalDate.of(2016, 3, 10), originalDateOfSettlement,
				Currency.getInstance("EUR"), BigDecimal.valueOf(0.34), 20, BigDecimal.valueOf(100.36));
        TradeSettlementDateFinder.calculateSettlementDate(tradeInstructions);
        assertEquals(LocalDate.of(2016, 3, 21), tradeInstructions.getSettlementDate());
    }
    
    @Test
    public void findSettlementDateForArabicsOnWorkingDay() throws Exception {
    	
    	originalDateOfSettlement = LocalDate.of(2016, 3, 2); 
    	final TradeInstructions tradeInstructions =	new TradeInstructions("foo2", TradeFlag.BUY, LocalDate.of(2016, 3, 1), originalDateOfSettlement,
				Currency.getInstance("AED"), BigDecimal.valueOf(0.34), 20, BigDecimal.valueOf(100.36));
        TradeSettlementDateFinder.calculateSettlementDate(tradeInstructions);
        assertEquals(originalDateOfSettlement, tradeInstructions.getSettlementDate());
    }

    @Test
    public void findSettlementDateForArabicsOnNonWorkingDay() throws Exception {
    	originalDateOfSettlement = LocalDate.of(2016, 3, 4); 
    final TradeInstructions tradeInstructions =	new TradeInstructions("foo2", TradeFlag.BUY, LocalDate.of(2016, 3, 2), originalDateOfSettlement,
				Currency.getInstance("AED"), BigDecimal.valueOf(0.34), 20, BigDecimal.valueOf(100.36));
        TradeSettlementDateFinder.calculateSettlementDate(tradeInstructions);
        assertEquals(LocalDate.of(2016, 3, 6), tradeInstructions.getSettlementDate());
    }
    
}
