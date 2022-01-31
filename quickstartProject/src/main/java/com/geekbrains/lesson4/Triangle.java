package com.geekbrains.lesson4;

public class Triangle {
    //S=sqrt(p*(p-a)*(p-b)*(p-c)), p=(a+b+c)/2
    public static double calcTriangleArea(double a, double b, double c) throws Exception {
        if (a<=0 || b<=0 || c<=0) throw new Exception();
        double p = (a + b + c) / 2;

        if (p<=a || p<=b || p<=c) throw new Exception();

        double S = p*(p-a)*(p-b)*(p-c);
        return Math.sqrt(S);
    }
}
