package pages;

import org.openqa.selenium.By;

import static utilities.ElementUtil.*;

public class FooterComponent {

    public static final By FOOTER_H4_TEXT = By.tagName("strong");
    public static final By FOOTER_ADDRESS_TEXT = By.tagName("p");
    public static final By FOOTER_CONTACT_TEXT = By.xpath("(//ul)[2]");
    public static final By FOOTER_MEDIA_LINKS = By.xpath("(//ul)[3]");
    public static final By FOOTER_COPYRIGHT_TEXT = By.xpath("(//p)[2]");

    public String getFooterHeaderText(){     
        return getElementText(FOOTER_H4_TEXT);
    }

    public String getFooterAddressText(){     
        return getElementText(FOOTER_ADDRESS_TEXT);
    }

    public String getFooterContactText(){     
        return getElementText(FOOTER_CONTACT_TEXT);
    }

    public String getFooterMediaLinksText(){     
        return getElementText(FOOTER_MEDIA_LINKS);
    }

    public String getFooterCopyrightText(){     
        return getElementText(FOOTER_COPYRIGHT_TEXT);
    }
    
}
