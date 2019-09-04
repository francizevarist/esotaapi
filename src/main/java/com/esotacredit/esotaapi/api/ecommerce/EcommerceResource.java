package com.esotacredit.esotaapi.api.ecommerce;

import java.io.IOException;

import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.AddCartItemBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.AddCartItemResponse;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.deletecart.DeleteCartItemBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.deletecart.DeleteCartItemResponse;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.CartBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.CartResponse;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart.UpdateCartBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart.UpdateCartResponse;
import com.esotacredit.esotaapi.api.ecommerce.categories.categorylist.CategoryResponse;
import com.esotacredit.esotaapi.api.ecommerce.categories.object.CategoryBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery.DeleteDeliveryItemBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery.DeleteDeliveryItemResponse;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery.DeliveryListBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery.DeliveryListResponse;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct.DeliveryProductBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct.DeliveryProductResponse;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse.WarehouseBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse.WarehouseResponse;
import com.esotacredit.esotaapi.api.ecommerce.payments.ipnlistener.IpnBody;
import com.esotacredit.esotaapi.api.ecommerce.payments.ipnlistener.IpnResponse;
import com.esotacredit.esotaapi.api.ecommerce.products.datamodel.ProductBody;
import com.esotacredit.esotaapi.api.ecommerce.products.datamodel.ProductResponse;
import com.esotacredit.esotaapi.api.ecommerce.products.datamodel.RelatedProductBody;
import com.esotacredit.esotaapi.api.ecommerce.products.productdetails.ProductDetailsBody;
import com.esotacredit.esotaapi.api.ecommerce.products.productdetails.ProductDetailsResponse;
import com.esotacredit.esotaapi.api.ecommerce.products.recomended.RecomendedBody;
import com.esotacredit.esotaapi.api.ecommerce.products.recomended.RecomendedProductResponse;
import com.esotacredit.esotaapi.api.ecommerce.searching.SearchingBody;
import com.esotacredit.esotaapi.api.ecommerce.searching.SearchingResponse;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.PendingBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.PendingResponse;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased.PurchasedBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased.PurchasedResponse;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference.PendingReferenceBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference.PendingReferenceResponse;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference.PurchasedReferenceBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference.PurchasedReferenceResponse;
import com.esotacredit.esotaapi.api.ecommerce.shop.qualified.QualifiedShopBody;
import com.esotacredit.esotaapi.api.ecommerce.shop.qualified.QualifiedShopResponse;
import com.esotacredit.esotaapi.api.ecommerce.sold.datamodel.SaveAsSoldBody;
import com.esotacredit.esotaapi.api.ecommerce.sold.datamodel.SaveAsSoldResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EcommerceResource {

    @Autowired
    EcommerceDaoService service;

    @RequestMapping(value = "/productimage/{productname}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String productname) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("productimage/"+productname);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }

    @PostMapping("/search")
    public SearchingResponse searching(@RequestBody SearchingBody searchingBody){
        return new SearchingResponse(service.searching(searchingBody));
    }

    @PostMapping("/randomproducts")
    public ProductResponse getRandomProducts(@RequestBody ProductBody productBody){
        return new ProductResponse(service.getRandomProduct(productBody));
    }

    @PostMapping("/recomendedproducts")
    public RecomendedProductResponse getRecomended(@RequestBody RecomendedBody recomendedBody){
        return new RecomendedProductResponse(service.getRecomendedProduct(recomendedBody));
    }

    @PostMapping("/relatedproduct")
    public RecomendedProductResponse getRelatedProduct(@RequestBody RelatedProductBody relatedProductBody){
        return new RecomendedProductResponse(service.getRelatedProduct(relatedProductBody));
    }

    @PostMapping("/productdetails")
    public ProductDetailsResponse getProductDetails(@RequestBody ProductDetailsBody productDetailsBody){
        return new ProductDetailsResponse(service.getProductDetails(productDetailsBody));
    }

    @PostMapping("/cart")
    public CartResponse getCart(@RequestBody CartBody cartBody){
        return new CartResponse(service.getCart(cartBody));
    }

    @PostMapping("/additemtocart")
    public AddCartItemResponse addToCart(@RequestBody AddCartItemBody addCartItemBody){
        return new AddCartItemResponse(service.addCart(addCartItemBody));
    }

    @PostMapping("/deletecartitem")
    public DeleteCartItemResponse deleteCartItemResponse(@RequestBody DeleteCartItemBody deleteCartItemBody){
        return new DeleteCartItemResponse(service.deleteCart(deleteCartItemBody));
    }

    @PostMapping("/updatecartitem")
    public UpdateCartResponse updateCart(@RequestBody UpdateCartBody updateCartBody){
        return new UpdateCartResponse(service.updateCart(updateCartBody));
    }

    @PostMapping("/saveassold")
    public SaveAsSoldResponse saveAsSoldResponse(@RequestBody SaveAsSoldBody saveAsSoldBody){
        return new SaveAsSoldResponse(service.saveAsSold(saveAsSoldBody));
    }

    @PostMapping("/deliverylist")
    public DeliveryListResponse getDelivery(@RequestBody DeliveryListBody deliveryListBody){
        return  new DeliveryListResponse(service.getDeliveries(deliveryListBody));
    }

    @PostMapping("/deliveryproductlist")
    public DeliveryProductResponse getDeliveryProducts(@RequestBody DeliveryProductBody deliveryProductBody){
        return new DeliveryProductResponse(service.getDeliveryProductList(deliveryProductBody));
    }

    @PostMapping("/warehouse")
    public WarehouseResponse getWarehouse(@RequestBody WarehouseBody warehouseBody){
        return new WarehouseResponse(service.getWarehouse(warehouseBody));
    }

    @PostMapping("/deletedelivereditem")
    public DeleteDeliveryItemResponse deleteDeliveredItem(@RequestBody DeleteDeliveryItemBody deleteDeliveryItemBody){
        return new DeleteDeliveryItemResponse(service.deleteDeliveredItem(deleteDeliveryItemBody));
    }

    @PostMapping("/pendingreferencelist")
    public PendingReferenceResponse getPendingReference(@RequestBody PendingReferenceBody pendingReferenceBody){
        return  new PendingReferenceResponse(service.getPendingReferenceList(pendingReferenceBody));
    }

    @PostMapping("/pendinglist")
    public PendingResponse getPending(@RequestBody PendingBody pendingBody){
        return  new PendingResponse(service.getPendingList(pendingBody));
    }

    @PostMapping("/purchasedreferencelist")
    public PurchasedReferenceResponse getPendingReference(@RequestBody PurchasedReferenceBody purchasedReferenceBody){
        return  new PurchasedReferenceResponse(service.getPurchasedReferenceList(purchasedReferenceBody));
    }

    @PostMapping("/purchasedlist")
    public PurchasedResponse getPurchased(@RequestBody PurchasedBody purchasedBody){
        return  new PurchasedResponse(service.getPurchasedList(purchasedBody));
    }

    @PostMapping("/allpurchases")
    public PurchasedResponse getPurchasedByUser(@RequestBody PurchasedBody purchasedBody){
        return  new PurchasedResponse(service.getAllUserPurchase(purchasedBody));
    }

    @PostMapping("/ipnlistener")
    public IpnResponse getIpnListener(@RequestParam("pesapal_notification_type") String pesapal_notification_type, @RequestParam("pesapal_transaction_tracking_id") String pesapal_transaction_tracking_id, @RequestParam("pesapal_merchant_reference") String pesapal_merchant_reference){
        IpnBody ipnBody = new IpnBody(pesapal_notification_type,pesapal_transaction_tracking_id,pesapal_merchant_reference);
        return new IpnResponse(service.listernIPN(ipnBody));
    }

    @PostMapping("/qualifiedshops")
    public QualifiedShopResponse getQualifiedShop(@RequestBody QualifiedShopBody qualifiedShopBody){
        return new QualifiedShopResponse(service.getQualifiedShopList(qualifiedShopBody));
    }

    @PostMapping("/categories")
    public CategoryResponse getCategories(@RequestBody CategoryBody categoryBody){
        return new CategoryResponse(service.getCategories(categoryBody));
    }

}
