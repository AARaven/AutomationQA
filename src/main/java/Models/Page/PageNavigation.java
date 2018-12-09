package Models.Page;

import Models.Page.Page;

interface PageNavigation {

    <T extends Page> T getInstance(Class<T> pageClass);

    void open();

    void openUrl(String url);

    void openPage(Page page);

    void next();

    void back();

    void refresh();
}
