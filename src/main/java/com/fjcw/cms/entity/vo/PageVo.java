/*
 *	
 *	
 *	fjcw
 */

package com.fjcw.cms.entity.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

/**
 * 分页器
 * 
 * @author fjcw
 * 
 * @param <T>
 */
public class PageVo<T> {
	/**
	 * 页码
	 */
	private int pageNum;
	/**
	 * 页码总数
	 */
	private int pageCount;
	/**
	 * 总数
	 */
	private int count;
	/**
	 * 偏移
	 */
	private int offset;
	/**
	 * 数量
	 */
	private int rows;
	/**
	 * 数据
	 */
	private List<T> list;
	/**
	 * 页码HTML
	 */
	private String pageNumHtml;
	
	private String key=null;
	/**
	 * 参数
	 */
	private Map<String, String> args = new HashMap<String, String>();

	public PageVo(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageNum() {
		if (this.pageNum <= 0) {
			this.pageNum = 1;
			return 1;
		} else {
			return pageNum;
		}
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageCount() {
		this.pageCount = ((this.getCount() - 1) / this.getRows()) + 1;
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getOffset() {
		this.offset = (this.getPageNum() - 1) * this.getRows();
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getUrl(int num) {
		Iterator<Entry<String, String>> iter = this.getArgs().entrySet()
				.iterator();
		List<String> values = new ArrayList<String>();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			values.add(key + "=" + val);
		}
		values.add("p=" + num);
		return "?" + StringUtils.join(values.toArray(), "&");
	}

	public void setPageNumHtml(String pageNumHtml) {
		this.pageNumHtml = pageNumHtml;
	}

	public String getPageNumHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<div class=\"pages fs12 col46 lh30 text-center\" style=\"margin-top: 60px;\">");
		// 首页，上一页
		if (this.getPageNum() != 1) {
			sb.append("<a href='" + this.getUrl(0)
					+ "'class='pages-border' title='首页'>首页</a>");
			sb.append("<a href='" + this.getUrl(this.getPageNum() - 1)
					+ "'class='pages-border' title='上一页'>上一页</a>");
		}
		// 页码
		if (this.getPageCount() != 1) {
			int startNum = this.getPageNum() - 3 <= 1 ? 1
					: this.getPageNum() - 3;
			int endNum = this.getPageNum() + 3 >= this.getPageCount() ? this
					.getPageCount() : this.getPageNum() + 3;
			if (startNum > 1) {
				sb.append("<a href='javascript:void(0);'><span>· · ·</span></a>");
			}
			for (int i = startNum; i <= endNum; i++) {
				if (i == pageNum) {
					sb.append("<a   href='" + this.getUrl(i)
							+ "' class='pages-border active' title='" + i + "'>" + i
							+ "</a>");
				} else {
					sb.append("<a href='" + this.getUrl(i)
							+ "' class='pages-border' title='" + i + "'>" + i
							+ "</a>");
				}
			}
			if (endNum < this.getPageCount()) {
				sb.append("<a href='javascript:void(0);'>...</a>");
			}
		}
		// 下一页，尾页
		if (this.getPageNum() < this.getPageCount()) {
			sb.append("<a href='" + this.getUrl(this.getPageNum() + 1)
					+ "' class='pages-border' title='下一页'>下一页</a>");
			sb.append("<a href='" + this.getUrl(this.getPageCount())
					+ "' class='pages-border' title='末页'>末页</a>");
		}
		sb.append("&nbsp;共<span class=\"p\">"+this.getPageCount()+"</span>页，到第&nbsp;");
		sb.append("<input type=\"text\" maxlength=\"4\" class=\"pages-border\" id='pageNum'></input>&nbsp;页&nbsp;");
		sb.append("<a class=\"pages-border\" href=\"javascript:location.href='?p='+document.getElementById('pageNum').value");
		if(key!=null){
			
			sb.append("&key="+key);
		}
		sb.append("\">确定</a></div>");
		return sb.toString();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Map<String, String> getArgs() {
		return args;
	}

	public void setArgs(Map<String, String> args) {
		this.args = args;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
