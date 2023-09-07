package com.gmission.doc.common;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IDGenerator implements Serializable {
    static int nServerkey = 0;
    static String szDatestr = "";
    static String szHostName = "";

    public  static String generate() {
        int length = 3;
        return generate(length);
    }

    public synchronized static String generate(int length) {
        return "" + getDatetimestr() + getServerkey(length) + "_" + getHostname();		// 서버 was 2중화가 아닐때
        //return "" + getDatetimestr() + getServerkey(length);								// 웹 서버가 1대 이거나 2대이상이면서 클러스터링 된 상황일때
    }

    public static String getHostname() {
        if(szHostName.length()>0)
            return szHostName;
        else {
            try {
                Runtime rt = java.lang.Runtime.getRuntime();
                Process proc = rt.exec("hostname");

                int inp;

                while((inp = proc.getInputStream().read())!=-1) {
                    szHostName += (char)inp;
                }

                proc.waitFor();
            } catch (Exception e) {
                try {

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            szHostName = szHostName.trim();
            return szHostName;
        }
    }

    public static String getServerkey(int length) {
        if(szDatestr.equals(getDatestr())) {
            nServerkey = 1;
            szDatestr = getDatestr();
        } else if(Integer.toString(nServerkey).length() > length) {
            nServerkey = 1;
        } else {
            nServerkey++;
        }

        return "" + lpad(nServerkey, length);
    }

    public static String getDatestr() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");

        return df.format(now);
    }

    public static String getDatetimestr() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

        return df.format(now);
    }

    public static String lpad(int num, int size) {
        String f = "%0"+size+"d";
        return String.format(f, num);
     }
}