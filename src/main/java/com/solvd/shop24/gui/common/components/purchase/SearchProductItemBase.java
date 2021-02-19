package com.solvd.shop24.gui.common.components.purchase;

import com.solvd.shop24.gui.common.pages.purchase.ProductPageBase;

public interface SearchProductItemBase {
    String getTitle();
    String getPrice();
    ProductPageBase openItem();
}
