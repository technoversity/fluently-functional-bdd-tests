package org.fluent.bdd.page;

import org.fluent.bdd.utils.Configuration;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Rizwan on 18/06/2015.
 */
public class GooglePage extends AbstractPage {

    public String getUrl() {
        return Configuration.getBaseUrl();
    }

    public void goToSearchPage() {
        goTo(getUrl());
    }

    public void isAt() {
        assertThat(title()).isEqualTo("Google");
        assertThat(find("#lst-ib").getText()).isEmpty();
    }

    public void submitQuery(String query) {
        find("#lst-ib").text(query).submit();
    }

    public void clickFirstLinkInSearchResults() {
        WebElement webElement = findFirst(".r").getElement();
        webElement.getTagName();
        webElement.getText();

        findFirst(".r").getElement().click();
    }
}
