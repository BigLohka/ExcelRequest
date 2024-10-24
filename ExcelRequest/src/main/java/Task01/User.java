package Task01;

import java.util.Random;

public class User {
    static int id;
    private int uniqueNumber;
    private String nickname;
    private int score;
    private Random random = new Random();

    public User() {
        id++;
        uniqueNumber = id;
        createRandomNickname();
        createRandomScore();
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public int getScore() {
        return score;
    }

    private void createRandomNickname() {
        char[] variables = {'q', 'w', 'e', 'r', 't', 'y', '*', '$','1','2','6'};
        int lenght = random.nextInt(8, 12);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            sb.append(variables[random.nextInt(variables.length)]);
        }

        nickname = sb.toString();
    }

    private void createRandomScore() {
        score = random.nextInt(150000);
    }
}
