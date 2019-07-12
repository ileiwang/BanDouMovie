package xyz.leiwang.bandoumovie.converters;
/**
* @author Lei Wang
* @email ileiwang@live.com
* @blog ileiwang.cc
* @date 2019-07-09 10:41:53
*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String,Date >{
	
	@Override
	public Date convert(String source) {
//		页面传过来的是String字符串，需要改成pojo中日期的类型java.util.Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
//			转换成功就返回
			return dateFormat.parse(source);
		} catch (ParseException e) {
		}
//		不成功就返回空
		return null;
	}

}
