package com.texttospeech.example.tssdemo.audiotest;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class convertAudioFiles {

    public void Pcm2Wav(String src, String target, short bit, short channel, short samplerate) throws Exception {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(target);

        //计算长度
        byte[] buf = new byte[1024 * 4];
        int size = fis.read(buf);
        int PCMSize = 0;
        while (size != -1) {
            PCMSize += size;
            size = fis.read(buf);
        }
        fis.close();
        //填入参数，比特率等等。这里用的是16位单声道 8000 hz
        WaveHeader header = new WaveHeader();
        //长度字段 = 内容的大小（PCMSize) + 头部字段的大小(不包括前面4字节的标识符RIFF以及fileLength本身的4字节)
        header.fileLength = PCMSize + (44 - 8);
        header.FmtHdrLeth = 16;
        header.BitsPerSample = bit;
        header.Channels = channel;
        header.FormatTag = 0x0001;
        header.SamplesPerSec = samplerate;
        header.BlockAlign = (short)(header.Channels * header.BitsPerSample / 8);
        header.AvgBytesPerSec = header.BlockAlign * header.SamplesPerSec;
        header.DataHdrLeth = PCMSize;

        byte[] h = header.getHeader();
        assert h.length == 44; //WAV标准，头部应该是44字节
        //write header
        fos.write(h, 0, h.length);
        //write data stream
        fis = new FileInputStream(src);
        size = fis.read(buf);
        while (size != -1) {
            fos.write(buf, 0, size);
            size = fis.read(buf);
        }
        fis.close();
        fos.close();
//        System.out.println("Convert OK!");
    }

    public void Wav2Mp3(String src, String output, int bitrate, int channel, int samplerate) throws EncoderException {
        File source = new File(src);
        File target = new File(output);
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(bitrate);
        audio.setChannels(channel);
        audio.setSamplingRate(samplerate);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        encoder.encode(source, target, attrs);
//        System.out.println("Finish convert!");
    }

    public static void main(String[] args) throws Exception {
        convertAudioFiles convertAudioFiles = new convertAudioFiles();
        System.out.println("Start Convert!");
        convertAudioFiles.Pcm2Wav("E:\\Javaproject\\tssdemo\\outputaudio\\result.pcm","E:\\Javaproject\\tssdemo\\outputaudio\\target3.wav",(short) 16,(short)2,(short)8000);
        System.out.println("Finish convert from PCM to WAV!");
        convertAudioFiles.Wav2Mp3("E:\\Javaproject\\tssdemo\\outputaudio\\target3.wav","E:\\Javaproject\\tssdemo\\outputaudio\\otuput3.mp3",16000,2,8000);
        System.out.println("Finish convert from WAV to MP3!");
    }

}
