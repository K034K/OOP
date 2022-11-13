package Store;

import entitys.Product;
import entitys.Realization;
import entitys.Seller;
import entitys.Shop;

import java.util.Date;

public class ShopStore extends AbstractStore {

    public ShopStore() {
        super(Shop.class);
    }

    private SellerStore sellerStore = new SellerStore();

    public SellerStore getSellerStore() {
        return sellerStore;
    }

    public ShopStore createSimpleTree(){
        ShopStore shopStore = new ShopStore();
        shopStore.add(new Shop(1,"shop1", "address1"));
        sellerStore.add(new Seller(1,"seller1", "selerSur", "address1", "phone", "email1"));
        sellerStore.getProductStore().add(new Product(1,"product1", "1", 1));
        Date date = new Date();
        date.getTime();
        sellerStore.getProductStore().getRealizationStore().add(new Realization(1,1,1,date));
        return shopStore;
    }

}
