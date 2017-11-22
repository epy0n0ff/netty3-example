package com.epy0n0ff.test.channel.codec;

import com.epy0n0ff.channel.codec.HttpDecoder;
import com.epy0n0ff.test.util.ResponseUtil;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestDecoder extends HttpDecoder {

  private static final Logger logger = LoggerFactory.getLogger(RequestDecoder.class);

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
    logger.info("exceptionCaught");
    logger.info("write an error response");
    ResponseUtil.writeErrorResponse(
        this.getClass().getSimpleName(), ctx, HttpResponseStatus.INTERNAL_SERVER_ERROR);
  }
}
