package com.wp.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: wp
 * @Title: SmsListener
 * @Description: TODO
 * @date 2019/12/24 19:44
 */
@RabbitListener(id = "sms",queues = "register",group = "sms")
@Slf4j
@Component
public class SmsListener {


    @RabbitHandler
    public void sendSms( Map<String,String> map){
        String tele = map.get( "tele" );
        String code = map.get( "code" );
        log.info( "tel:"+tele+",code:"+code+" ........" );


    }
}
