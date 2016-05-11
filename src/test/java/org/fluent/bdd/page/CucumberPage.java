package org.fluent.bdd.page;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Rizwan on 18/06/2015.
 */
public class CucumberPage extends AbstractPage {

    public void isAt() {
        assertThat(title()).isEqualTo("Cucumber");
    }
}
