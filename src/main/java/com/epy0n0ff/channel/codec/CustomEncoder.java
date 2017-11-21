package com.epy0n0ff.channel.codec;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomEncoder extends OneToOneEncoder{
  private static final Logger logger = LoggerFactory.getLogger(CustomEncoder.class);

  @Override
  protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
    logger.info("encode");
    return msg;
  }
}
