package com.sdsoon;

import com.sdsoon.nettyWs.WsStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChrNettyWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChrNettyWebsocketApplication.class, args);

        WsStarter.main(args);
    }

}
