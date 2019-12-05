package helpers;

public enum BrowserName {
  CHROME("chrome"),
  FIREFOX("firefox"),
  HEADLESS("headless");

  private final String name;

  BrowserName(final String browserName) {
    this.name = browserName;
  }

  public String getName() {
    return this.name;
  }
}
