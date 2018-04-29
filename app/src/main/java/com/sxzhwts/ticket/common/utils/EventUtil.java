package com.sxzhwts.ticket.common.utils;

import org.greenrobot.eventbus.EventBus;

/**
 * 作者：fcy on 2018/4/13 16:56
 * EventBus 工具类
 */

public class EventUtil {
    /**
     * 注册
     * @param context
     */
    public static void register(Object context) {
        if (!EventBus.getDefault().isRegistered(context)) {
            EventBus.getDefault().register(context);
        }
    }

    /**
     * 解注册
     * @param context
     */
    public static void unregister(Object context) {
        if (EventBus.getDefault().isRegistered(context)) {
            EventBus.getDefault().unregister(context);
        }
    }

    /**
     * 发送事件
     * @param object
     */
    public static void sendEvent(Object object) {
        EventBus.getDefault().post(object);
    }
}
