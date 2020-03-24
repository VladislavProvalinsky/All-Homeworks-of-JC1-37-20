package edu.academy.visibility.Enum;

import java.util.Arrays;

public enum Day {
        MONDAY(true), TUESDAY(true), WEDNERSDAY(true),
    THIRSDAY(true), FRIDAY(true), SUNDAY(false), SATURDAY(false);

        private boolean isWorkingDay;

        Day (boolean isWorkingDay) {
            this.isWorkingDay = isWorkingDay;
        }
        public boolean isWorkingDay(){
            return isWorkingDay;
        }

        public static Day valueOfIgnoreCase (String name){
            return valueOf(name.toUpperCase());
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(Day.values()));
        }
    }

