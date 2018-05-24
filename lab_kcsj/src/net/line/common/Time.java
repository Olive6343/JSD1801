package net.line.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	public String getTime(){
		String time="";
		Date updateTime =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time=sdf.format(updateTime);
		//System.out.println(time);
		return time;
	}
}
