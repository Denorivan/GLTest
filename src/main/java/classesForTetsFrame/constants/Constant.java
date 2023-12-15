package classesForTetsFrame.constants;

public class Constant {
    public static class TimeOutVariable{
        public static final int IMPLICIT_WAIT = 1;
        public static final int EXPLICIT_WAIT = 2;
    }

    public static class UrlVariable{
        public static final String MAIN_PAGE = "https://demowebshop.tricentis.com/";
        public static final String INVENTORY_PAGE = "https://www.saucedemo.com/inventory.html";

    }

    public static class UserVariableForLogin{
        public static final  String enterStandardUsername = "standard_user";
        public static final  String enterLockedOutUsername = "locked_out_user";
        public static final  String enterProblemUsername = "problem_user";
        public static final  String enterPerformanceGlitchUser = "performance_glitch_user";
    }

    public static class passwordVariableToLoginUsers{
        public static final String passwordForAllUsers= "secret_sauce";
    }
}
