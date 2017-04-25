package com.epy0n0ff.channel.codec;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.HttpMessage;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpEncoder extends HttpResponseEncoder {
    private static final Logger logger = LoggerFactory.getLogger(HttpEncoder.class);

    public HttpEncoder() {
        super();
        logger.info("HttpEncoder");
    }

    @Override
    protected void encodeInitialLine(ChannelBuffer buf, HttpMessage message) throws Exception {
        logger.info("encodeInitialLine");
        super.encodeInitialLine(buf, message);
    }

    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel channel, Object msg)
            throws Exception {
        logger.info("encode");
        return super.encode(ctx, channel, msg);
    }

    @Override
    public void handleDownstream(ChannelHandlerContext ctx, ChannelEvent evt) throws Exception {
        logger.info("handleDownstream");
        super.handleDownstream(ctx, evt);
    }

    @Override
    protected boolean doEncode(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        logger.info("doEncode");
        return super.doEncode(ctx, e);
    }
}
