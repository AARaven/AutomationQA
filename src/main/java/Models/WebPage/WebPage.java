package Models.WebPage;

import java.net.URL;

public interface WebPage {
    
    void nextPage();
    
    void previousPage();
    
    void refreshPage();
    
    void openPage();
    
    void openPage( URL url );
    
    void closePage();
}
