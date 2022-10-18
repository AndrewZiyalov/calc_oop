package com.company.calc.parser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserObjects {
    Pattern patternNum = Pattern.compile("([0-9]*[.,]?[0-9]+)");//шаблон числа
    Pattern patternSign = Pattern.compile("([+\\-/*])");//шаблон знака
    Pattern pattern = Pattern.compile("([0-9]*[.,]?[0-9]+)|([+\\-/*])|([^\\.+\\-/*\\d ])");//шаблон число или знак,или ошибочные символы
    Pattern patternErr = Pattern.compile("([^+\\-/*\\d\\., ])"); 

    public ArrayList<Object> parse(String ex) {
        ArrayList<Object> objects = new ArrayList<Object>();
        Matcher matcher = pattern.matcher(ex);
        while (matcher.find()) {
            String m = matcher.group();
            Matcher matcherNum = patternNum.matcher(m);
            Matcher matcherSign = patternSign.matcher(m);
            Matcher matcherErr = patternErr.matcher(m);
            if (matcherErr.find()){
                throw new RuntimeException("Не верные символы в выражении");
            } else if (matcherNum.find()) {
                objects.add(convertToNumber(matcherNum.group().replace(',','.')));
            } else if (matcherSign.find()) {
                objects.add(matcherSign.group());
            }
        }
        return objects;
    }

    private Number convertToNumber(String replace) {
        Number result;
        if (replace.contains(".")) {
            result = Double.valueOf(replace);
        } else {
            result = Integer.valueOf(replace);
        }
        return result;
    }
}
