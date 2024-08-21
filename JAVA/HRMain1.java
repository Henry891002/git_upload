package com.cathaybk.practice.nt00550339.b;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HRMain1 {

	public static void main(String[] args) {
		List<Employee>employeeList =new ArrayList<Employee>();
		employeeList.add(new Sales("張志城", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeeList.add(new Supervisor("李中白","資訊部",65000));
		employeeList.add(new Supervisor("林小中", "理財部", 80000));
				

        // C:\\Users\\Admin\\Desktop\\Java班的資料夾 檔案
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\Java班的資料夾\\output.csv", true))) {
           // writer.write("Name,Payment");  // 寫入標頭
            //writer.newLine();

            for (Employee employee : employeeList) {
                writer.write(employee.getName() + "," + getEmployeepayment(employee));
                writer.newLine();
            }
           
            System.out.println("資料已成功寫入 C:\\Users\\Admin\\Desktop\\Java班的資料夾\\\\output.csv");
        } catch (IOException e) {
            System.err.println("寫入文件時發生錯誤: " + e.getMessage());
        }
    }

    //獲取員工薪水（Payment）的方法
    private static int getEmployeepayment(Employee employee) {
        if (employee instanceof Sales) {
            return ((Sales) employee).getPayment();
        } else if (employee instanceof Supervisor) {
            return ((Supervisor) employee).getPayment();
        }
        return 0;
   }
}
