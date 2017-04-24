package com.epy0n0ff.channel;

import org.jboss.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownstreamHandler extends SimpleChannelDownstreamHandler {
    private static final Logger logger = LoggerFactory.getLogger(DownstreamHandler.class);

    @Override
    public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        logger.info("writeRequested");
        ctx.sendDownstream(e);
    }
}
