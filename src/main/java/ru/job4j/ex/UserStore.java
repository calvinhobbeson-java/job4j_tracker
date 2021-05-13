package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                result = user;
            }
        }
            if (result == null) {
                throw new UserNotFoundException("User not found");
            }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean valid = false;
        if (user.isValid() && user.getUsername().length() > 3) {
            valid = true;
        } else {
            throw new UserInvalidException("Invalid user name");
        }
        return valid;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Pe", true)
        };
        try {
            User user = findUser(users, "Pe");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}