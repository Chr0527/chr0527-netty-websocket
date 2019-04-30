package com.sdsoon.nettyWs;


import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created By Chr on 2019/4/26.
 */
public class NettyConfig {
    /**
     * 储存每一个客户端接入进来时的channel对象
     */
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    /**
     * 服务器端口号
     */
    public static final int port = 8888;
    /**
     * WebSocket地址
     */
    public static final String WEB_SOCKET_URL = "ws://localhost:" + port + "/websocket";
}
