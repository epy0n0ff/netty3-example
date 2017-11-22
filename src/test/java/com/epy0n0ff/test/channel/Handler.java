package com.epy0n0ff.test.channel;

import com.epy0n0ff.channel.ServerHandler;
import com.epy0n0ff.test.util.ResponseUtil;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Handler extends ServerHandler {
  private static final Logger logger = LoggerFactory.getLogger(Handler.class);

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
    logger.info("exceptionCaught");
    logger.info("write an error response");
    ResponseUtil.writeErrorResponse(
        this.getClass().getSimpleName(), ctx, HttpResponseStatus.INTERNAL_SERVER_ERROR);
  }
}
