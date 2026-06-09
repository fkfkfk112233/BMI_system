package com;

public class BMI_controller {

    public double calcBMI(double height, double weight) {

        height = height / 100;

        return weight / (height * height);

    }
    
    public String getResult(double bmi) {

        if(bmi < 18.5) {

            return "過輕";

        }
        else if(bmi < 24) {

            return "正常";

        }
        else if(bmi < 27) {

            return "過重";

        }
        else {

            return "肥胖";

        }
    }
}