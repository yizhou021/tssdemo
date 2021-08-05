package com.texttospeech.example.tssdemo;

import com.texttospeech.example.tssdemo.TransApi;
public class TransDemo {
    private static final String APP_ID = "20160607000022919";
    private static final String SECURITY_KEY = "666LECAoOcuiIv7xZe70";

    public static void main(String[] args) {
        TransApi api = new TransApi("20160607000022919", "666LECAoOcuiIv7xZe70");
        String query = "着中国人的世界观和人生观。道耀乾坤，道教对现代人类生活具有积极的现实意义。道教推崇“自然无为”、 “无为而治”、“兼容并包 ”、“以人为本”、“天人合一”等理念对现代人调适自己的心态、端正自己的行为，现代社会管理，关注生命，重视人与自然的和谐相处，树立适度消费的观念，杜绝“竭泽而渔”的开发，坚持可持续发展观都具有十分重要的意义。";
        String result = api.getTransResult(query, "auto", "en");
        String clear_result = result.split(":")[result.split(":").length-1].replaceAll("}]}","").replaceAll("\\\\","");
        System.out.println(clear_result);
    }
}
