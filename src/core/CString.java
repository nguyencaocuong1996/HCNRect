/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author WINDNCC
 */
public class CString {
    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }
    public static String floatToString(float f){
        return String.format("%.0f", f);
    }
    public static String toMoney(float f){
        String s = String.format("%.0f", f);
        s = new StringBuilder(s).reverse().toString();
        char[] charS = s.toCharArray();
        String newS = "";
        int count = 0;
        int len = 0;
        for (char c : charS) {
            count++;
            len++;
            newS += c;
            if(count == 3 && len != charS.length){
                count = 0;
                newS +=".";
            }
            
        }
        return (new StringBuilder(newS).reverse().toString()) + " VNĐ";
    }
    public static void main(String[] args) {
        float a = 120100.000001f;
        String ba = CString.toMoney(a);
        System.out.println(ba);
    }
}
