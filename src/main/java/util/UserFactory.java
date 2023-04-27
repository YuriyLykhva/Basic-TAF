package util;

public class UserFactory {

    public static User createUser() {
        return new User(TestDataReader.getTestData("testdata.user.email"),
                TestDataReader.getTestData("testdata.user.password"),
                TestDataReader.getTestData("testdata.user.name"));
    }
}
