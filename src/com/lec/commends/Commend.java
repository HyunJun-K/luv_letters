package com.lec.commends;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Commend {
	void excute(HttpServletRequest request , HttpServletResponse response);
}
