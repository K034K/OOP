package Store;

import entitys.seller;

public class SellerStore extends AbstractStore {

    public SellerStore() {
        super(seller.class);
    }

    private ProductStore productStore = new ProductStore();

    public ProductStore getProductStore() {
        return productStore;
    }
}
