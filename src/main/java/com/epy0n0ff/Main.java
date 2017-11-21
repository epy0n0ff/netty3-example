package com.epy0n0ff;

import com.epy0n0ff.channel.DownstreamHandler;
import com.epy0n0ff.channel.ServerHandler;
import com.epy0n0ff.channel.UpstreamHandler;
import com.epy0n0ff.channel.codec.CustomDecoder;
import com.epy0n0ff.channel.codec.CustomEncoder;
import com.epy0n0ff.channel.codec.HttpDecoder;
import com.epy0n0ff.channel.codec.HttpEncoder;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.execution.ExecutionHandler;
import org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor;
import org.jboss.netty.handler.timeout.ReadTimeoutHandler;
import org.jboss.netty.util.HashedWheelTimer;

public class Main {
  public static void main(String[] args) {
    ChannelFactory factory =
        new NioServerSocketChannelFactory(
            Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

    ServerBootstrap bootstrap = new ServerBootstrap(factory);
    bootstrap.setPipelineFactory(
        () -> {
          ChannelPipeline pipeline = Channels.pipeline();
          pipeline.addLast("CustomEncoder", new CustomEncoder());
          pipeline.addLast("readTimeout", new ReadTimeoutHandler(new HashedWheelTimer(),30));
          pipeline.addLast("httpRequestDecoder", new HttpDecoder());
          pipeline.addLast("UpstreamHandler", new UpstreamHandler());
          pipeline.addLast("httpResponseEncoder", new HttpEncoder());
          pipeline.addLast("DownstreamHandler", new DownstreamHandler());
          pipeline.addLast("CustomDecoder", new CustomDecoder());
          pipeline.addLast(
              "executionHandler",
              new ExecutionHandler(new OrderedMemoryAwareThreadPoolExecutor(8, 1048576, 1048576)));
          pipeline.addLast("serverHandler", new ServerHandler());

          return pipeline;
        });
    bootstrap.setOption("child.tcpNoDelay", true);
    bootstrap.setOption("child.keepAlive", true);
    bootstrap.setOption("reuseAddress", true);
    bootstrap.bind(new InetSocketAddress(8889));
  }
}
