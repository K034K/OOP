package Store;

import entitys.product;

public class ProductStore extends AbstractStore{
    public ProductStore() {
        super(product.class);
    }

    private RealizationStore realizationStore = new RealizationStore();

    public RealizationStore getRealizationStore() {
        return realizationStore;
    }

}
