package src.main.test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium .*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

public class XYVedioTest {



    static  AndroidDriver driver;


    static WebElement findElementByXPath(String path){

        try {
            WebElement  o = driver.findElement(By.xpath(path));
            return o;
        }catch(Exception e){
           // e.printStackTrace();;
            return null;
        }


    }
    static void test(String title,int totalNumbers){
        String last = "";

        int totalIndex = 4;

        //top3
        String path = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView[1]";
        ////////////// /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView[1]

        out:while(true) {

            String currLast = "";


            String index = null;
            for (int cIndex = 1; cIndex < 14; cIndex++) {






                path = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[" + cIndex + "]/android.widget.RelativeLayout/android.widget.TextView";

                WebElement eIndex = (WebElement) findElementByXPath(path);
                if(eIndex!=null){

                    index = eIndex.getText();
                    if(index.equals("")){
                        index="-1";
                    }
                }

                //name
                path = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[" + cIndex + "]/android.widget.TextView[1]";
                WebElement el5 = (WebElement) findElementByXPath(path);

                String name = null;
                if(el5!=null){
                    name = el5.getText();
                }
                //money
                path = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[" + cIndex + "]/android.widget.TextView[2]";
                el5 = (WebElement) findElementByXPath(path);
                String money = null;
                if(el5!=null){
                    money = el5.getText();
                }
                System.out.println(title+","+totalNumbers+","+cIndex+","+index + "," + name + "," + money);
                currLast = name;

                if(index==null) {//top3
                    continue;
                }
                int indexV = Integer.parseInt(index);
                if(indexV==totalNumbers){
                    break out;

                }

            }
            if(currLast.equals(last)){
                break;
            }
            last = currLast;


            final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Point start = new Point(507, 2000);
            Point end = new Point (532, 268);
            Sequence swipe = new Sequence(FINGER, 1)
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(0),
                                    PointerInput.Origin.viewport(),
                                    start.getX(),
                                    start.getY()))
                    .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(1000),
                                    PointerInput.Origin.viewport(),
                                    end.getX(),
                                    end.getY()))
                    .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            try {
                driver.perform(Arrays.asList(swipe));
            }catch(Exception e){
                e.printStackTrace();
                break;
            }
        }





    }

    public static void main(String[] args) throws Exception{


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);




         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);


         for(int itemIndex =2;itemIndex<9;itemIndex++){

             String titlePath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+itemIndex+"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView";
             WebElement titleE = (WebElement) findElementByXPath(titlePath);
             String title = titleE.getText();
             String path = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout["+itemIndex+"]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView";
             WebElement e = (WebElement) findElementByXPath(path);
             e.click();;

                    path = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.TextView";
              WebElement e2 = (WebElement) findElementByXPath(path);
              String text = e2.getText();
              if(text.equals("赞赏")){








                  WebElement el2 = (WebElement) findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView");
                  el2.click();

                  WebElement el3 = (WebElement) findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView");

                  String totalNumberText = el3.getText();

                  System.out.println(totalNumberText);

                  int totalNumber = Integer.parseInt(totalNumberText.substring(1,totalNumberText.indexOf("人")));
                  el3.click();


                  test(title,totalNumber);

                  WebElement el1 = (WebElement) driver.findElement(new AppiumBy.ByAccessibilityId("返回"));
                  el1.click();
                   el2 = (WebElement) driver.findElement(new AppiumBy.ByAccessibilityId("返回"));
                  el2.click();






              }else{
                  WebElement el2 = (WebElement) driver.findElement(By.id("com.ss.android.article.video:id/k4"));
                  el2.click();

              }
         }


        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(622, 2264);
        Point end = new Point (635, 416);
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(0),
                                PointerInput.Origin.viewport(),
                                start.getX(),
                                start.getY()))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(1000),
                                PointerInput.Origin.viewport(),
                                end.getX(),
                                end.getY()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));








//        WebElement el1 = (WebElement) findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView");
//        el1.click();
//        WebElement el2 = (WebElement) findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView");
//        el2.click();
//        WebElement el3 = (WebElement) findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView");
//        el3.click();
//        WebElement el4 = (WebElement) findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[8]/android.widget.TextView[1]");
//        el4.click();











//
        // WebElement view = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.view.View"));
//
//        List<WebElement> avtList =  view.findElements(By.id("com.ss.android.article.video:id/avt"));
//
//        for(WebElement e:avtList){
//            System.out.println(e.getText());
//        }

      // String path = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]";
       //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]
        //hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]


        //WebElement avt = driver.findElement(By.xpath(path));

        //avt.findElements(By.xpath("/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView));
       //


//
//        el1.click();
//        WebElement el2 = (WebElement) findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView");
//        el2.click();
//        WebElement el3 = (WebElement) findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView");
//        el3.click();
//        List<WebElement> items = driver.findElements(By.className("android.widget.TextView"));
//        for(WebElement item:items){
//
//            //com.ss.android.article.video:id/ebj
//            String resourceId = item.getAttribute("resource-id");
//            System.out.println(resourceId+":"+item.getText());
//        }


//
//        for(int index = 0;index<290;index++){
//
//
//
//        WebElement rightCornerMenu = (WebElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView"));
//        rightCornerMenu.click();
//       WebElement e =  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.TextView"));
//
//       String title = e.getText();
//       boolean hashToken = false;
//       if(title.indexOf("赏")==-1){
//
//       }else{
//           hashToken=true;
//       }
//
//        WebElement el4 = (WebElement) driver.findElement(By.xpath("com.ss.android.article.video:id/k4"));
//        el4.click();
//
//        String path = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.TextView";
//
//           String videoTitle =   driver.findElement(By.xpath(path)).getText();
//           System.out.println(videoTitle+":打赏:"+true);
//
//        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Point start = new Point(880, 1873);
//        Point end = new Point (880, 1601);
//        Sequence swipe = new Sequence(FINGER, 1)
//                .addAction(
//                        FINGER.createPointerMove(
//                                Duration.ofMillis(0),
//                                PointerInput.Origin.viewport(),
//                                start.getX(),
//                                start.getY()))
//                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//                .addAction(
//                        FINGER.createPointerMove(
//                                Duration.ofMillis(1000),
//                                PointerInput.Origin.viewport(),
//                                end.getX(),
//                                end.getY()))
//                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(swipe));
//
//         }





        // rightCornerMenu.click();

//
//        WebElement el1 = (WebElement) driver.findElement(By.xpath(
//                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView")
//        );
//        el1.click();
//        WebElement el2 = (WebElement) driver.findElement(By.id("com.ss.android.article.video:id/k4"));
//        el2.click();
//
//        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Point start = new Point(897, 1869);
//        Point end = new Point (887, 1598);
//        Sequence swipe = new Sequence(FINGER, 1)
//                .addAction(
//                        FINGER.createPointerMove(
//                                Duration.ofMillis(0),
//                                PointerInput.Origin.viewport(),
//                                start.getX(),
//                                start.getY()))
//                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//                .addAction(
//                        FINGER.createPointerMove(
//                                Duration.ofMillis(1000),
//                                PointerInput.Origin.viewport(),
//                                end.getX(),
//                                end.getY()))
//                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(swipe));
//
//        WebElement el3 = (WebElement) driver.findElement(By.xpath(
//                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView"
//        ));
//        el3.click();
//        WebElement el4 = (WebElement) driver.findElement(By.id("com.ss.android.article.video:id/k4"));
//        el4.click();
//







//
//        System.out.println("sub title:"+text);
//
//
//        String path2 ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/com.ixigua.framework.ui.slide.SlideFrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout";
//        WebElement el8 = (WebElement) driver.findElement(By.xpath(path2));
//
//       System.out.println(el8.toString());
//        String path3 ="el9";
//        WebElement el9 = (WebElement) driver.findElement(By.xpath(path2));
//        System.out.println(el9.toString());

        //swipe(driver);







    }

    private static String getText(AndroidDriver driver, String MoneyTitlepath) {
        WebElement tmp = (WebElement) driver.findElement(By.xpath(MoneyTitlepath));
        String text = tmp.getText();
        return text;
    }

    private static void swipe(AndroidDriver driver) {
        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(706, 495);
        Point end = new Point(706, 2178);
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(0),
                                PointerInput.Origin.viewport(),
                                start.getX(),
                                start.getY()))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(
                        FINGER.createPointerMove(
                                Duration.ofMillis(1000),
                                PointerInput.Origin.viewport(),
                                end.getX(),
                                end.getY()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));


        for(int i=0;i<40;i++) {
            FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            start = new Point(738, 2181);
            end = new Point(759, 495);
            swipe = new Sequence(FINGER, 1)
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(0),
                                    PointerInput.Origin.viewport(),
                                    start.getX(),
                                    start.getY()))
                    .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(1000),
                                    PointerInput.Origin.viewport(),
                                    end.getX(),
                                    end.getY()))
                    .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Arrays.asList(swipe));
        }
    }
}
