package com.betacom.objects;

import java.util.List;

public class GenericsResponse<T, U> {

	private Boolean rc;
	private U oher;
	List<T> data;
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "GenericsResponse [rc=" + rc + ", oher=" + oher + ", data=" + data + "]";
	}
	public Boolean getRc() {
		return rc;
	}
	public void setRc(Boolean rc) {
		this.rc = rc;
	}
	public U getOher() {
		return oher;
	}
	public void setOher(U oher) {
		this.oher = oher;
	}
	
}
