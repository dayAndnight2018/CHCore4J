package com.chenghua.math;

import java.util.Objects;

public class Fraction {

    /**
     * 分子
     */
    private int numerator;
    /**
     * 分母
     */
    private int denominator;
    /**
     * 符号位
     */
    private byte symbol;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public Fraction(int numerator, int denominator) {
        this(numerator, denominator, FractionSymbolEnum.POSITIVE);
    }

    public Fraction(int numerator) {
        this(numerator, 1, FractionSymbolEnum.POSITIVE);
    }

    public Fraction(int numerator, int denominator, FractionSymbolEnum symbol) {
        if(denominator == 0){
            throw new ArithmeticException("denominator can not be zero");
        }
        if(numerator == 0){
            this.numerator = numerator;
            this.denominator = denominator;
            this.symbol = symbol.getCode();
            return;
        }
        int gcd = calGCD(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
        this.symbol = symbol.getCode();
    }

    public Fraction(int numerator, FractionSymbolEnum symbol) {
        this.numerator = numerator;
        this.denominator = 1;
        this.symbol = symbol.getCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numerator, this.denominator, this.symbol);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if(!(obj instanceof Fraction)){
            return false;
        }
        Fraction other = (Fraction) obj;
        return Objects.equals(this.numerator, other.numerator) && Objects.equals(this.denominator, other.denominator) &&
                Objects.equals(this.symbol, other.symbol);
    }

    @Override
    public String toString() {
        if(numerator % denominator == 0){
            if(numerator == 0){
                return "(" + 0 + ")";
            }
            return "(" + symbol * numerator / denominator + ")";
        }
        return "(" + symbol * numerator + "/" + denominator + ")";
    }

    /**
     * 加法
     * @param other
     * @return
     */
    public Fraction add(Fraction other){
        int denominator1 = this.getDenominator();
        int denominator2 = other.getDenominator();
        int lcm = calLCM(denominator1, denominator2);

        int result = lcm / denominator1 * this.getNumerator() * this.symbol +
                lcm / denominator2 * other.getNumerator() * other.symbol;
        FractionSymbolEnum symbol = result >= 0 ? FractionSymbolEnum.POSITIVE : FractionSymbolEnum.NEGATIVE;
        return new Fraction(Math.abs(result), lcm, symbol);
    }

    /**
     * 减法
     * @param other
     * @return
     */
    public Fraction minus(Fraction other){
        int denominator1 = this.getDenominator();
        int denominator2 = other.getDenominator();
        int lcm = calLCM(denominator1, denominator2);

        int result = lcm / denominator1 * this.getNumerator() * this.symbol -
                lcm / denominator2 * other.getNumerator() * other.symbol;
        FractionSymbolEnum symbol = result >= 0 ? FractionSymbolEnum.POSITIVE : FractionSymbolEnum.NEGATIVE;
        return new Fraction(Math.abs(result), lcm, symbol);
    }

    /**
     * 最小公倍数
     * @param a
     * @param b
     * @return
     */
    private int calLCM(int a, int b) {
        return a * b / calGCD(a, b);
    }

    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    private int calGCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min != 0) {
            return calGCD(min, max % min);
        } else
            return min;
    }

    public static void main(String[] args) {
        System.out.println(new Fraction(1, 1, FractionSymbolEnum.NEGATIVE).minus(new Fraction(1, 4, FractionSymbolEnum.POSITIVE)));
    }
}
