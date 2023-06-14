package iamquiz.model;

public class Player extends User{
    private int life = 5;
    private int time;
    private int correctQuestions;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions() {
        correctQuestions++;
    }

    @Override
    public void displayMode3Stats() {
        System.out.println("|\t" + super.toString() + "\n|\tCorrect Questions: " + correctQuestions);
    }
    @Override
    public String whoAmI() {
        return "I am type of: Player";
    }
}
