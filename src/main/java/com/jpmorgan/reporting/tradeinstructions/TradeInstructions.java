package com.jpmorgan.reporting.tradeinstructions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

public class TradeInstructions {

    private final String tradingEntity;
    private final TradeFlag tradeFlag;
    private final LocalDate instructionDate;
    private LocalDate settlementDate;
    private final Currency tradingCurrency;
    private final BigDecimal agreedFx;
    private final int unitsToBeTraded;
    private final BigDecimal pricePerUnit;
    private final BigDecimal totatTradingAmountInUSD;

	public TradeInstructions(String entity, TradeFlag tradeFlag, LocalDate instructionDate, LocalDate settlementDate,
			Currency currency, BigDecimal agreedFx, int units, BigDecimal pricePerUnit) {
		super();
		this.tradingEntity = entity;
		this.tradeFlag = tradeFlag;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.tradingCurrency = currency;
		this.agreedFx = agreedFx;
		this.unitsToBeTraded = units;
		this.pricePerUnit = pricePerUnit;
		this.totatTradingAmountInUSD = calculateTotatTradingAmountInUSD(this);
	}
	
	 public static  BigDecimal calculateTotatTradingAmountInUSD(TradeInstructions tradeInstructions) {
	        return tradeInstructions.getPricePerUnit()
	                .multiply(BigDecimal.valueOf(tradeInstructions.getUnits()))
	                .multiply(tradeInstructions.getAgreedFx());
	    }

	public String getTradingEntity() {
		return tradingEntity;
	}

	public TradeFlag getTradeFlag() {
		return tradeFlag;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public Currency getCurrency() {
		return tradingCurrency;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public int getUnits() {
		return unitsToBeTraded;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public BigDecimal getTradeAmount() {
		return totatTradingAmountInUSD.setScale(2, BigDecimal.ROUND_CEILING);
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}
	
	

}
