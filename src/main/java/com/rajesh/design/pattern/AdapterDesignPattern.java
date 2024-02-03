package com.rajesh.design.pattern;


interface WebDriver{
    void getElements();
    void selectElements();
}

class ChromeDriver implements WebDriver{
    @Override
    public void getElements() {
        System.out.println("ChromeDriver - > getElements");
    }
    @Override
    public void selectElements() {
        System.out.println("ChromeDriver - > setElements");
    }
}

class Idriver {

    void findElements(){
        System.out.println("Idriver -> findElements");
    }

    void clickedElements(){
        System.out.println("Idriver -> clickedElements");
    }

}

class WebDriverAdapter implements WebDriver{
    Idriver idriver;
    WebDriverAdapter (Idriver idriver){
        this.idriver = idriver;
    }

    @Override
    public void getElements() {
        idriver.findElements();
    }
    @Override
    public void selectElements() {
        idriver.clickedElements();
    }
}



public class AdapterDesignPattern {
    public static void main(String[] args) {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElements();
        chromeDriver.selectElements();


        Idriver idriver = new Idriver();
//        idriver.findElements();
//        idriver.clickedElements();

        WebDriver webDriver = new WebDriverAdapter(idriver);
        webDriver.getElements();
        webDriver.selectElements();

    }
}
