package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        try {

            String folderPath = System.getProperty("user.dir") + "/screenshots";
            File folder = new File(folderPath);

            if (!folder.exists()) {
                folder.mkdirs();
            }

            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String filePath = folderPath + "/" + testName + "_" + time + ".png";

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);

            FileUtils.copyFile(src, dest);

            return filePath;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}