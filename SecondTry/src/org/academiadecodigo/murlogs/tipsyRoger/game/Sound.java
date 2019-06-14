package org.academiadecodigo.murlogs.tipsyRoger.game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {

    private Clip clip;
    private URL soundURL;


    public Sound(String path) {
        initClip(path);
    }

    public void play(boolean fromStart) {
        if (fromStart) {
            clip.setFramePosition(0);
        }

        clip.start();
    }

    public void stop() {
        clip.stop();
    }


    public int getLength() {
        return clip.getFrameLength();
    }

    public void loopIndef() {
        clip.setLoopPoints(0, (int) (getLength() * 0.94)); //sets loop points at start and end of track
        clip.loop(Clip.LOOP_CONTINUOUSLY); //activates loop
    }

    private void initClip(String path) {
        soundURL = Sound.class.getResource(path); //if loading from jar
        AudioInputStream inputStream;

        try {
            if (soundURL == null) {
                path = path.substring(1);
                File file = new File(path);
                soundURL = file.toURI().toURL(); //if executing on intelliJ
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(inputStream);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
