package com.epy0n0ff.channel;

import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.*;
import static org.jboss.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.Map;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler extends SimpleChannelHandler {
  private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
    logger.info("exceptionCaught");
    super.exceptionCaught(ctx, e);
  }

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    logger.info("messageReceived");

    HttpRequest request = (HttpRequest) e.getMessage();
    StringBuilder buf = new StringBuilder();
    buf.setLength(0);
    buf.append("requestUri: ").append(request.getUri()).append("\r\n\r\n");

    for (Map.Entry<String, String> h : request.headers()) {
      buf.append("requestHeader: ")
          .append(h.getKey())
          .append(" = ")
          .append(h.getValue())
          .append("\r\n");
    }
    buf.append("\r\n");

    ChannelBuffer content = request.getContent();
    if (content.readable()) {
      buf.append("requestContent: ").append(content.toString(CharsetUtil.UTF_8)).append("\r\n");
    }

    boolean keepAlive = isKeepAlive(request);

    HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
    response.setContent(ChannelBuffers.copiedBuffer(buf.toString(), CharsetUtil.UTF_8));
    response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");

    if (keepAlive) {
      response.headers().set(CONTENT_LENGTH, response.getContent().readableBytes());
      response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
    }

    ChannelFuture future = e.getChannel().write(response);

    if (!keepAlive) {
      future.addListener(ChannelFutureListener.CLOSE);
    }
  }

  @Override
  public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
    logger.info("handleUpstream");
    super.handleUpstream(ctx, e);
  }

  @Override
  public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("channelOpen");
    super.channelOpen(ctx, e);
  }

  @Override
  public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("channelBound");
    super.channelBound(ctx, e);
  }

  @Override
  public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("channelConnected");
    super.channelConnected(ctx, e);
  }

  @Override
  public void channelInterestChanged(ChannelHandlerContext ctx, ChannelStateEvent e)
      throws Exception {
    logger.info("channelInterestChanged");
    super.channelInterestChanged(ctx, e);
  }

  @Override
  public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("channelDisconnected");
    super.channelDisconnected(ctx, e);
  }

  @Override
  public void channelUnbound(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("channelUnbound");
    super.channelUnbound(ctx, e);
  }

  @Override
  public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("channelClosed");
    super.channelClosed(ctx, e);
  }

  @Override
  public void writeComplete(ChannelHandlerContext ctx, WriteCompletionEvent e) throws Exception {
    logger.info("writeComplete");
    super.writeComplete(ctx, e);
  }

  @Override
  public void childChannelOpen(ChannelHandlerContext ctx, ChildChannelStateEvent e)
      throws Exception {
    logger.info("childChannelOpen");
    super.childChannelOpen(ctx, e);
  }

  @Override
  public void childChannelClosed(ChannelHandlerContext ctx, ChildChannelStateEvent e)
      throws Exception {
    logger.info("childChannelClosed");
    super.childChannelClosed(ctx, e);
  }

  @Override
  public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
    logger.info("handleDownstream");
    super.handleDownstream(ctx, e);
  }

  @Override
  public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    logger.info("writeRequested");
    super.writeRequested(ctx, e);
  }

  @Override
  public void bindRequested(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("bindRequested");
    super.bindRequested(ctx, e);
  }

  @Override
  public void connectRequested(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("connectRequested");
    super.connectRequested(ctx, e);
  }

  @Override
  public void setInterestOpsRequested(ChannelHandlerContext ctx, ChannelStateEvent e)
      throws Exception {
    logger.info("setInterestOpsRequested");
    super.setInterestOpsRequested(ctx, e);
  }

  @Override
  public void disconnectRequested(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("disconnectRequested");
    super.disconnectRequested(ctx, e);
  }

  @Override
  public void unbindRequested(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("unbindRequested");
    super.unbindRequested(ctx, e);
  }

  @Override
  public void closeRequested(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    logger.info("closeRequested");
    super.closeRequested(ctx, e);
  }
}
