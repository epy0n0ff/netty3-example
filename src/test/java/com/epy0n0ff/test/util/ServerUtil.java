package com.epy0n0ff.test.util;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class ServerUtil {
  public static class NamedChannelHandler {

    private final String name;
    private final ChannelHandler channelHandler;

    public NamedChannelHandler(String name, ChannelHandler handler) {
      this.name = name;
      this.channelHandler = handler;
    }

    String name() {
      return name;
    }

    ChannelHandler channelHandler() {
      return channelHandler;
    }
  }

  public static ServerBootstrap bindTestServerBootstrap(
      List<NamedChannelHandler> handlerList, int port) {
    ChannelFactory factory =
        new NioServerSocketChannelFactory(
            Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

    ServerBootstrap bootstrap = new ServerBootstrap(factory);
    bootstrap.setPipelineFactory(
        () -> {
          ChannelPipeline pipeline = Channels.pipeline();
          for (NamedChannelHandler handler : handlerList) {
            pipeline.addLast(handler.name(), handler.channelHandler());
          }
          return pipeline;
        });
    bootstrap.setOption("child.tcpNoDelay", true);
    bootstrap.setOption("child.keepAlive", true);
    bootstrap.setOption("reuseAddress", true);
    bootstrap.bind(new InetSocketAddress(port));
    return bootstrap;
  }
}
