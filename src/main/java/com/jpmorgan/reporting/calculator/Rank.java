package com.jpmorgan.reporting.calculator;

import java.time.LocalDate;

public class Rank {

	private final int entityRank;
	private final String entityName;
	private final LocalDate date;

	public Rank(int entityRank, String entityName, LocalDate date) {
		super();
		this.entityRank = entityRank;
		this.entityName = entityName;
		this.date = date;
	}

	public int getEntityRank() {
		return entityRank;
	}

	public String getEntityName() {
		return entityName;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		result = prime * result + entityRank;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rank other = (Rank) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (entityName == null) {
			if (other.entityName != null)
				return false;
		} else if (!entityName.equals(other.entityName))
			return false;
		if (entityRank != other.entityRank)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntityRank [entityRank=" + entityRank + ", entityName=" + entityName + "]";
	}

}
