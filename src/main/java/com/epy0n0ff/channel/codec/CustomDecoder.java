package com.epy0n0ff.channel.codec;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.DefaultWriteCompletionEvent;
import org.jboss.netty.channel.DownstreamMessageEvent;
import org.jboss.netty.channel.UpstreamChannelStateEvent;
import org.jboss.netty.channel.UpstreamMessageEvent;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomDecoder extends OneToOneDecoder {

  private static final Logger logger = LoggerFactory.getLogger(CustomDecoder.class);

  @Override
  protected Object decode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
    logger.info("decode");

    throw new IllegalAccessException("aaaaaa");
//    if (ctx.canHandleDownstream()) {
//      ctx.sendUpstream(new DownstreamMessageEvent(channel,channel.getCloseFuture(),new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK),channel.getRemoteAddress()));
//      ctx.getChannel().write(new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK));
//    }

//    if (ctx.canHandleUpstream()) {
//      ctx.sendUpstream(new UpstreamMessageEvent(channel,new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK),channel.getRemoteAddress()));
//      ctx.getChannel().write(new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK));
//    }
//    return null;
  }
}
