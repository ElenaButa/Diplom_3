package stellarburgers.testData;

public class GenerateUserData {
    public static String getRandomEmail() {
        return String.format("Bill%d", ((int) (Math.random() * (99999 - 11111) + 11111))) + "@yandex.ru";
    }
}