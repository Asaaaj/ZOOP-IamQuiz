package iamquiz.model;

public abstract class User {
    public String name;

    public abstract void displayMode3Stats();

    public final void setName(String name) {
        this.name = name;
    }
    public final String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name.toUpperCase();
    }
    public String whoAmI(){
        return "I am type of: User";
    }
}

