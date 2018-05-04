package cn.htjx.common;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateDealwith {

	//获取系统当前时间(date)
    public static Date getCurrDate() {
        SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = std.parse(std.format(new Date()).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    //获取系统当前时间(string)
    public static String getCurrDateStr(){
        SimpleDateFormat std = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return std.format(new Date()).toString();
    }
    
    //获取系统当前年份
    public static String getCurrYear(){
        SimpleDateFormat std = new SimpleDateFormat("yyyy");
        return std.format(new Date()).toString();
    }
    
    //获取两时间差
    public static long getshijiancha(Date da)throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date now = df.parse(df.format(new Date()).toString());
        java.util.Date date = df.parse(df.format(da).toString());
        long l = now.getTime() - date.getTime();
        return l;
    }
    
	//生成唯一文件名
    public static String getSHC(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = sdf.format(date);
        return str;
    }
    
    public static void getNew(String path){
        File file = new File(path);
        //得到文件夹下的所有文件和文件夹
        String[] list = file.list();  
        if(list!=null && list.length>0){  
            for (String oldName : list) {  
                File oldFile = new File(path,oldName);  
                //判断出文件和文件夹
                if(!oldFile.isDirectory()){  
                    //文件则判断是不是要修改的
                    if(!oldName.contains(".jpg")){  
                        String newoldName = oldName +".jpg";
                        File newFile = new File(path,newoldName);
                        boolean flag = oldFile.renameTo(newFile);
                        System.out.println(flag);
                    }  
                }else{  
                    //文件夹则迭代
                    String newpath=path+"/"+oldName;  
                    getNew(newpath);  
                }  
            }  
        }  
    }  
    
    public static String getOsAndBrowserInfo(HttpServletRequest request){
    	String browserDetails = request.getHeader("User-Agent");
        String userAgent = browserDetails;
        String os = "";
        if(userAgent.toLowerCase().indexOf("windows") >= 0){
            os = "Windows";
        }else if(userAgent.toLowerCase().indexOf("android") >= 0){
            os = "Android";
        }else if(userAgent.toLowerCase().indexOf("iphone") >= 0){
            os = "IPhone";
        }else if(userAgent.toLowerCase().indexOf("mac") >= 0){
            os = "Mac";
        }else if(userAgent.toLowerCase().indexOf("x11") >= 0){
            os = "Unix";
        }else{
            os = "UnKnown, More-Info: "+userAgent;
        }
		return os;
    }
    
}
