package net.line.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TNo {
	public String getTNo(){
		String tNo="";
		Date updateTime =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		tNo=sdf.format(updateTime);
		//System.out.println(tNo);
		return tNo;
	}
}
