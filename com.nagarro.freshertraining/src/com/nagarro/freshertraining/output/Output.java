package com.nagarro.freshertraining.output;

import java.util.ArrayList;

import com.nagarro.freshertraining.constants.FinalVariable;
import com.nagarro.freshertraining.model.Item;

public class Output {
	public void print(ArrayList<Item> ItemList) {
		System.out.println(FinalVariable.outputHeading);
		System.out.println(FinalVariable.outputsHeading);

		for (Item Item : ItemList) {
			System.out.println(Item.getName() + " " + (Item.getPrice() * Item.getQuantity()) + " "
					+ (Item.calculateTax() * Item.getQuantity()) + " "
					+ ((Item.getPrice() * Item.getQuantity()) + (Item.calculateTax() * Item.getQuantity())));
		}
	}
}
