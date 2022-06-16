package prg;

public class User {
        private String name;
        private int userNr;

        public User(String name, int userNr) {
            this.name = name;
            this.userNr = userNr;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserNr() {
        return userNr;
    }

    public void setUserNr(int userNr) {
        this.userNr = userNr;
    }
}
