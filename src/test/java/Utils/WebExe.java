package Utils;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebExe extends funct {
    int selesai = 0;
    private String implicityWaitValue;
    public void sendKeys(WebElement elemen, CharSequence kata, int numOfTrial){
        selesai = 0;
        while(selesai<numOfTrial){
            try{
                elemen.sendKeys(kata);
                if(!elemen.getAttribute("value").equals("") && elemen.getAttribute("value") != null)break;
            }catch(Exception e){selesai++;}
        }
        if(selesai==numOfTrial) validation.validasiUnderTrial(numOfTrial);
        selesai = 0;
    }

    public void click(WebElement elemen, int numOfTrial){
        selesai = 0; int i=0;
        while(selesai<numOfTrial){
            try{ elemen.click(); selesai = numOfTrial; }catch(Exception e){selesai++;}
        } selesai = 0;
    }

    public void clear(WebElement elemen, int numOfTrial){
        selesai = 0;
        while(selesai<numOfTrial){
            try{
                elemen.clear();
                elemen.sendKeys(Keys.CONTROL,"a");
                elemen.sendKeys(Keys.DELETE);
                selesai = numOfTrial;
            }catch(Exception e){selesai++;}
        } selesai = 0;
    }

    public boolean isDisplayed(WebElement elemen, int numOfTrial){
        selesai = 0; boolean kebenaran = false;
        while(selesai<numOfTrial){
            try{
                kebenaran = elemen.isDisplayed();
                selesai = numOfTrial;
            }catch(Exception e){selesai++;}
        } selesai = 0;
        return kebenaran;
    }

    public String getText(WebElement elemen, int numOfTrial){
        String kata = "";
        selesai = 0;
        while(selesai<numOfTrial && kata.equals("")){
            try{
                kata = elemen.getText();
                selesai = numOfTrial;
            }catch(Exception e){selesai++;}
        } selesai = 0;
        return kata;
    }

    public String getText(String elemenCSS, int numOfTrial){
        String kata = "";
        selesai = 0;
        while(selesai<numOfTrial && kata.equals("")){
            try{
                kata = getDriver().findElement(By.cssSelector(elemenCSS)).getText();
                selesai = numOfTrial;
            }catch(Exception e){selesai++;}
        } selesai = 0;
        return kata;
    }

    public String getAttribute(WebElement elemen, String atribut, int numOfTrial){
        String kata = "";
        selesai = 0;
        while(selesai<numOfTrial && kata.equals("")){
            try{
                kata = elemen.getAttribute(atribut);
                selesai = numOfTrial;
            }catch(Exception e){selesai++;}
        } selesai = 0;
        return kata;
    }

    public boolean waitUntilVisible(WebElement elemen, long timeOutMilis){
        Wait<WebDriver> tunggu = new FluentWait<WebDriver>(getDriver()).withTimeout(timeOutMilis, TimeUnit.MILLISECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        String css = elemen.toString().replaceAll(".* css selector: ","");
        css = css.substring(0,css.length()-1);
        try{tunggu.until(ExpectedConditions.visibilityOf(elemen));}catch (TimeoutException e){}
        try{element(getDriver().findElement(By.cssSelector(css))).isVisible(); return true;}catch (Exception e){return false;}
    }

    //Ganti semua ke ini
    public boolean waitUntilVisible(WebElement elemen, long  timeOutMilis, long jedaTambahanInMilis){
        Wait<WebDriver> tunggu = new FluentWait<WebDriver>(getDriver()).withTimeout(timeOutMilis, TimeUnit.MILLISECONDS).pollingEvery(jedaTambahanInMilis, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        try{tunggu.until(ExpectedConditions.visibilityOf(elemen));}catch (TimeoutException e){}
        try{
            String css = elemen.toString().replaceAll(".* css selector: ","");
            css = css.substring(0,css.length()-1);
            element(getDriver().findElement(By.cssSelector(css))).isVisible(); return true;
        }catch (Exception e){return false;}
    }

    public boolean waitUntilClickable(WebElement elemen, long timeOutMilis){
        Wait<WebDriver> tunggu = new FluentWait<WebDriver>(getDriver()).withTimeout(timeOutMilis, TimeUnit.MILLISECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        try{tunggu.until(ExpectedConditions.elementToBeClickable(elemen));}catch (TimeoutException e){}
        try{
            String css = elemen.toString().replaceAll(".* css selector: ","");
            css = css.substring(0,css.length()-1);
            element(getDriver().findElement(By.cssSelector(css))).isClickable(); return true;
        }catch (Exception e){return false;}
    }

    public boolean waitUntilClickable(WebElement elemen, long timeOutMilis, long pollEvery){
        long waktu = getCurrrentTimeMs();
        while(getCurrrentTimeMs()-waktu <= timeOutMilis){
            try{if(element(elemen).isClickable()) return true;}catch (Exception e){}
            try{Thread.sleep(pollEvery);}catch (InterruptedException e){}
        }
        return false;
    }

    public void waitUntilClickable(WebElement elemen, int numOfTrial, long timeOut, long pollEvery){
        selesai = 0; long waktu = getCurrrentTimeMs();
        while(selesai<numOfTrial && getCurrrentTimeMs()-waktu <= timeOut){
            if(element(elemen).isClickable()) selesai = numOfTrial; else selesai++;
            try{Thread.sleep(pollEvery);}catch (InterruptedException e){}
        } selesai = 0;
    }

    public boolean waitUntilPresent(WebElement elemen, long timeOutMilis, long jedaTambahanInMilis){
        Wait<WebDriver> tunggu = new FluentWait<WebDriver>(getDriver()).withTimeout(timeOutMilis, TimeUnit.MILLISECONDS).pollingEvery(jedaTambahanInMilis, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        String css = elemen.toString().replaceAll(".* css selector: ","");
        css = css.substring(0,css.length()-1);
        try{tunggu.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));}catch (TimeoutException e){}
        try{element(getDriver().findElement(By.cssSelector(css))).isVisible(); return true;}catch (Exception e){return false;}
    }

    public boolean waitUntilNotVisible(WebElement elemen, long timeOutMilis){
        Wait<WebDriver> tunggu = new FluentWait<WebDriver>(getDriver()).withTimeout(timeOutMilis, TimeUnit.MILLISECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        String css = elemen.toString().replaceAll(".* css selector: ","");
        css = css.substring(0,css.length()-1);
        try{tunggu.until(ExpectedConditions.visibilityOf(elemen));}catch (TimeoutException e){}
        try{element(getDriver().findElement(By.cssSelector(css))).isVisible(); return false;}catch (Exception e){return true;}
    }

    public boolean waitUntilNotVisible(WebElement elemen, int numOfTrial, long jedaTambahanInMilis){
        Wait<WebDriver> tunggu = new FluentWait<WebDriver>(getDriver()).withTimeout(jedaTambahanInMilis, TimeUnit.MILLISECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        String css = elemen.toString().replaceAll(".* css selector: ","");
        css = css.substring(0,css.length()-1);
        try{tunggu.until(ExpectedConditions.visibilityOf(elemen));}catch (TimeoutException e){}
        try{element(getDriver().findElement(By.cssSelector(css))).isVisible(); return false;}catch (Exception e){return true;}
    }

    public void waitUntilEnabled(WebElement elemen, int numOfTrial){
        selesai = 0;
        while(selesai<numOfTrial){
            try{
                element(elemen).waitUntilEnabled();
                selesai = numOfTrial;
            }catch(Exception e){selesai++;}
        } selesai = 0;
    }

    public boolean waitUntilEnabled(WebElement elemen, long timeOutMilis, long pollEvery){
        long waktu = getCurrrentTimeMs();
        while(getCurrrentTimeMs()-waktu <= timeOutMilis){
            if(element(elemen).isEnabled()) return true;;
            try{Thread.sleep(pollEvery);}catch (InterruptedException e){}
        }
        return false;
    }

    public boolean waitingURL(String desiredCurrentURL, long jedaInMilis, int numOfTrial){
        selesai = 0; boolean kebenaran = false;
        try{Thread.sleep(jedaInMilis);}catch (InterruptedException e){}
        while(!getDriver().getCurrentUrl().contains(desiredCurrentURL) && selesai<numOfTrial){
            try{
                Thread.sleep(jedaInMilis);
                selesai++;
            }catch (InterruptedException e){}
        }
        if(getDriver().getCurrentUrl().contains(desiredCurrentURL)) kebenaran = true;
        else kebenaran = false;
        selesai = 0;
        return kebenaran;
    }

    public boolean waitingURL(String desiredCurrentURL, long jedaInMilis, int numOfTrial, boolean extraCondition){
        selesai = 0; boolean kebenaran = false;
        while(selesai < numOfTrial && extraCondition && !getDriver().getCurrentUrl().contains(desiredCurrentURL)){
            try{
                Thread.sleep(jedaInMilis);
                selesai++;
            }catch (InterruptedException e){}
        }
        if(getDriver().getCurrentUrl().contains(desiredCurrentURL)) kebenaran = true;
        else kebenaran = false;
        selesai = 0;
        return kebenaran;
    }

    public boolean waitingForPresenceOfElement(WebElement elemen, long timeOutMilis, long pollEvery){
        gettingSerenityProperty(ThucydidesSystemProperty.WEBDRIVER_TIMEOUTS_IMPLICITLYWAIT);
        turnOffImplicitWaits();
        Wait<WebDriver> tunggu = new FluentWait<WebDriver>(getDriver()).withTimeout(timeOutMilis, TimeUnit.MILLISECONDS).pollingEvery(pollEvery, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        try{tunggu.until(ExpectedConditions.visibilityOf(elemen));}catch (Exception e){}
        try{
            String css = elemen.toString().replaceAll(".* css selector: ","");
            css = css.substring(0,css.length()-1);
            element(getDriver().findElement(By.cssSelector(css))).isDisplayed();
            turnOnImplicitWaits();
            return true;
        }catch (Exception e){turnOnImplicitWaits(); return false;}
    }

    public boolean waitingPresenceAssertionText(WebElement elemen, String mustExistText, long timeOutMilis, long pollEvery){
        long waktu = getCurrrentTimeMs(), now = 0; String text = "";
        while (now - waktu <= timeOutMilis) {
            text = getText(elemen,5);
            if(text.contains(mustExistText)) return true;
            try { Thread.sleep(pollEvery); } catch (InterruptedException e) {}
            now = getCurrrentTimeMs();
            System.out.println("Trying for getting Text");
        }
        return false;
    }

    public void scrollUntilElement(WebElement elemen, long timeOutWaitForPresenceOfElement){
        waitingForPresenceOfElement(elemen,timeOutWaitForPresenceOfElement,100);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", elemen);
    }

    public void scrollUntilLeftElement(WebElement elemen, long timeOutWaitForPresenceOfElement){
        waitingForPresenceOfElement(elemen,timeOutWaitForPresenceOfElement,100);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", elemen);
    }

    public void hoveringMouseTo(WebElement elemen, long timeOutWaitForPresenceOfElement){
        waitingForPresenceOfElement(elemen,timeOutWaitForPresenceOfElement,100);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(elemen).perform();
    }

//    //File Uploader
//    public  <T extends fileUploader> T elemen(WebElement elemenya) {
//        return (T) new fileUploader(elemenya);
//    }

    //Helper
    public void AssertionNotContainText(WebElement elemenWeb, String text){
        boolean noContains = false;
        WebDriverWait tunggu = new WebDriverWait(getDriver(),1,0);
        try{tunggu.until(ExpectedConditions.textToBePresentInElement(elemenWeb,text));}catch (Exception e){noContains=true;}
        Assert.assertTrue(noContains);
    }

    public String gettingSerenityProperty(ThucydidesSystemProperty Thucydides_Name){
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        implicityWaitValue = variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_TIMEOUTS_IMPLICITLYWAIT);
        return implicityWaitValue;
        //SerenitySystemProperties systemProperties = SerenitySystemProperties.getProperties();
        //return systemProperties.getValue(Thucydides_Name);
    }

    public void settingSerenityProperty(ThucydidesSystemProperty Thucydides_Name, String value){
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        variables.setProperty(Thucydides_Name.getPropertyName(),value);
        //SerenitySystemProperties systemProperties = SerenitySystemProperties.getProperties();
        //systemProperties.setValue(Thucydides_Name,value);
    }

    private void turnOffImplicitWaits() {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        settingSerenityProperty(ThucydidesSystemProperty.WEBDRIVER_TIMEOUTS_IMPLICITLYWAIT,"0");
    }

    private void turnOnImplicitWaits() {
        getDriver().manage().timeouts().implicitlyWait(Long.valueOf(implicityWaitValue), TimeUnit.MILLISECONDS);
        settingSerenityProperty(ThucydidesSystemProperty.WEBDRIVER_TIMEOUTS_IMPLICITLYWAIT,implicityWaitValue);
    }
    //Hermes Only
    @FindBy(css="app sidebar-mini rtl pace-running") WebElement loadingHermes;
    @FindBy(css="pace  pace-active") WebElement paceActive;
    @FindBy(css="app sidebar-mini rtl  pace-done") WebElement finishLoading;
    @FindBy(css="pace  pace-inactive") WebElement paceFinish;
    public void tungguLoadingHermes() {
        Wait<WebDriver> tungguMuncul = new FluentWait<WebDriver>(getDriver()).withTimeout(800, TimeUnit.MILLISECONDS).pollingEvery(50, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        Wait<WebDriver> tungguFinish = new FluentWait<WebDriver>(getDriver()).withTimeout(8000, TimeUnit.MILLISECONDS).pollingEvery(50, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        String css = loadingHermes.toString().replaceAll(".* css selector: ", "");
        css = css.substring(0, css.length() - 1);
        try{tungguMuncul.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));}catch (TimeoutException e){}
        css = finishLoading.toString().replaceAll(".* css selector: ", "");
        css = css.substring(0, css.length() - 1);
        try{tungguFinish.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));}catch (TimeoutException e){}
    }

    //Odoo Only
    @FindBy(css = "body[class='o_web_client']") WebElement loadMenuSelesai;
    public void tungguLoadingFinish () {
        WebDriverWait tunggu = new WebDriverWait(getDriver(), 10);
        WebDriverWait tungguin = new WebDriverWait(getDriver(), 0, 500);
        WebDriverWait tungguinItung = new WebDriverWait(getDriver(), 0, 50);
        int cntFinish = 0, cntWhile = 0;
        boolean finishLoad = false;
        while (!finishLoad) {
            //taro bareng karena memastikan si tungguLoadMenu gk babals gegara set driver kelamaan
            try {
                tungguin.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body[class*='o_web_client oe_wait']")));
                tunggu.until(ExpectedConditions.visibilityOf(loadMenuSelesai));
            } catch (Exception e) {
            }
            cntFinish = 0;
            while (cntFinish <= 10) { //cek beneran selesai gk loadingnya selama 15*100 milis = 1,5 detik
                try {
                    Thread.sleep(25); //ubah nilai di sini aja <<<<<<<<<<<<<<<<<<<<< woy sini >>>>>>>>>>>>>>
                    tungguinItung.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.o_loading[style='display: none;']")));
                    cntFinish++;
                } catch (InterruptedException e1) {
                } catch (Exception e2) {
                }
            }
            if (cntFinish >= 10) finishLoad = true; //kalo beneran selesai load lebih dari 100 ms, beneran selesai
            else cntWhile++; //memaksa keluar jika udah 5 kali percobaan
            if (cntWhile >= 2) finishLoad = true;
        }
    }

    public void tungguLoadingTotalOdoo(){
        //body[class='drawer drawer--left o_web_client drawer-close']
        WebDriverWait tunggu = new WebDriverWait(getDriver(),15);
        WebDriverWait tungguin = new WebDriverWait(getDriver(),120);
        try { tunggu.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".drawer.drawer--left.o_web_client.drawer-close.oe_wait")));}catch (Exception e){}
        try { tungguin.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body.drawer.drawer--left.o_web_client.drawer-close.oe_wait.o_ui_blocked")));}catch (Exception e){}
        int cntWhile = 0, resetWhile=0;
        while(cntWhile<11){
            try {
                try{Thread.sleep(80);}catch (InterruptedException e){}
                tungguin.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body[class='drawer drawer--left o_web_client drawer-close']")));
                cntWhile++;
            } catch (Exception e){resetWhile++;if(resetWhile>1)break;}
        }
    }
}

class validation{
    public static void validasiUnderTrial(int numOfTrial){
        throw new IllegalArgumentException("Percobaan Mencapai Trial Kegagalan Sebanyak "+numOfTrial+" kali");
    }

    public static void validasiTimeOut(long timeOut){
        throw new IllegalArgumentException("Percobaan telah melebihi Timeout! Sebanyak "+timeOut+"Milis");
    }
}
