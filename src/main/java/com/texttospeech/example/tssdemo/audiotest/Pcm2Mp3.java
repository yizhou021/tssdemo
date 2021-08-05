package com.texttospeech.example.tssdemo.audiotest;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;

public class Pcm2Mp3 {

    public void Wav2Mp3(String src, String output) throws EncoderException {
        File source = new File(src);
        File target = new File(output);
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(16000));
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(8000));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        encoder.encode(source, target, attrs);
        System.out.println("Finish convert!");
    }

    public static void main(String[] args) throws EncoderException {

        File source = new File("E:\\Java project\\tssdemo\\outputaudio\\target.wav");

//        System.out.println(source.length());
        File target = new File("E:\\Java project\\tssdemo\\outputaudio\\result_output.mp3");
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(16000));
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(8000));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        encoder.encode(source, target, attrs);
        System.out.println("Finish convert!");
    }
}
