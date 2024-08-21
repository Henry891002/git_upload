package com.cathaybk.practice.nt00550339.b;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.plaf.basic.BasicPasswordFieldUI;

public class RandomLotto {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < 49; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers, new Random());
		List<Integer> selectedNumbers = numbers.subList(0, 6);
		System.out.println("排序前:" + selectedNumbers);
		Collections.sort(selectedNumbers);
		System.out.println("排序後:" + selectedNumbers);

	}

}
