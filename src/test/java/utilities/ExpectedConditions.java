package utilities;
/*

        // 1. elementToBeClickable

        wait.until(ExpectedConditions.elementToBeClickable(clickButtonId));
        // Custom static method equivalent
        public static WebElement elementToBeClickable (WebDriver driver, By locator){
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            }
            return null;
        }
// Lambda equivalent
        wait.until(d -> {
            WebElement e = d.findElement(clickButtonId);
            return (e.isDisplayed() && e.isEnabled()) ? e : null;
        });

// 2. visibilityOfElementLocated
        wait.until(ExpectedConditions.visibilityOfElementLocated(textByXpath));
        // Custom static method equivalent
        public static WebElement visibilityOfElementLocated (WebDriver driver, By locator){
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed() && element.getSize().getHeight() > 0 && element.getSize().getWidth() > 0) {
                return element;
            }
            return null;
        }
// Lambda equivalent
        wait.until(d -> {
            WebElement e = d.findElement(textByXpath);
            return (e.isDisplayed() && e.getSize().getHeight() > 0 && e.getSize().getWidth() > 0) ? e : null;
        });

// 3. presenceOfElementLocated
        wait.until(ExpectedConditions.presenceOfElementLocated(someBy));
        // Custom static method
        public static WebElement presenceOfElementLocated (WebDriver driver, By locator){
            return driver.findElement(locator); // returns immediately if present in DOM
        }
// Lambda equivalent
        wait.until(d -> d.findElement(someBy));

// 4. invisibilityOfElementLocated
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBy));
        // Custom static method
        public static Boolean invisibilityOfElementLocated (WebDriver driver, By locator){
            try {
                WebElement e = driver.findElement(locator);
                return !e.isDisplayed();
            } catch (NoSuchElementException ex) {
                return true;
            }
        }
// Lambda equivalent
        wait.until(d -> {
            try {
                WebElement e = d.findElement(loadingBy);
                return !e.isDisplayed();
            } catch (NoSuchElementException ex) {
                return true;
            }
        });

// 5. textToBePresentInElement
        wait.until(ExpectedConditions.textToBePresentInElement(messageBy, "Success"));
        // Custom static method
        public static Boolean textToBePresentInElement (WebDriver driver, By locator, String text){
            try {
                return driver.findElement(locator).getText().contains(text);
            } catch (NoSuchElementException ex) {
                return false;
            }
        }
// Lambda equivalent
        wait.until(d -> {
            try {
                return d.findElement(messageBy).getText().contains("Success");
            } catch (NoSuchElementException ex) {
                return false;
            }
        });

// 6. titleContains
        wait.until(ExpectedConditions.titleContains("Dashboard"));
// Lambda equivalent
        wait.until(d -> d.getTitle().contains("Dashboard"));

// 7. urlContains
        wait.until(ExpectedConditions.urlContains("account"));
// Lambda equivalent
        wait.until(d -> d.getCurrentUrl().contains("account"));


 */