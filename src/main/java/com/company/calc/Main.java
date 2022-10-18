package com.company.calc;

import com.company.calc.parser.ParserOperation;

import java.text.DecimalFormat;
import java.util.Scanner;

//Принимает в себя выражения типа 1.1+2-3.4*4. Все операции идут по очереди. Не учитывается порядок выполения мат.операций
//На вход подается строка, на выходе получаем ответ в консоли в зависимости от типов чисел на входе. Если есть хоть одно
//число с плавющей запятой, то ответ будет вещественным числом.
public class Main {
    public static void main(String[] args) {
        final ParserOperation parserOperation = new ParserOperation();
        final Calculator calculator = new Calculator(parserOperation);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение типа А+B, A*B, A/B, A-B:");
        String ex = scanner.nextLine();
        System.out.println(calculator.calculate(ex));

    }
}
