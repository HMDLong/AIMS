package hedspi.aims.utils;
import java.util.*;

public class MyDate {
    private int day;
    private int month;
    private int year;

    private static Hashtable<String, Integer> yearHash = new Hashtable<String, Integer>(){
        {
            put("twenty eighteen", 2018);
            put("twenty nineteen", 2019);
            put("twenty twenty", 2020);
            put("twenty twenty one", 2021);
            put("twenty twenty two", 2022);
        }
    };

    private static String[] date_name = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
            "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth",
            "twenty first", "twenty second", "twenty third", "twenty fourth", "twenty fifth", "twenty sixth", "twenty seventh", "twenty eighth", "twenty ninth", "thirtieth",
            "thirty first"};
    private static String[] month_name = {"january","february","march","april","may","june","july","august","september","october","december","november"};

    private int nameToInt(String str, String[] check_table) {
        for(int i = 0; i < check_table.length; i++)
            if(check_table[i] == str)
                return i+1;
        return 0;
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    //deprecated, do not use
    public MyDate(String day, String month, String year) {
        this.year = yearHash.get(year);
        this.month = nameToInt(month, month_name);
        this.day = nameToInt(day, date_name);
    }

    public MyDate() {
        super();
    }

    public void print() {
        switch(this.day%10) {
            case 1: System.out.println(month_name[this.month-1].substring(0, 3) + " " + this.day + "st " + this.year); break;
            case 2: System.out.println(month_name[this.month-1].substring(0, 3) + " " + this.day + "nd " + this.year); break;
            case 3: System.out.println(month_name[this.month-1].substring(0, 3) + " " + this.day + "rd " + this.year); break;
            default: System.out.println(month_name[this.month-1].substring(0, 3) + " " + this.day + "th " + this.year); break;
        }
    }

    public void print(String format) {
        switch(format) {
            case "yyyy-mm-dd": System.out.printf("%d-%02d-%02d\n", this.year, this.month, this.day); break;
            case "d/m/yyyy": System.out.printf("%d/%d/%d\n", this.day, this.month, this.year); break;
            case "dd-mmm-yyyy": System.out.printf("%02d-%s-%d\n", this.day, month_name[this.month-1].substring(0, 3), this.year); break;
            case "mmm d yyyy": System.out.printf("%s %d %d\n", month_name[this.month-1].substring(0, 3), this.day, this.year); break;
            case "mm-dd-yyyy": System.out.printf("%02d-%02-%d\n", this.month, this.day, this.year);break;
            default: System.out.println("Invalid format"); break;
        }
    }

}

