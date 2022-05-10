package com.usermanagement.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UserIdRandomCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(createOrderNumber());
        //獲取四位隨機數
        System.out.println(getRandNum(4));
    }
    /**
     * 生成編號(由編號型別編碼+編號建立平臺編碼+6位日期+時間戳後4位+4位隨機陣列成)
     * @param numType 編號型別,1位(1-支付訂單,2-退款訂單)
     * @param platform 編號生成平臺,1位(1-PC平臺,2app平臺,3移動web平臺)
     * @return
     * @throws Exception
     */
    public static String createOrderNumber(){
        //格式化日期為"yymmdd"
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        StringBuffer buffer = new StringBuffer();
//        buffer.append(numType);
//        buffer.append(platform);
        buffer.append(format.format(date));
//        buffer.append((date.getTime() + "").substring(3));
        buffer.append(getRandNum(6));
        return buffer.toString();
    }
    /**
     * 獲取四位隨機數
     * @param leng  隨機數長度
     * @return
     */
    public static String getRandNum(int leng){
        Random random = new Random();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < leng; i++) {
            result.append(random.nextInt(10));
        }
        if(result.length()>0){
            return result.toString();
        }
        return null;
    }
}