package com.jiezzzo.douyu.common;

/**
 * Created by oaier on 2017/4/20.
 */

public class Constant {
    /**
     * 隐藏构造器.
     */
    private Constant() {

    }

    /**
     * 基本URL.
     */
    public static final String BASE_URL = "";

    /**
     * 缓存大小为10 MB.
     */
    public static final int CACHE_SIZE = 10 * 1024 * 1024;

    /**
     * 连接超时时间.
     */
    public static final int CONNECT_TIME_OUT = 60 * 1000;

    /**
     * 读取超时时间.
     */
    public static final int READ_TIME_OUT = 60 * 1000;

    /**
     * 两秒延时.
     */
    public static final int TIME_DELAY = 2000;

    /**
     * 延时提示信息.
     */
    public static final String TIME_DELAY_STRING = "再按一次退出程序";

    /**
     * 网络状态
     */
    public static final int NETWORK_STATE = 202;

    public static final String USER_INFORMATION = "UserInformation";
}
