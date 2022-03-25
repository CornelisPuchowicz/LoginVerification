package Kornel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

         User[] users = {
                new User("admin", "pass", "token"),
                new User("adam", "passw0rd", "token"),
                new User("romek", "qwerty", "token"),
                new User("aga", "razdwa", "token"),
                new User("pati", "pass", "token")
        };




         

        Scanner scanner = new Scanner(System.in);

        boolean authenticated = false;

        while (!authenticated) {

            System.out.println("Witaj, podaj nazwę użytkownika:");
            String username = scanner.nextLine();
            System.out.println("Podaj hasło:");
            String password = scanner.nextLine();

            for (int i = 0; i < users.length; i++) {
                User user = users[i];
                if (user.authenticate(username, password)) {
                    System.out.println("Witaj, " + username + "!");
                    authenticated = true;
                    break;
                }
            }
        }
    }
    static class User {



        public boolean authenticate(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }

        public boolean authenticate(String secret) {
            return this.secret.equals(secret) && !this.secret.equals(EMPTY_TOKEN);
        }

        public static final String EMPTY_TOKEN = "---";

        private String username;
        private String password;
        private String secret;

        public User(String username, String password, String secret) {
            this.username = username;
            this.password = password;
            this.secret = secret;
        }

        public User(String username, String password) {
            this(username, password, EMPTY_TOKEN);
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }
    }
}
