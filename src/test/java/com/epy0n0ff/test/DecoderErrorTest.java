package com.epy0n0ff.test;

import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.epy0n0ff.channel.DownstreamHandler;
import com.epy0n0ff.channel.codec.HttpEncoder;
import com.epy0n0ff.test.channel.NopHandler;
import com.epy0n0ff.test.channel.UpHandler;
import com.epy0n0ff.test.channel.codec.RequestDecoder;
import com.epy0n0ff.test.util.ServerUtil;
import com.epy0n0ff.test.util.ServerUtil.NamedChannelHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecoderErrorTest {

  private static final int TEST_SERVER_PORT = 8889;

  @Test
  public void errorTest() throws IOException {
    List<NamedChannelHandler> handlers = new ArrayList<>();
    handlers.add(new NamedChannelHandler("testErrorDecoder", new ErrorDecoder()));
    handlers.add(new NamedChannelHandler("testRequestDecoder", new RequestDecoder()));
    handlers.add(new NamedChannelHandler("testUpstreamHandler", new UpHandler()));
    handlers.add(new NamedChannelHandler("httpResponseEncoder", new HttpEncoder()));
    handlers.add(new NamedChannelHandler("downstreamHandler", new DownstreamHandler()));
    handlers.add(new NamedChannelHandler("testNopHandler", new NopHandler()));

    ServerBootstrap bootstrap = ServerUtil.bindTestServerBootstrap(handlers, TEST_SERVER_PORT);
    CloseableHttpResponse response = doRequest();

    String body = IOUtils.toString(response.getEntity().getContent());
    assertThat(response.getStatusLine().getStatusCode(), is(HTTP_INTERNAL_ERROR));
    assertThat(body, is("RequestDecoder.exceptionCaught"));

    response.close();
    bootstrap.shutdown();
  }

  private static CloseableHttpResponse doRequest() throws IOException {
    return HttpClientBuilder.create()
        .build()
        .execute(new HttpGet("http://localhost:" + TEST_SERVER_PORT));
  }

  class ErrorDecoder extends OneToOneDecoder {

    private final Logger logger = LoggerFactory.getLogger(ErrorDecoder.class);

    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, Object msg)
        throws Exception {
      logger.info("decode");
      throw new IllegalAccessException();
    }
  }
}
