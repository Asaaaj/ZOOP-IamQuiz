package iamquiz.model;

 public class QuizScreen {
    public final void displayBorder(){      //top border
        System.out.println("                               ___________");
        System.out.println("______________________________| " + Game.getGAMENAME() + " |______________________________");
        System.out.println("|                              ‾‾‾‾‾‾‾‾‾‾‾");
    }
    public final void displayBorderBottom(){        //bottom border
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }
}
