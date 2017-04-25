package com.epy0n0ff.channel.codec;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;
import org.jboss.netty.handler.codec.http.HttpMessage;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpDecoder extends HttpRequestDecoder {
    private static final Logger logger = LoggerFactory.getLogger(HttpDecoder.class);

    public HttpDecoder() {
        super();
        logger.info("HttpDecoder");
    }

    public HttpDecoder(int maxInitialLineLength, int maxHeaderSize, int maxChunkSize) {
        super(maxInitialLineLength, maxHeaderSize, maxChunkSize);
        logger.info("HttpDecoder(int,int,int)");
    }

    @Override
    protected HttpMessage createMessage(String[] initialLine) throws Exception {
        logger.info("createMessage");
        return super.createMessage(initialLine);
    }

    @Override
    protected boolean isDecodingRequest() {
        logger.info("isDecodingRequest");
        return super.isDecodingRequest();
    }

    @Override
    protected Object decode(
            ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer, State state)
            throws Exception {
        logger.info("decode(...)");
        return super.decode(ctx, channel, buffer, state);
    }

    @Override
    protected boolean isContentAlwaysEmpty(HttpMessage msg) {
        logger.info("isContentAlwaysEmpty");
        return super.isContentAlwaysEmpty(msg);
    }

    @Override
    protected ChannelBuffer internalBuffer() {
        logger.info("internalBuffer");
        return super.internalBuffer();
    }

    @Override
    protected void checkpoint() {
        logger.info("checkpoint");
        super.checkpoint();
    }

    @Override
    protected void checkpoint(State state) {
        logger.info("checkpoint");
        super.checkpoint(state);
    }

    @Override
    protected State getState() {
        logger.info("getState");
        return super.getState();
    }

    @Override
    protected State setState(State newState) {
        logger.info("setState");
        return super.setState(newState);
    }

    @Override
    protected Object decodeLast(
            ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer, State state)
            throws Exception {
        logger.info("decodeLast");
        return super.decodeLast(ctx, channel, buffer, state);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        logger.info("messageReceived");
        super.messageReceived(ctx, e);
    }

    @Override
    protected void cleanup(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        logger.info("cleanup");
        super.cleanup(ctx, e);
    }

    @Override
    protected ChannelBuffer appendToCumulation(ChannelBuffer input) {
        logger.info("appendToCumulation");
        return super.appendToCumulation(input);
    }

    @Override
    protected ChannelBuffer updateCumulation(ChannelHandlerContext ctx, ChannelBuffer input) {
        logger.info("updateCumulation");
        return super.updateCumulation(ctx, input);
    }

    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        logger.info("channelDisconnected");
        super.channelDisconnected(ctx, e);
    }

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        logger.info("channelClosed");
        super.channelClosed(ctx, e);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        logger.info("exceptionCaught");
        super.exceptionCaught(ctx, e);
    }

    @Override
    protected ChannelBuffer newCumulationBuffer(ChannelHandlerContext ctx, int minimumCapacity) {
        logger.info("newCumulationBuffer");
        return super.newCumulationBuffer(ctx, minimumCapacity);
    }

    @Override
    public void replace(String handlerName, ChannelHandler handler) {
        logger.info("replace");
        super.replace(handlerName, handler);
    }

    @Override
    protected int actualReadableBytes() {
        logger.info("actualReadableBytes");
        return super.actualReadableBytes();
    }

    @Override
    protected ChannelBuffer extractFrame(ChannelBuffer buffer, int index, int length) {
        logger.info("extractFrame");
        return super.extractFrame(buffer, index, length);
    }

    @Override
    public void beforeAdd(ChannelHandlerContext ctx) throws Exception {
        logger.info("beforeAdd");
        super.beforeAdd(ctx);
    }

    @Override
    public void afterAdd(ChannelHandlerContext ctx) throws Exception {
        logger.info("afterAdd");
        super.afterAdd(ctx);
    }

    @Override
    public void beforeRemove(ChannelHandlerContext ctx) throws Exception {
        logger.info("beforeRemove");
        super.beforeRemove(ctx);
    }

    @Override
    public void afterRemove(ChannelHandlerContext ctx) throws Exception {
        logger.info("afterRemove");
        super.afterRemove(ctx);
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
    public void channelUnbound(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        logger.info("channelUnbound");
        super.channelUnbound(ctx, e);
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
