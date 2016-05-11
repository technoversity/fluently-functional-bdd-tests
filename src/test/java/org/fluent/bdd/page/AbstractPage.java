package org.fluent.bdd.page;

import org.fluentlenium.core.FluentPage;
import org.fluent.bdd.utils.BrowserCoordinator;

/**
 * Created by Rizwan on 18/06/2015.
 */
public class AbstractPage extends FluentPage {

    public AbstractPage() {
        super(BrowserCoordinator.getCurrentDriver());
    }

}
