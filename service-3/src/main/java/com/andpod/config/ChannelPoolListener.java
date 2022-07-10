package com.andpod.config;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.rabbitmq.connect.ChannelInitializer;
import jakarta.inject.Singleton;

import java.io.IOException;

@Singleton
public class ChannelPoolListener extends ChannelInitializer {

    @Override
    public void initialize(Channel channel) throws IOException {
        channel.exchangeDeclare("micronaut", BuiltinExchangeType.DIRECT, true);

        channel.queueDeclare("catalogue", true, false, false, null);
        channel.queueBind("catalogue", "micronaut", "books.catalogue");

        channel.queueDeclare("creation", true, false, false, null);
        channel.queueBind("creation", "micronaut", "books.creation");

    }
}
