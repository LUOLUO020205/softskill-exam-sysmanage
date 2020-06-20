package com.softskill.exam.domain;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页实体
 * @classname PageModel
 * @description TODO
 * @author zephyr
 * @createtime 2016年10月21日 上午10:30:53
 */
@SuppressWarnings("rawtypes")
public class PageModel {

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	public static int PAGE_INDEX_DEFAULT = 1;// 默认第一页
	public static int PAGE_SIZE_DEFAULT = 20;// 默认每页显示条数

	// 总记录数
	private long recordCount;
	// 第几页
	private int pageIndex = PAGE_INDEX_DEFAULT;
	// 总页数
	private int totalPageCount;
	// 每页显示条数
	private int pageSize = PAGE_SIZE_DEFAULT;
	// 记录列表
	private List items;
	
	private JSONObject jsonObject;
	
	public PageModel(){
		super();
	}
	
	public PageModel(long recordCount, int pageIndex, int pageSize, List items) {
		this.items = items!=null?items:new ArrayList<Object>();
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		if (recordCount > 0) {
			this.pageIndex = pageIndex;
			// 计算总页数
			int tmp = (int) recordCount / pageSize;
			this.totalPageCount = (recordCount % pageSize == 0) ? tmp : (tmp + 1);
		}else{
			this.pageIndex = 0;
		}
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageIndex() {
		this.pageIndex = pageIndex <= 1 ? 1 : pageIndex;
		return this.pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalPageCount() {
		if (recordCount > 0) {
			// 计算总页数
			int tmp = (int) recordCount / pageSize;
			this.totalPageCount = (recordCount % pageSize == 0) ? tmp
					: (tmp + 1);
		}
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	
	/** 开始条数 */
	public int getStartRow(){
		/** 当前页码不能大于总页数 */
		int totalSize = (int) (this.getRecordCount() % this.getPageSize() != 0 
						? this.getRecordCount() / this.getPageSize() + 1 
						: this.getRecordCount () / this.getPageSize()); 
		this.pageIndex = this.pageIndex >= totalSize ? totalSize : this.getPageIndex();
		return (this.getPageIndex() - 1) * this.getPageSize();
	}

	/** 结束条数*/
	public int getEndRow(){
		return this.getPageIndex()*this.getPageSize();
	}

}
