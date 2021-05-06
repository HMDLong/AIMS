package hedspi.aims.utils;

import java.util.Arrays;

public class DateUtil {
    private static double hashDate(MyDate date) {
        return date.getDay()*0.1 + date.getMonth() + date.getYear()*10;
    }

    public static int cmpDate(MyDate day1, MyDate day2) {
        double hashVal1 = hashDate(day1);
        double hashVal2 = hashDate(day2);
        if(hashVal1>hashVal2) return 1;			   // return 1 if day1>day2
        else if(hashVal1 == hashVal2) return 0;    //        0 if day1=day2
        return -1;								   //       -1 if day1<day2
    }

    private static void swap(MyDate date1, MyDate date2) {
        MyDate temp = new MyDate();
        //temp = date1
        temp.setDay(date1.getDay());
        temp.setMonth(date1.getMonth());
        temp.setYear(date1.getYear());
        //date1 = date2
        date1.setDay(date2.getDay());
        date1.setMonth(date2.getMonth());
        date1.setYear(date2.getYear());
        //date2 = temp
        date2.setDay(temp.getDay());
        date2.setMonth(temp.getMonth());
        date2.setYear(temp.getYear());
    }

    public static void sortDate(MyDate[] dateList) {
        //bubble sort
        for(int i = 0; i < dateList.length; i++)
            for(int j = 0; j < dateList.length-i-1; j++)
                if(cmpDate(dateList[j], dateList[j+1]) == 1)
                    swap(dateList[j], dateList[j+1]);
    }

    public static MyDate getCurrentDate() {
        MyDate currentDate = new MyDate();
        currentDate.setYear(java.time.LocalDate.now().getYear());
        currentDate.setMonth(java.time.LocalDate.now().getMonth().getValue());
        currentDate.setDay(java.time.LocalDate.now().getDayOfMonth());
        return currentDate;
    }
}

