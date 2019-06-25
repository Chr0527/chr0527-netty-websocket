package com.sdsoon.nettyWs;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * netty的webSocket启动类:就是启动netty服务端,类似于启动服务
 * <p>
 * Created By Chr on 2019/4/26.
 */
public class WsStarter {
    //netty使用多线程
    public static void main(String[] args) {
        //核心调度线程
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //业务处理线程
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //发布服务
            ServerBootstrap b = new ServerBootstrap();
            //线程开始工作
            b.group(bossGroup, workGroup);
            //设为nio服务端模式
            b.channel(NioServerSocketChannel.class);
            //添加处理类
            b.childHandler(new MyWebSocketChannelHandler());
            System.err.println("服务端开启等待客户端连接...");
            //绑定ip
            Channel ch = b.bind(NettyConfig.port).sync().channel();
            ch.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //优雅的退出程序,节约资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

}
