package com.company.M2ChallengeCortinaKevin.models;

import java.util.Objects;

public class MathSolution {
    private static int operand1;

    private static int operand2;
    private int answer;
    private String operation;

    public MathSolution() {

    }

    public MathSolution(int operand1, int operand2, int answer, String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.answer = answer;
        this.operation = operation;
    }

    public static int addition() {
        int a = MathSolution.operand1;
        int b = MathSolution.operand2;
        return a + b;
    }

    public static int subtraction() {
        int a = MathSolution.operand1;
        int b = MathSolution.operand2;
        return a - b;
    }

    public static int division() {
        int a = MathSolution.operand1;
        int b = MathSolution.operand2;
        return a/b;
    }

    public static int multiplication() {
        int a = MathSolution.operand1;
        int b = MathSolution.operand2;
        return a * b;
    }

    public static boolean operand2() {
        return false;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2(int i) {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution that = (MathSolution) o;
        return operand1 == that.operand1 && operand2 == that.operand2 && answer == that.answer && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, answer, operation);
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", answer=" + answer +
                ", operation='" + operation + '\'' +
                '}';
    }
}

