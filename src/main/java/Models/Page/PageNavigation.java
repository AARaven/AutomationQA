package Models.Page;

interface PageNavigation {

    void openPage();

    void openUrl(String url);

    void next();

    void back();

    void refresh();

    String getCurrentUrl();
}
