package com.epy0n0ff.test.util;

import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;

public class ResponseUtil {
  public static void writeErrorResponse(
      String className, ChannelHandlerContext ctx, HttpResponseStatus status) {
    byte[] body = (className + ".exceptionCaught").getBytes();
    HttpResponse response = new DefaultHttpResponse(HTTP_1_1, status);
    response.headers().set(CONTENT_TYPE, "text/plain");
    HttpHeaders.setContentLength(response, body.length);
    ctx.getChannel().write(response);
    ctx.getChannel().write(ChannelBuffers.wrappedBuffer(body));
  }
}
