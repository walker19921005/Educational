package com.cjrj.edu.util;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;


/**
 * 公用java对象转化器.
 * 
 * @author liuqing
 *
 */
public class ConvertUtil {
	
	
	/**
	 * <p>把字符串转化为int，失败则返回默认值</p> . 
	 * @param: @param str 字符串
	 * @param: @param defalut 默认值
	 * @param: @return  转化后的int类型的值    
	 * @return: int      
	 * @throws
	 */
	public static int str2Int(String str, int defalut) {
		int d = defalut;
		try {
			d = Integer.parseInt(str);
		} catch (Exception e) {
			//BaseLogger.error("强行把"+str+"转为int出错", e);
			e.printStackTrace();
		}
		return d;
	}
	public static long str2Long(String str, long defalut) {
		long d = defalut;
		try {
			d = Long.parseLong(str);
		} catch (Exception e) {
			//BaseLogger.error("强行把"+str+"转为int出错", e);
			e.printStackTrace();
		}
		return d;
	}
	/**
	 * <p>把字符串转化为double，失败则返回默认值</p> . 
	 * @param: @param str 字符串
	 * @param: @param defalut 默认值
	 * @param: @return  转化后的doubled类型的值    
	 * @return: double      
	 * @throws
	 */
	public static double str2Double(String str, double defalut) {
		double d = defalut;
		try {
			d = Double.parseDouble(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * <p>把对象转json格式的字符串.</p>  
	 * 
	 * @param: @param b 待转json字符串的对象
	 * @param: @return  json字符串
	 * @return: String    
	 * @throws
	 */
	public static String toJsonString(Object b){
		try {
			 
			String jsonStr= JSON.toJSONString(b);
			return jsonStr;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	/**
     *  把字符串用spit分割后组成数组
     */
	public static List<String> stringToList(String args,String spit){
		List<String> list=new ArrayList<String>();
		String[] strs=args.split(spit);
		for(String str:strs){
			list.add(str);
		}
		return list;
	}
	/**
     *  把list中每一项用join分割后组成字符串
     */
    public static String listToString(List<String> stringList,String join){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(join);
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }
   
	/**
     * 将字符串型ip转成int型ip
     * @param strIp
     * @return
     */
    public static int ipToInt(String strIp){
        String[] ss = strIp.split("\\.");
        if(ss.length != 4){
            return 0;
        }
        byte[] bytes = new byte[ss.length];
        for(int i = 0; i < bytes.length; i++){
            bytes[i] = (byte) Integer.parseInt(ss[i]);
        }
        return byte2Int(bytes);
    }
    /**
     * 将int型ip转成String型ip
     * @param intIp
     * @return
     */
    public static String intToIp(Integer intIp){
        byte[] bytes = int2byte(intIp);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++){
            sb.append(bytes[i] & 0xFF);
            if(i < 3){
                sb.append(".");
            }
        }
        return sb.toString();
    }
    /**
     * 将int转为byte数组
     * @param i
     * @return
     */
    private static byte[] int2byte(int i) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (0xff & i);
        bytes[1] = (byte) ((0xff00 & i) >> 8);
        bytes[2] = (byte) ((0xff0000 & i) >> 16);
        bytes[3] = (byte) ((0xff000000 & i) >> 24);
        return bytes;
    }
    /**
     * 将byte数组转为int
     * @param intIp
     * @return
     */
    private static int byte2Int(byte[] bytes) {
        int n = bytes[0] & 0xFF;
        n |= ((bytes[1] << 8) & 0xFF00);
        n |= ((bytes[2] << 16) & 0xFF0000);
        n |= ((bytes[3] << 24) & 0xFF000000);
        return n;
    }
    public static String clobToString(Clob clob) {
    	try{
	    	String reString = "";
	    	Reader is = clob.getCharacterStream();// 得到流
	    	BufferedReader br = new BufferedReader(is);
	    	String s = br.readLine();
	    	StringBuffer sb = new StringBuffer();
	    	while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
	    	sb.append(s);
	    	sb.append("\n");
	    	s = br.readLine();
	    	}
	    	reString = sb.toString();
	    	is.close();
	    	return reString;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
 
 
	
}
