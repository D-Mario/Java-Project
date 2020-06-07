package com.team.service;
/*
 * @Description: 自定义异常类
 * @author: Dario
 * @version:
 * @date: 2020/6/6 20:23
 * @param null
 * @return:
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -3387516993124229948L;

    public TeamException() {
        super();
    }
    public TeamException(String msg) {
        super(msg);
    }
}
