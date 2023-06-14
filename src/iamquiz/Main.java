package iamquiz;

import iamquiz.controller.GameScreenControl;

public class Main {
    public static void main(String[] args) {
        GameScreenControl gameScreenControl = new GameScreenControl();
        while(true) {
            gameScreenControl.checkForScannedCharacter();
        }
    }
}