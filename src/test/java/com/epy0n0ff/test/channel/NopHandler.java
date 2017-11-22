package com.epy0n0ff.test.channel;

import com.epy0n0ff.channel.ServerHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NopHandler extends ServerHandler {
  private static final Logger logger = LoggerFactory.getLogger(NopHandler.class);

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
    logger.info("exceptionCaught");
    logger.info("nop");
    super.exceptionCaught(ctx, e);
  }
}
