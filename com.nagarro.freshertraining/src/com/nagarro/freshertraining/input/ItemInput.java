package com.nagarro.freshertraining.input;

import java.util.Scanner;

import com.nagarro.freshertraining.constants.FinalVariable;
import com.nagarro.freshertraining.model.Imported;
import com.nagarro.freshertraining.model.Item;
import com.nagarro.freshertraining.model.Manufacture;
import com.nagarro.freshertraining.model.Raw;

public class ItemInput {
	Scanner Scanner = new Scanner(System.in);

	public Item getItem() {
		String name = getName();
		String type = getType();
		double price = getPrice();
		double quantity = getQuantity();
		Item Item = null;
		if (type.matches("raw")) {
			Item = new Raw();

		} else if (type.matches("manufacture")) {
			Item = new Manufacture();

		} else {
			Item = new Imported();
		}
		Item.setName(name);
		Item.setPrice(price);
		Item.setQuantity(quantity);
		return Item;

	}

	public String getName() {
		System.out.print(FinalVariable.inputItemNameMessage);
		String name = Scanner.nextLine();
		if (name.equals("")) {
			System.out.println(FinalVariable.nullValueMessage);
			name = getName();
		}
		return name;
	}

	public String getType() {
		System.out.print(FinalVariable.inputItemTypeMessage);
		String type = Scanner.nextLine();
		if (!type.equals("raw") && !type.equals("manufacture") && !type.equals("imported")) {
			System.out.println(FinalVariable.invalidInputItemType);
			type = getType();
		}
		return type;
	}

	public double getPrice() {
		System.out.print(FinalVariable.inputItemCostMessage);
		double price = 0;
		String str = Scanner.nextLine();

		try {
			Double.parseDouble(str);
			double d = Double.parseDouble(str);
			if (d <= 0) {
				System.out.println(FinalVariable.invalidItemValueMessage);
				price = getPrice();
			} else {
				return d;
			}
		} catch (NumberFormatException e) {
			System.out.println(FinalVariable.numericValueMessage);
			price = getPrice();
		}
		return price;

	}

	public double getQuantity() {
		System.out.print(FinalVariable.inputItemQuantityMessage);
		double quantity;
		String str = Scanner.nextLine();

		try {
			Integer.parseInt(str);
			double d = Double.parseDouble(str);
			if (d <= 0) {
				System.out.println(FinalVariable.wholeNumberValueMessage);
				quantity = getQuantity();
			} else {
				return d;
			}
		} catch (NumberFormatException e) {
			System.out.println(FinalVariable.numericValueMessage);
			quantity = getQuantity();
		}
		return quantity;

	}

}
