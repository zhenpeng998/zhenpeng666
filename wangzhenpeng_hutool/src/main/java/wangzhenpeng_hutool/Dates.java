package wangyaxin_hutool;


import java.util.Calendar;
import java.util.Date;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.log.level.Level;

/**
 * @show 时间工具
 * @author WZP
 *
 */
public class Dates {
	public static void main(String[] args){
		//8.计时器
		TimeInterval timer = DateUtil.timer();
		
		
		//1.Date、long、Calendar之间的相互转换
			//当前时间
				Date date = DateUtil.date();
				System.out.println(date);
			//当前时间
				Date date2 = DateUtil.date(Calendar.getInstance());
				System.out.println(date2);
			//当前时间
				Date date3 = DateUtil.date(System.currentTimeMillis());
				System.out.println(date3);
			//当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
				String now = DateUtil.now();
				System.out.println(now);
			//当前日期字符串，格式：yyyy-MM-dd
				String today= DateUtil.today();
				System.out.println(today);
				System.out.println("*******");
				
				
		//2.字符串转日期
			String dateStr = "2020-03-24";
			Date a = DateUtil.parse(dateStr);
			System.out.println(a);
			//自定义日期格式转换
			String dateStr2 = "2020-03-24";
			Date b = DateUtil.parse(dateStr2, "yyyy-MM-dd");
			System.out.println(b);
		
			System.out.println("*******");
			
			
		//3.格式化日期输出
			String dat= "2021-03-24";
			Date date5 = DateUtil.parse(dat);
			//结果yyyy/MM/dd
			String format = DateUtil.format(date5, "yyyy/MM/dd");
			System.out.println(format);
			//常用格式的格式化，结果：yyyy/MM/dd
			String formatDate = DateUtil.formatDate(date5);
			System.out.println(formatDate);
			//结果：yyyy/MM/dd 00:00:00
			String formatDateTime = DateUtil.formatDateTime(date5);
			System.out.println(formatDateTime);
			//结果：00:00:00
			String formatTime = DateUtil.formatTime(date5);
			System.out.println(formatTime);
			System.out.println("*******");	
			
			
		//4.获取Date对象的某个部分
			Date d = DateUtil.date();
			System.out.println(d);
			//获得年的部分
			System.out.println(DateUtil.year(d));
			//获得月份，从0开始计数
			System.out.println(DateUtil.month(d));
			//获得月份枚举
			System.out.println(DateUtil.monthEnum(d));
			System.out.println("*******");
			
			
		//5.开始和结束时间
			String da = "2021-03-24 22:33:23";
			Date e = DateUtil.parse(da);
			//一天的开始，结果：yyyy/MM/dd 00:00:00
			Date beginOfDay = DateUtil.beginOfDay(e);
			System.out.println(beginOfDay);
			//一天的结束，结果：yyyy/MM/dd 23:59:59
			Date endOfDay = DateUtil.endOfDay(e);
			System.out.println(endOfDay);
			System.out.println("*******");
			
			
		//6.日期时间偏移
			String f = "2021-03-24 22:33:23";
			Date g = DateUtil.parse(f);

			//结果：2021-03-24 22:33:23
			Date newDate = DateUtil.offset(g, DateField.DAY_OF_MONTH, 2);
			System.out.println(newDate);
			//常用偏移，结果：2021-03-24 22:33:23
			DateTime newDate2 = DateUtil.offsetDay(g, 3);
			System.out.println(newDate2);
			//常用偏移，结果：2021-03-24 19:33:23
			DateTime newDate3 = DateUtil.offsetHour(g, -3);
			System.out.println(newDate3);
			System.out.println("....");
			//针对当前时间，提供了简化的偏移方法（例如昨天、上周、上个月等）
				//昨天
				System.out.println(DateUtil.yesterday());
				//明天
				System.out.println(DateUtil.tomorrow());
				//上周
				System.out.println(DateUtil.lastWeek());
				//下周
				System.out.println(DateUtil.nextWeek());
				//上个月
				System.out.println(DateUtil.lastMonth());
				//下个月
				System.out.println(DateUtil.nextMonth());
				System.out.println("*******");
				
				
		//7.日期时间差
			String dateStr1 = "2021-02-28 22:33:23";
			Date date1 = DateUtil.parse(dateStr1);

			String dateStr3 = "2021-03-24 23:33:23";
			Date date4 = DateUtil.parse(dateStr3);

			//相差24天
			long betweenDay = DateUtil.between(date1, date4, DateUnit.DAY);
			System.out.println(betweenDay);
			System.out.println("*******");
			
			
		//8.计时器
			//TimeInterval timer = DateUtil.timer();

			//---------------------------------
			//-------这是执行过程
			//---------------------------------

			long interval = timer.interval();//花费毫秒数
			long intervalRestart = timer.intervalRestart();//返回花费时间，并重置开始时间
			long intervalMinute = timer.intervalMinute();//花费分钟数
			
			System.out.println("花费毫秒数:"+interval);
			System.out.println("返回花费时间:"+intervalRestart);
			System.out.println("花费分钟数:"+intervalMinute);
			System.out.println("*******");
			
		//9.星座和属相
			// "白羊座"
			String zodiac = DateUtil.getZodiac(Month.MARCH.getValue(), 24);
			System.out.println("我的星座是："+zodiac);
			// "蛇"
			String chineseZodiac = DateUtil.getChineseZodiac(2001);
			System.out.println(chineseZodiac);
			System.out.println("*******");
			
			
		//10.年龄和闰年
			//年龄
			int h=DateUtil.ageOfNow("2001-03-24");
			System.out.println(h);
			//闰年
			System.out.println(DateUtil.isLeapYear(2001));
			System.out.println("*******");
	}
}
