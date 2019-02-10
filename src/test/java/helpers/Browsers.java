package helpers;

public enum Browsers {
    CHROME,
    FIREFOX,
    NONE;

    public static Browsers stringToEnum(String browser) {
        if (browser != null) {
            switch (browser) {
                case "chrome":
                case "Chrome":
                case "CHROME":
                    return Browsers.CHROME;
                case "firefox":
                case "Firefox":
                case "FIREFOX":
                    return Browsers.FIREFOX;
                default:
                    try {
                        throw new Exception("Invalid browser type!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
        try {
            throw new Exception("Browser not set");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Browsers.NONE;
    }
}
