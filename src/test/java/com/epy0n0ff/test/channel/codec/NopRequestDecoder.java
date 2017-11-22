package com.epy0n0ff.test.channel.codec;

import com.epy0n0ff.channel.codec.HttpDecoder;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NopRequestDecoder extends HttpDecoder {

  private static final Logger logger = LoggerFactory.getLogger(NopRequestDecoder.class);

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
    logger.info("exceptionCaught");
    logger.info("nop");
    super.exceptionCaught(ctx, e);
  }
}
