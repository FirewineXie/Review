package com.study3.server;
/**
 * 服务器小脚本接口
 * 
 * @author Firewine
 *
 */
public interface Servlet {
	void service(Request request, Response response);
}
