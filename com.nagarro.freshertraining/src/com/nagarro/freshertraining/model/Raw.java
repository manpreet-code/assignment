package com.nagarro.freshertraining.model;

import com.nagarro.freshertraining.constants.FinalVariable;

public class Raw extends Item {
	double tax;

	@Override
	public double calculateTax() {
		double ItemCost = super.getPrice();
		tax = (ItemCost * FinalVariable.taxMultiplyingFactor12_5);
		return tax;
	}

}
