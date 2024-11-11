package application;

public class DiceSound extends Sound {

    public void playDiceSound() {
        sound = "/sounds/dice.mp3";
        playSoundEffect(sound);
        System.out.println(sound);
    }
}