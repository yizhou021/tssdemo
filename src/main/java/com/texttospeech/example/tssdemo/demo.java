package com.texttospeech.example.tssdemo;

import com.iflytek.cloud.speech.*;
import com.texttospeech.example.tssdemo.audiotest.convertAudioFiles;
import it.sauronsoftware.jave.EncoderException;


public class demo {



    public static void main(String[] args) throws Exception {
        SpeechUtility.createUtility(SpeechConstant.APPID+"=5acc8a13");

        //1 创建SpeechSynthesizer 对象
        SpeechSynthesizer mTts = SpeechSynthesizer.createSynthesizer();

        //2.设置参数
        mTts.setParameter(SpeechConstant.VOICE_NAME,"vixf");
        mTts.setParameter(SpeechConstant.SPEED,"61");
        mTts.setParameter(SpeechConstant.VOLUME,"80");
        mTts.setParameter(SpeechConstant.BACKGROUND_SOUND,"0");

//        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH,"./outputaudio/result.pcm");

        SynthesizerListener listener = new SynthesizerListener() {
            @Override
            public void onBufferProgress(int i, int i1, int i2, String s) {

            }

            @Override
            public void onSpeakBegin() {

            }

            @Override
            public void onSpeakProgress(int i, int i1, int i2) {

            }

            @Override
            public void onSpeakPaused() {

            }

            @Override
            public void onSpeakResumed() {

            }

            @Override
            public void onCompleted(SpeechError speechError) {

            }

            @Override
            public void onEvent(int i, int i1, int i2, int i3, Object o, Object o1) {

            }
        };

        SynthesizeToUriListener uriListener = new SynthesizeToUriListener() {
            @Override
            public void onBufferProgress(int i) {

            }

            @Override
            public void onSynthesizeCompleted(String s, SpeechError speechError) {

            }

            @Override
            public void onEvent(int i, int i1, int i2, int i3, Object o, Object o1) {

            }
        };

        mTts.synthesizeToUri("提到禹王这个名字，不难想到大禹。禹王宫，是一座建在二王庙与玉垒关之间的清代古建筑，也是祭祀中国古代治水英雄大禹的庙宇。大禹是远古时期的神话人物。在四五千年前，大禹出生于都江堰西北的汶山郡，现在四川的北川县，大禹翻山越岭，淌河过川，拿着测仪工具，从西向东，一路测度地形的高低，树立标杆，规划水道。他的足迹遍布了中国十大河流：长江、珠江、黄河、黑龙江、松花江、雅鲁藏布江、澜沧江、怒江、汉江与辽河，他在中华民族治水历史上立下了不可磨灭的功劳。因为他曾经疏导岷江，造福了岷江流域的人民，为表达都江堰人民对他的敬意与怀念，于是有了这座禹王宫。其实李冰治水就借鉴过大禹治水所用的办法。都江堰申报世界文化遗产成功后，这里不只是祭祀大禹，还肩负研究大禹水利文化的作用。纪念大禹的遗迹其实遍布中国，对大禹的崇拜是水文化崇拜的一部分。","E:\\Javaproject\\tssdemo\\outputaudio\\result.pcm",uriListener);






//     mTts.startSpeaking("提到禹王这个名字，不难想到大禹。禹王宫，是一座建在二王庙与玉垒关之间的清代古建筑，也是祭祀中国古代治水英雄大禹的庙宇。大禹是远古时期的神话人物。在四五千年前，大禹出生于都江堰西北的汶山郡，现在四川的北川县，大禹翻山越岭，淌河过川，拿着测仪工具，从西向东，一路测度地形的高低，树立标杆，规划水道。他的足迹遍布了中国十大河流：长江、珠江、黄河、黑龙江、松花江、雅鲁藏布江、澜沧江、怒江、汉江与辽河，他在中华民族治水历史上立下了不可磨灭的功劳。因为他曾经疏导岷江，造福了岷江流域的人民，为表达都江堰人民对他的敬意与怀念，于是有了这座禹王宫。其实李冰治水就借鉴过大禹治水所用的办法。都江堰申报世界文化遗产成功后，这里不只是祭祀大禹，还肩负研究大禹水利文化的作用。纪念大禹的遗迹其实遍布中国，对大禹的崇拜是水文化崇拜的一部分。",listener);



    }


}
