package org.example.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultsPage {
    private final ElementsCollection elements = $$("[data-testid=\"result\"]");

    public void checkCollectionSize(int size) {
       elements.shouldHave(sizeGreaterThan(size));
    }

    public void checkElementHasText(String expectedText, int index) {
        elements.get(index).shouldHave(text(expectedText));
    }

    public ElementsCollection getElements() {
        return elements;
    }
}
