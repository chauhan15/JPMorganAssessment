package com.jpmorgan.reporting.tradeinstructions;

public enum TradeFlag {
	BUY("B"), SELL("S");

	private String action;

	TradeFlag(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public static TradeFlag fromString(String action) {

		if (action != null) {
			for (TradeFlag actionText : TradeFlag.values()) {
				if (action.equalsIgnoreCase(actionText.action)) {
					return actionText;
				}
			}

			throw new IllegalArgumentException("Invalid action flag");
		} else {
			throw new NullPointerException("No action flag has been provided");
		}
	}
}
