package cn.htjx.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook; 

public class ExcelUtil<T> {
	
	public void exportExcel(String title,String[] headers,Collection<T> dataset,OutputStream out,String pattern) {  
		//声明一个工作薄
		SXSSFWorkbook workbook = new SXSSFWorkbook(1000);
		//生成一个表格
		SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet(title);
		//设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 15);
		//产生表格标题行
		SXSSFRow row = (SXSSFRow) sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			SXSSFCell cell = (SXSSFCell) row.createCell(i);
			cell.setCellValue(headers[i]);
        }
		//遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = (SXSSFRow) sheet.createRow(index);
			T t = (T) it.next();
			//利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (short i = 0; i < fields.length; i++) {
				SXSSFCell cell = (SXSSFCell) row.createCell(i);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get"+ fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
				try {
					Class<? extends Object> tclass = t.getClass();
					Method getMethod = tclass.getMethod(getMethodName,new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					String textValue = null;
					if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);
						row.setHeightInPoints(20);
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value!=null?value.toString():"";
						row.setHeightInPoints(20);
					}
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							cell.setCellValue(textValue);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			}
		}
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
