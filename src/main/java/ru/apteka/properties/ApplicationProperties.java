package ru.apteka.properties;

public class ApplicationProperties {
    private volatile static ApplicationProperties instance = null;

    private boolean isOnboardingSeen = false;

    public void isLogin(boolean login) {
        isLogin = login;
    }

    public static String selectedDistrict = null;

    protected boolean isLogin = false;

    public static ApplicationProperties getInstance() {
        if (instance == null) {
            instance = new ApplicationProperties();
        }
        return instance;
    }

    public boolean isOnboardingSeen() {
        return isOnboardingSeen;
    }

    public static void setSelectedDistrict(String selectedDistrict) {
        ApplicationProperties.selectedDistrict = selectedDistrict;
    }

    public void setOnboardingSeen(boolean onboardingSeen) {
        isOnboardingSeen = onboardingSeen;
    }

}
