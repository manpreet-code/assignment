package com.nagarro.freshertraining.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.nagarro.freshertraining.constants.FinalVariable;
import com.nagarro.freshertraining.input.ItemInput;
import com.nagarro.freshertraining.model.Item;
import com.nagarro.freshertraining.output.Output;

public class ProductMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean bool = true;
		ArrayList<Item> itemlist = new ArrayList<>();
		Output Output = new Output();
		do {
			ItemInput item = new ItemInput();
			itemlist.add(item.getItem());
			System.out.print(FinalVariable.inputMoreItems);
			String ans = scanner.nextLine().toLowerCase();
			if (ans.equals("no")) {
				bool = false;
			}
		} while (bool);
		Output.print(itemlist);
		scanner.close();

	}

}
