package application;

import java.util.Random;

public class CorrectSound extends Sound {
    private Random random = new Random();

    public void playCorrectSound() {
        int result = random.nextInt(4) + 1;
        switch (result) {
            case 1:
                sound = "/sounds/correct1.mp3";
                playSoundEffect(sound);
                System.out.println(sound);
                break;
            case 2:
                sound = "/sounds/correct2.mp3";
                playSoundEffect(sound);
                System.out.println(sound);
                break;
            case 3:
                sound = "/sounds/correct3.mp3";
                playSoundEffect(sound);
                System.out.println(sound);
                break;
            case 4:
                sound = "/sounds/correct4.mp3";
                playSoundEffect(sound);
                System.out.println(sound);
                break;
            case 5:
                sound = "/sounds/correct5.mp3";
                playSoundEffect(sound);
                System.out.println(sound);
                break;
            default:
                System.out.println("null dung nha");
                break;
        }
    }
}