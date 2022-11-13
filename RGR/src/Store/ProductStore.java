package Store;

import entitys.Product;

public class ProductStore extends AbstractStore{
    public ProductStore() {
        super(Product.class);
    }

    private RealizationStore realizationStore = new RealizationStore();

    public RealizationStore getRealizationStore() {
        return realizationStore;
    }

}
