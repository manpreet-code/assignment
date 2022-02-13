package com.nagarro.freshertraining.model;

import com.nagarro.freshertraining.constants.FinalVariable;

public class Manufacture extends Item {
	double tax;

	@Override
	public double calculateTax() {
		double ItemCost = super.getPrice();
		double rTax = (ItemCost * FinalVariable.taxMultiplyingFactor12_5);
		tax = (rTax + FinalVariable.taxMultiplyingFactor2 * (ItemCost + rTax));

		return tax;
	}

}
