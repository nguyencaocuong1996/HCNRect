/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Calendar;

/**
 *
 * @author WINDNCC
 */
public class CDateTime {
    public static CDateTime instance;
    public CDateTime.Date date = new Date();
    public CDateTime.Time time = new Time();
   
    public CDateTime() {
        date.d = Calendar.getInstance().get(Calendar.DATE);
        date.m = Calendar.getInstance().get(Calendar.MONTH) + 1;
        date.y = Calendar.getInstance().get(Calendar.YEAR);
        time.h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        time.m = Calendar.getInstance().get(Calendar.MINUTE);
        time.s = Calendar.getInstance().get(Calendar.SECOND);
        
    }
    
    public CDateTime(CDateTime.Date date, CDateTime.Time time) {
        this.date = date;
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }
    
    public static CDateTime getInstance() {
        if (instance == null) {
            instance = new CDateTime();
        }
        return instance;
    }

    @Override
    public String toString() {
        return date.toString() + " " + time.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(CDateTime.getInstance().toString());
    }
    
    public class Date{
        protected int y;
        protected int m;
        protected int d;
        public Date() {
        }
        Date(CDateTime.Date date){
            this.y = date.y;
            this.m = date.m;
            this.d = date.d;
        }
        Date(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }
        public String toDMY(){
            return d + "/" + m + "/" +y;
        }
        @Override
        public String toString() {
            String sm;
            String sd;
            if(m<10) sm = "0" + m; else sm = m+"";
            if(d<10) sd = "0" + d; else sd = d+"";
            return y+"-"+sm+"-"+sd;
        }
        
    }
    
    public class Time{
        protected int h;
        protected int m;
        protected int s;
        public Time() {
        }

        public Time(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
        }
        public Time(CDateTime.Time time){
            this.h = time.h;
            this.m = time.m;
            this.s = time.s;
        }
        
        @Override
        public String toString() {
            return h+":"+m+":"+s;
        }
        
        
    }
    
}
