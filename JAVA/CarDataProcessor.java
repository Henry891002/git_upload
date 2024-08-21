package com.cathaybk.practice.nt00550339.b;



import java.io.BufferedReader;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.math.BigDecimal;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Comparator;

import java.util.HashMap;

import java.util.List;

import java.util.Map;



public class CarDataProcessor {

	public static void main(String[] args) {

		String inputFilePath = "C:\\Users\\Admin\\Desktop\\Java班的資料夾\\cars.csv";

		String outputFilePath = "C:\\Users\\Admin\\Desktop\\Java班的資料夾\\cars2.csv";



		List<Map<String, String>> dataList = new ArrayList<>();

		// 讀檔

		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {

			StringBuilder sb = new StringBuilder();

			String line;

			String headerLine = br.readLine();

			if (headerLine != null) {

				String[] headers = headerLine.split(",");



				while ((line = br.readLine()) != null) {

					String[] values = line.split(",");

					Map<String, String> map = new HashMap<>();



					for (int i = 0; i < headers.length; i++) {

						map.put(headers[i], values[i]);

					}



					dataList.add(map);

				}

				// 用 price 比較

				Collections.sort(dataList, new Comparator<Map<String, String>>() {

					@Override

					public int compare(Map<String, String> o1, Map<String, String> o2) {

						BigDecimal price1 = new BigDecimal(o1.get("Price"));

						BigDecimal price2 = new BigDecimal(o2.get("Price"));

						return price2.compareTo(price1);

					}

				});

				// 寫入

				try (FileWriter writer = new FileWriter(outputFilePath)) {

					writer.write(headerLine + "\n");

					for (Map<String, String> dataMap : dataList) {

						List<String> lineData = new ArrayList<>();

						for (String header : headers) {

							lineData.add(dataMap.get(header));

						}

						writer.write(String.join(",", lineData) + "\n");

					}

				}

				// 輸出

				sb.append(String.format("%-15s %-10s %-15s %-15s%n", "Manufacturer", "Type", "Min.Price", "Price"));

				// 按照 Manufacturer 分類

				Collections.sort(dataList, new Comparator<Map<String, String>>() {

					@Override

					public int compare(Map<String, String> o1, Map<String, String> o2) {

						String manufacturer1 = new String(o1.get("﻿Manufacturer"));

						String manufacturer2 = new String(o2.get("﻿Manufacturer"));

						return manufacturer1.compareTo(manufacturer2);

					}

				});



				String manufacturerBefore = "Acura";

				BigDecimal priceSum = BigDecimal.ZERO;

				BigDecimal priceAll = BigDecimal.ZERO;

				BigDecimal minpriceSum = BigDecimal.ZERO;

				BigDecimal minpriceAll = BigDecimal.ZERO;



				for (Map<String, String> map : dataList) {

					BigDecimal price = new BigDecimal(map.get("Price"));

					BigDecimal minprice = new BigDecimal(map.get("Min.Price"));

					priceAll = priceAll.add(price);

					minpriceAll = minpriceAll.add(minprice);

					String manufacturerAfter = new String(map.get("﻿Manufacturer"));

					sb.append(String.format("%-15s %-10s %8s %12s%n", map.get("﻿Manufacturer"), map.get("Type"),

							minprice.toPlainString(), price.toPlainString()));



					if (manufacturerBefore.equals(manufacturerAfter)) {

						System.out.print(sb.toString());

						sb.setLength(0);

						priceSum = priceSum.add(price);

						minpriceSum = minpriceSum.add(minprice);



					} else {

						System.out.println(String.format("小計　%27s%-12s%5s", "", minpriceSum.toPlainString(),

								priceSum.toPlainString()));

						System.out.print(sb.toString());

						sb.setLength(0);

						manufacturerBefore = manufacturerAfter;

						priceSum = price;

						minpriceSum = minprice;

					}

				}

				System.out.println(String.format("小計　%25s %-12s %-12s", "", minpriceSum.toPlainString(),

						priceSum.toPlainString()));

				System.out.println(String.format("總計　%25s %-12s %-12s", "", minpriceAll.toPlainString(),

						priceAll.toPlainString()));

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

} 