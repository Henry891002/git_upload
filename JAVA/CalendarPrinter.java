package com.cathaybk.practice.nt00550339.b;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class CalendarPrinter {
		
		    public static void main(String[] args) {
    	       //年  月  星期  日 
//		  		int month = 1 ; 
		  		Scanner s=new Scanner(System.in);

		        
		        
//		        if (month < 1 || month > 12) { //檢查月份是否為1-12
		            System.out.print("請輸入介於 1 到 12 之間的整數:");
//		            return;
		            int month1 = s.nextInt();
//		        }

		        // 取年
		        int year = LocalDate.now().getYear();

		        // 當月第一天
		        LocalDate firstDayOfMonth = LocalDate.of(year, month1, 1);

		        // 當月的最後一天
		        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

		        // 印月份和年份
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("       yyyy年M月", Locale.CHINA);
		        System.out.println(firstDayOfMonth.format(formatter));
		        
      	        // 印星期標題
		        System.out.println("---------------------");

		        System.out.println(" 日 一  二  三 四  五  六");

		        System.out.println("=====================");
		        
		        // 印空格（直到月份的第一天）
		        int dayOfWeekValue = firstDayOfMonth.getDayOfWeek().getValue();
		        for (int i = 1; i < dayOfWeekValue; i++) {
		            System.out.print("   ");
		        }
	        
		        // 打印每一天
		        for (int day = 1; day <= lastDayOfMonth.getDayOfMonth(); day++) {
		            System.out.print(String.format("%2d ", day));
		            // 換行到下一個星期
		            if ((day + dayOfWeekValue - 1) % 7 == 0) {
		                System.out.println();
		            }
		        }
		        
		        // 最後換行
		        System.out.println();
		    }
		

	}


