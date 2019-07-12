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
//		ҳ�洫��������String�ַ�������Ҫ�ĳ�pojo�����ڵ�����java.util.Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
//			ת���ɹ��ͷ���
			return dateFormat.parse(source);
		} catch (ParseException e) {
		}
//		���ɹ��ͷ��ؿ�
		return null;
	}

}
