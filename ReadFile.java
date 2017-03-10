/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo0803;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import thu5_0903.Student;

/**
 *
 * @author tuana
 */
public class ReadFile {
    
 public static void main(String[] args) {
        HashMap<String, Student> mapStudent = new HashMap<String, Student>();
        // Đọc file và tạo danh sách student.
        try {
            File fileDir = new File("quylop.txt");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF-8"));
            String str = in.readLine(); // bỏ dòng đầu tiên.            
            while ((str = in.readLine()) != null) {
                String[] arraySplit = str.split("[\\s\\t]{2,}+");
                Student student = new Student(
                        arraySplit[0].trim(),
                        arraySplit[1].trim(),
                        Integer.parseInt(arraySplit[2].trim()),
                        arraySplit[3].trim()
                );      
                if (mapStudent.containsKey(student.getId())){
                    Student temp = mapStudent.get(student.getId());
                    student.setMoney((temp.getMoney() + student.getMoney()));
                }
                mapStudent.put((String) student.getId(), student);                
            }
            in.close();
        for (String key : mapStudent.keySet()) {
            System.out.println(mapStudent.get(key).toString());
        }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        
      
    }
}
