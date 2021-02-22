package wangyaxin_hutool;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;
import junit.framework.Assert;
/**
 * @show 类型转换
 * @author WZP
 *
 */
public class Text {
	public static void main(String[] args){
		//1.转换为字符串
		int a = 1;
		String aStr = Convert.toStr(a);

		long[] b = {1,2,3,4,5};
		String bStr = Convert.toStr(b);
		
		System.out.println(getType(aStr));

		System.out.println(getType(bStr));
		System.out.println("*******");
		
		
		//2.转换为指定类型数组
		String[] c = { "1", "2", "3", "4" };
		//结果为Integer数组
		Integer[] intArray = Convert.toIntArray(c);

		long[] d = {1,2,3,4,5};
		//结果为Integer数组
		Integer[] intArray2 = Convert.toIntArray(d);
		
		System.out.println(getType(intArray));
		
		System.out.println(getType(intArray2));
		System.out.println("*******");
		
		
		//3.转换为日期对象
		String e = "2017-05-06";
		Date value = Convert.toDate(e);
		System.out.println(value);
		System.out.println("*******");
		
		
		//4.转换为集合
		Object[] f = {"a", "你", "好", "", 1};
		List<?> list = Convert.toList(f);
		
		System.out.println(list);
		System.out.println("*******");
		
		
		//5.半角和全角转换
			//半角转全角
				String g = "123456789";
				//结果为："１２３４５６７８９"
				String sbc = Convert.toSBC(g);
				System.out.println(sbc);
			
			//全角转半角
				String h = "１２３４５６７８９";
		
				//结果为"123456789"
				String dbc = Convert.toDBC(h);
				System.out.println(dbc);
				System.out.println("*******");
				
				
		//6.16进制（Hex）
		
			//转为16进制（Hex）字符串
				String j = "新年快乐";
		
				//结果："e696b0e5b9b4e5bfabe4b990"
				String hex = Convert.toHex(j, CharsetUtil.CHARSET_UTF_8);
				System.out.println(hex);
		
			//将16进制（Hex）字符串转为普通字符串
				String ex = "e696b0e5b9b4e5bfabe4b990";
		
				//结果为："新年快乐"
				String raw = Convert.hexToStr(ex, CharsetUtil.CHARSET_UTF_8);
				System.out.println(raw);
				System.out.println("*******");
				
				
		//7.Unicode和字符串转换
				String k = "新年快乐";

				//结果为："\u65b0\u5e74\u5feb\u4e50"    
				String unicode = Convert.strToUnicode(k);
				System.out.println(unicode);
				//结果为："新年快乐"
				String aw = Convert.unicodeToStr(unicode);
				System.out.println(aw);
				System.out.println("*******");
				
				
		//8.编码转换
				String i = "新年快乐";
				//转换后result为乱码
				String result = Convert.convertCharset(i, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
				//转换后ra为中文
				String ra = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
				Assert.assertEquals(ra, i);
				System.out.println(result);
				System.out.println(ra);
				System.out.println("*******");
				
				
		//9.时间单位转换
				long l = 6666666;

				//结果为：111
				long minutes = Convert.convertTime(l, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
				System.out.println(minutes);
				System.out.println("*******");
				
				
		//10.金额大小写转换
				double m = 6666.66;

				//结果为："陆仟陆佰陆拾陆元陆角陆分"
				String money = Convert.digitToChinese(m);
				System.out.println(money);
	}
	
	
	public static String getType(Object o){ //获取变量类型方法

		return o.getClass().toString(); //使用int类型的getClass()方法

	}
}
