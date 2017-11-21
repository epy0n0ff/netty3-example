package com.epy0n0ff.channel;

import org.jboss.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpstreamHandler extends SimpleChannelUpstreamHandler {
  private static final Logger logger = LoggerFactory.getLogger(UpstreamHandler.class);

  public UpstreamHandler() {
    super();
    logger.info("UpstreamHandler");
  }

  @Override
  public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
    logger.info("handleUpstream");
    super.handleUpstream(ctx, e);
  }

  @Override
  public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
    logger.info("messageReceived");
    super.messageReceived(ctx, e);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
    logger.info("exceptionCaught");
    super.exceptionCaught(ctx, e);
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
}
