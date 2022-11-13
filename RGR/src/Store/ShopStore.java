package Store;

import entitys.product;
import entitys.realization;
import entitys.seller;
import entitys.shop;

import java.util.Date;

public class ShopStore extends AbstractStore {

    public ShopStore() {
        super(shop.class);
    }

    private SellerStore sellerStore = new SellerStore();

    public SellerStore getSellerStore() {
        return sellerStore;
    }

    public ShopStore createSimpleTree(){
        ShopStore shopStore = new ShopStore();
        shopStore.add(new shop(1,"shop1", "address1"));
        sellerStore.add(new seller(1,"seller1", "selerSur", "address1", "phone", "email1"));
        sellerStore.getProductStore().add(new product(1,"product1", "1", 1));
        Date date = new Date();
        date.getTime();
        sellerStore.getProductStore().getRealizationStore().add(new realization(1,1,1,date));
        return shopStore;
    }

}
