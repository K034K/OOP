package Store;

import entitys.Seller;

public class SellerStore extends AbstractStore {

    public SellerStore() {
        super(Seller.class);
    }

    private ProductStore productStore = new ProductStore();

    public ProductStore getProductStore() {
        return productStore;
    }
}
