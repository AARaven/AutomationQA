package SeleniumTest.com.automationpractice.Page;

interface PageNavigation {

    void open();

    void openUrl(String url);

    void openPage(Page page);

    void next();

    void back();

    void refresh();
}
