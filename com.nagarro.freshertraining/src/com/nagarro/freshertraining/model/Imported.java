package com.nagarro.freshertraining.model;

import com.nagarro.freshertraining.constants.FinalVariable;

public class Imported extends Item {
	double tax;

	@Override
	public double calculateTax() {
		double ItemCost = super.getPrice();
		tax = (ItemCost * FinalVariable.taxMultiplyingFactor10);
		double surcharge = 0.0;
		if (ItemCost + tax <= 100) {
			surcharge = 5.0;
		} else if (ItemCost + tax > 100 && ItemCost + tax <= 200) {
			surcharge = 10.0;
		} else {
			surcharge = FinalVariable.taxMultiplyingFactor5 * (ItemCost + tax);

		}
		tax = tax + surcharge;
		return tax;
	}

}
