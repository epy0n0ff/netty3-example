package com.epy0n0ff.channel;

import org.jboss.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownstreamHandler extends SimpleChannelDownstreamHandler {
    private static final Logger logger = LoggerFactory.getLogger(DownstreamHandler.class);

    public DownstreamHandler() {
        super();
        logger.info("DownstreamHandler");
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
    public void disconnectRequested(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
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
