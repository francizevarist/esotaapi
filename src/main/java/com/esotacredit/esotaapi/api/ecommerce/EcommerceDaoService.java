package com.esotacredit.esotaapi.api.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.AddCartItemBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.AddCartItemResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.addtocart.objects.ResponseMessage;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.deletecart.DeleteCartItemBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.deletecart.DeleteCartItemResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.CartBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.CartResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.model.Cart;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.getcart.model.ImageCart;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart.UpdateCartBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart.UpdateCartResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.cart.datamodel.updatecart.model.CartProduct;
import com.esotacredit.esotaapi.api.ecommerce.categories.categorylist.CategoryResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.categories.object.Category;
import com.esotacredit.esotaapi.api.ecommerce.categories.object.CategoryBody;
import com.esotacredit.esotaapi.api.ecommerce.categories.object.CategoryProduct;
import com.esotacredit.esotaapi.api.ecommerce.categories.object.ProductImage;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery.DeleteDeliveryItemBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery.DeleteDeliveryItemResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.deletedelivery.objects.DeleteDeliveryResponseMessage;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery.DeliveryListBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery.DeliveryListResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdelivery.model.Delivery;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct.DeliveryProductBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct.DeliveryProductResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.getdeliveryproduct.model.DeliveryProduct;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse.WarehouseBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse.WarehouseResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.delivery.datamodel.warehouse.model.Warehouse;
import com.esotacredit.esotaapi.api.ecommerce.nodes.DroppedNodes;
import com.esotacredit.esotaapi.api.ecommerce.payments.PaymentState;
import com.esotacredit.esotaapi.api.ecommerce.payments.ipnlistener.IpnBody;
import com.esotacredit.esotaapi.api.ecommerce.payments.ipnlistener.IpnResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.products.datamodel.ProductBody;
import com.esotacredit.esotaapi.api.ecommerce.products.datamodel.ProductResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.products.datamodel.RelatedProductBody;
import com.esotacredit.esotaapi.api.ecommerce.products.objects.Image;
import com.esotacredit.esotaapi.api.ecommerce.products.objects.Network;
import com.esotacredit.esotaapi.api.ecommerce.products.objects.Product;
import com.esotacredit.esotaapi.api.ecommerce.products.objects.Shop;
import com.esotacredit.esotaapi.api.ecommerce.products.productdetails.ProductDetailsBody;
import com.esotacredit.esotaapi.api.ecommerce.products.productdetails.ProductDetailsResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.products.recomended.RecomendedBody;
import com.esotacredit.esotaapi.api.ecommerce.products.recomended.RecomendedProductResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.searching.SearchingBody;
import com.esotacredit.esotaapi.api.ecommerce.searching.SearchingResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.PendingBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.PendingResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpending.objects.Pending;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased.PurchasedBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased.PurchasedResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.getpurchased.objects.Purchased;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference.PendingReferenceBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference.PendingReferenceResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.pendingreference.objects.PendingReference;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference.PurchasedReferenceBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference.PurchasedReferenceResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.sells.datamodel.purchasedreference.objects.PurchasedReference;
import com.esotacredit.esotaapi.api.ecommerce.shop.object.ShopInfo;
import com.esotacredit.esotaapi.api.ecommerce.shop.qualified.QualifiedShopBody;
import com.esotacredit.esotaapi.api.ecommerce.shop.qualified.QualifiedShopResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.sold.datamodel.SaveAsSoldBody;
import com.esotacredit.esotaapi.api.ecommerce.sold.datamodel.SaveAsSoldResponseBody;
import com.esotacredit.esotaapi.api.ecommerce.sold.objects.DeliveryInformation;
import com.esotacredit.esotaapi.api.ecommerce.sold.objects.SaveAsSoldResponseMessage;
import com.esotacredit.esotaapi.api.ecommerce.sold.objects.Sold;
import com.esotacredit.esotaapi.database.DatabaseConfiguration;
import com.esotacredit.esotaapi.utils.AppTimestamp;
import com.esotacredit.esotaapi.utils.LoadMore;
import com.esotacredit.esotaapi.utils.RandomGenerator;
import com.esotacredit.esotaapi.values.Values;

import org.springframework.stereotype.Component;

@Component
public class EcommerceDaoService {

    /**
     * @Fee Amount By Country
     */
    public static float getFee(int countryId){

        float fee = Values.EMPTY_OFF_VALUE;
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            String query_getFee = "SELECT * FROM fee WHERE country_id ='"+countryId+"' AND fee_status = '1' ";
            Statement stmt_fee = con.createStatement();
            ResultSet rs_fee =stmt_fee.executeQuery(query_getFee);

            while(rs_fee.next()){
                fee = Float.parseFloat(rs_fee.getString("fee_amount"));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fee;
    }

    /**
     * @Fee Amount By User Id
     */
    public static float getFeeByUserId(int userId){
        float fee = Values.EMPTY_OFF_VALUE;
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            String query_getFee = "SELECT * FROM country " +
                    "    INNER JOIN fee " +
                    "    ON fee.country_id = country.id " +
                    "    INNER JOIN user " +
                    "    ON user.country_id = country.id " +
                    "    WHERE user.id ='"+userId+"' AND fee_status = '1'";
            Statement stmt_fee = con.createStatement();
            ResultSet rs_fee =stmt_fee.executeQuery(query_getFee);

            while(rs_fee.next()){
                fee = Float.parseFloat(rs_fee.getString("fee_amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fee;
    }

    /**
     * @Search All Availble Product
     */
    SearchingResponseBody searching(SearchingBody searchingBody){

        List<Product> productsList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            productsList.clear();

            String query_getProducts = "SELECT " +
                    "country.id as country_id, " +
                    "currency.id as currency_id, " +
                    "currency.currency_abbreviation, " +
                    "product.id as product_id, " +
                    "items.item_name, " +
                    "items.description, " +
                    "shop.id as shop_id, " +
                    "shop.shopname, " +
                    "product.selling_price "+
                    "FROM " +
                    "country " +
                    "INNER JOIN currency " +
                    "ON country.currency_id=currency.id " +
                    "INNER JOIN product " +
                    "ON product.country_id = country.id " +
                    "INNER JOIN items " +
                    "ON product.item_id = items.id " +
                    "INNER JOIN shop " +
                    "ON product.shop_id=shop.id "+
                    "WHERE country.id = '"+searchingBody.getCountryId()+"' AND items.item_name LIKE '"+searchingBody.getText()+"%'";

            Statement stmt_user = con.createStatement();
            ResultSet rs_product =stmt_user.executeQuery(query_getProducts);

            /**
             * *********************************************************************************************************
             * Load Random Product from shops
             * *********************************************************************************************************
             */
            while(rs_product.next()){
                List<Image> imagesList = new ArrayList<>();
                //get user

                String query_getImages = "SELECT * FROM products_images  WHERE product_id ='"+rs_product.getInt("product_id")+"'";
                Statement stmt_image = con.createStatement();
                ResultSet rs_image =stmt_image.executeQuery(query_getImages);

                while(rs_image.next()){
                    Image images = new Image(rs_image.getInt("id"),Values.SERVER_ADDRESS+rs_image.getString("image_url")+Values.IMAGE_FILE_FORMAT);
                    imagesList.add(images);
                }

                float price = Float.parseFloat(rs_product.getString("selling_price"))+getFee(searchingBody.getCountryId());
                Product product = new Product(rs_product.getInt("product_id"),rs_product.getString("item_name"),String.format("%.0f",price),rs_product.getString("currency_abbreviation"),rs_product.getInt("shop_id"),rs_product.getString("shopname"),rs_product.getString("description"),imagesList);
                productsList.add(product);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new SearchingResponseBody(productsList);
    }


    /**
     * Get random product from all available shops
     * @param productBody
     * @return
     */
    ProductResponseBody getRandomProduct(ProductBody productBody){

        List<Product> productsList = new ArrayList<>();
        Network network = null;

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            productsList.clear();

            String query_getProducts = "SELECT " +
                    "country.id as country_id, " +
                    "currency.id as currency_id, " +
                    "currency.currency_abbreviation, " +
                    "product.id as product_id, " +
                    "items.item_name, " +
                    "items.description, " +
                    "shop.id as shop_id, " +
                    "shop.shopname, " +
                    "product.selling_price " +
                    "FROM " +
                    "country " +
                    "INNER JOIN currency " +
                    "ON country.currency_id=currency.id " +
                    "INNER JOIN product " +
                    "ON product.country_id = country.id " +
                    "INNER JOIN items " +
                    "ON product.item_id = items.id " +
                    "INNER JOIN shop " +
                    "ON product.shop_id=shop.id "+
                    "WHERE country.id ='"+productBody.getCountryId()+"'"+ LoadMore.getPage(productBody.getPage());


            Statement stmt_user = con.createStatement();
            ResultSet rs_product =stmt_user.executeQuery(query_getProducts);

            /**
             * *********************************************************************************************************
             * Check Network Status    |    @Update   20-June-2019
             * *********************************************************************************************************
             */
            //find user in network
            String query_findUserInNetwork = "SELECT *,COUNT(*) AS usercount FROM network WHERE user_id='"+productBody.getUserId()+"'";
            Statement stmt_findUserInNetwork = con.createStatement();
            ResultSet rs_findUserInNetwork =stmt_findUserInNetwork.executeQuery(query_findUserInNetwork);
            while (rs_findUserInNetwork.next()){
                if(rs_findUserInNetwork.getInt("usercount")>=1){
                    //get network status
                    network = new Network(true);
                }else {
                    //get network status
                    network = new Network(false);
                }
            }

            /**
             * *********************************************************************************************************
             * Load Random Product from shops
             * *********************************************************************************************************
             */
            while(rs_product.next()){
                List<Image> imagesList = new ArrayList<>();
                //get user

                String query_getImages = "SELECT * FROM products_images  WHERE product_id ='"+rs_product.getInt("product_id")+"'";
                Statement stmt_image = con.createStatement();
                ResultSet rs_image =stmt_image.executeQuery(query_getImages);

                while(rs_image.next()){
                     Image images = new Image(rs_image.getInt("id"),Values.SERVER_ADDRESS+rs_image.getString("image_url")+Values.IMAGE_FILE_FORMAT);
                     imagesList.add(images);
                }

                float price = Float.parseFloat(rs_product.getString("selling_price"))+getFee(productBody.getCountryId());
                Product product = new Product(rs_product.getInt("product_id"),rs_product.getString("item_name"),String.format("%.0f",price),rs_product.getString("currency_abbreviation"),rs_product.getInt("shop_id"),rs_product.getString("shopname"),rs_product.getString("description"),imagesList);
                productsList.add(product);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        /**
         * Count Cart | Sold | Delivery
         */
        int cartSize = getCartSize(productBody.getUserId()); //getCart(new CartBody(productBody.getUserId())).getCartList().size();
        int soldItems = getPendingReferenceList(new PendingReferenceBody(productBody.getUserId())).getPendingReferenceList().size();
        int deliveryItemsSize = getDeliveries(new DeliveryListBody(productBody.getUserId())).getDeliveryList().size();

        return new ProductResponseBody(new Shop(cartSize,soldItems,deliveryItemsSize,productsList),network);
    }


    QualifiedShopResponseBody getQualifiedShopList(QualifiedShopBody qualifiedShopBody){

        List<ShopInfo>shopInfoList = new ArrayList<>();

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            String query_getQualifiedShop = "SELECT * FROM shop WHERE country_id = "+qualifiedShopBody.getCountryId();

            Statement stmt_qualifiedShops = con.createStatement();
            ResultSet rs_shoplist =stmt_qualifiedShops.executeQuery(query_getQualifiedShop);

            while(rs_shoplist.next()){
                ShopInfo shopInfo = new ShopInfo(rs_shoplist.getInt("id"),rs_shoplist.getString("tagline"),rs_shoplist.getString("shopname"));
                shopInfoList.add(shopInfo);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new QualifiedShopResponseBody(shopInfoList);
    }


    CategoryResponseBody getCategories(CategoryBody categoryBody){

        List<Category> categoryList = new ArrayList<>();

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            //get user
            categoryList.clear();

            String query_getProductsCategory = "SELECT * FROM product_category";

            Statement stmt_prductCategory = con.createStatement();
            ResultSet rs_categories =stmt_prductCategory.executeQuery(query_getProductsCategory);

            /**
             * *********************************************************************************************************
             * Load Random Product from categories
             * *********************************************************************************************************
             */
            while(rs_categories.next()){
                //get user
                List<CategoryProduct> categoryProductList = new ArrayList<>();

                String query_getProduct = "SELECT " +
                        "country.id as country_id, " +
                        "currency.id as currency_id, " +
                        "currency.currency_abbreviation, " +
                        "product.id as product_id, " +
                        "items.item_name, " +
                        "items.description, " +
                        "shop.id as shop_id, " +
                        "shop.shopname, " +
                        "product.selling_price " +
                        "FROM " +
                        "country " +
                        "INNER JOIN currency " +
                        "ON country.currency_id=currency.id  " +
                        "INNER JOIN product " +
                        "ON product.country_id = country.id  " +
                        "INNER JOIN items " +
                        "ON product.item_id = items.id  " +
                        "INNER JOIN shop " +
                        "ON product.shop_id=shop.id "+
                        "WHERE items.category_id ='"+rs_categories.getInt("id")+"'";

                //String query_getProduct = "SELECT * FROM product  WHERE category_id ='"+rs_categories.getInt("id")+"'";
                Statement stmt_product = con.createStatement();
                ResultSet rs_product =stmt_product.executeQuery(query_getProduct);

                while(rs_product.next()){
                    List<ProductImage> imagesList = new ArrayList<>();
                    //get user

                    String query_getImages = "SELECT * FROM products_images  WHERE product_id ='"+rs_product.getInt("product_id")+"'";
                    Statement stmt_image = con.createStatement();
                    ResultSet rs_image =stmt_image.executeQuery(query_getImages);

                    while(rs_image.next()){
                        ProductImage images = new ProductImage(rs_image.getInt("id"),Values.SERVER_ADDRESS+rs_image.getString("image_url")+Values.IMAGE_FILE_FORMAT);
                        imagesList.add(images);
                    }

                    float price = Float.parseFloat(rs_product.getString("selling_price"))+getFee(categoryBody.getCountryId());
                    CategoryProduct categoryProduct = new CategoryProduct(rs_product.getInt("product_id"),rs_product.getString("item_name"),String.format("%.0f",price),rs_product.getString("currency_abbreviation"),rs_product.getInt("shop_id"),rs_product.getString("shopname"),rs_product.getString("description"),imagesList);
                    categoryProductList.add(categoryProduct);
                }

                Category category = new Category(rs_categories.getInt("id"),rs_categories.getString("category_name"),rs_categories.getString("tagline"),rs_categories.getString("category_icon_url"),categoryProductList);
                categoryList.add(category);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  new CategoryResponseBody(categoryList);
    }


    RecomendedProductResponseBody getRecomendedProduct(RecomendedBody recomendedBody){
        List<Product> productsList = new ArrayList<>();

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            productsList.clear();

            String query_getProducts = "SELECT " +
                    "country.id as country_id, " +
                    "currency.id as currency_id, " +
                    "currency.currency_abbreviation, " +
                    "product.id as product_id, " +
                    "items.item_name, " +
                    "items.description, " +
                    "shop.id as shop_id, " +
                    "shop.shopname, " +
                    "product.selling_price " +
                    "FROM " +
                    "country " +
                    "INNER JOIN currency " +
                    "ON country.currency_id=currency.id " +
                    "INNER JOIN product " +
                    "ON product.country_id = country.id " +
                    "INNER JOIN items " +
                    "ON product.item_id = items.id " +
                    "INNER JOIN shop " +
                    "ON product.shop_id=shop.id "+
                    "WHERE country.id ='"+recomendedBody.getCountryId()+"'"+ LoadMore.getPage(recomendedBody.getPage());

            Statement stmt_user = con.createStatement();
            ResultSet rs_product =stmt_user.executeQuery(query_getProducts);

            /**
             * *********************************************************************************************************
             * Load Random Product from shops
             * *********************************************************************************************************
             */
            while(rs_product.next()){
                List<Image> imagesList = new ArrayList<>();
                //get user

                String query_getImages = "SELECT * FROM products_images  WHERE product_id ='"+rs_product.getInt("product_id")+"'";
                Statement stmt_image = con.createStatement();
                ResultSet rs_image =stmt_image.executeQuery(query_getImages);

                while(rs_image.next()){
                    Image images = new Image(rs_image.getInt("id"),Values.SERVER_ADDRESS+rs_image.getString("image_url")+Values.IMAGE_FILE_FORMAT);
                    imagesList.add(images);
                }

                float price = Float.parseFloat(rs_product.getString("selling_price"))+getFee(recomendedBody.getCountryId());
                Product product = new Product(rs_product.getInt("product_id"),rs_product.getString("item_name"),String.format("%.0f",price),rs_product.getString("currency_abbreviation"),rs_product.getInt("shop_id"),rs_product.getString("shopname"),rs_product.getString("description"),imagesList);
                productsList.add(product);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new RecomendedProductResponseBody(productsList);
    }


    RecomendedProductResponseBody getRelatedProduct(RelatedProductBody relatedProductBody){

        List<Product> productsList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            productsList.clear();

            /**
             * Get category Id
             */
            int categoryId = Values.EMPTY_OFF_VALUE;
            String query_getCategory = "SELECT category_id FROM items " +
                    "INNER join product " +
                    "ON product.item_id = items.id " +
                    "WHERE product.id='"+relatedProductBody.getProductId()+"' ";

            Statement stmt_category = con.createStatement();
            ResultSet rs_categories =stmt_category.executeQuery(query_getCategory);
            while(rs_categories.next()){
                categoryId = rs_categories.getInt("category_id");
            }

            String query_getProducts = "SELECT " +
                    "country.id as country_id, " +
                    "currency.id as currency_id, " +
                    "currency.currency_abbreviation, " +
                    "product.id as product_id, " +
                    "items.item_name, " +
                    "items.description, " +
                    "shop.id as shop_id, " +
                    "shop.shopname, " +
                    "product.selling_price " +
                    "FROM " +
                    "country " +
                    "INNER JOIN currency " +
                    "ON country.currency_id=currency.id " +
                    "INNER JOIN product " +
                    "ON product.country_id = country.id " +
                    "INNER JOIN items " +
                    "ON product.item_id = items.id " +
                    "INNER JOIN shop " +
                    "ON product.shop_id=shop.id "+
                    "WHERE category_id = '"+categoryId+"' AND country.id ='"+relatedProductBody.getCountryId()+"'"+ LoadMore.getPage(relatedProductBody.getPage());

            Statement stmt_user = con.createStatement();
            ResultSet rs_product =stmt_user.executeQuery(query_getProducts);

            /**
             * *********************************************************************************************************
             * Load Random Product from shops
             * *********************************************************************************************************
             */
            while(rs_product.next()){
                List<Image> imagesList = new ArrayList<>();
                //get user

                String query_getImages = "SELECT * FROM products_images  WHERE product_id ='"+rs_product.getInt("product_id")+"'";
                Statement stmt_image = con.createStatement();
                ResultSet rs_image =stmt_image.executeQuery(query_getImages);

                while(rs_image.next()){
                    Image images = new Image(rs_image.getInt("id"),Values.SERVER_ADDRESS+rs_image.getString("image_url")+Values.IMAGE_FILE_FORMAT);
                    imagesList.add(images);
                }

                float price = Float.parseFloat(rs_product.getString("selling_price"))+getFee(relatedProductBody.getCountryId());
                Product product = new Product(rs_product.getInt("product_id"),rs_product.getString("item_name"),String.format("%.0f",price),rs_product.getString("currency_abbreviation"),rs_product.getInt("shop_id"),rs_product.getString("shopname"),rs_product.getString("description"),imagesList);
                productsList.add(product);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new RecomendedProductResponseBody(productsList);
    }


    ProductDetailsResponseBody getProductDetails(ProductDetailsBody productDetailsBody){
        ProductDetailsResponseBody productDetails = null;
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
        String query_getProduct = "SELECT " +
                "country.id as country_id, " +
                "currency.id as currency_id, " +
                "currency.currency_abbreviation, " +
                "product.id as product_id, " +
                "items.item_name, " +
                "items.description, " +
                "shop.id as shop_id, " +
                "shop.shopname, " +
                "product.selling_price, " +
                "fee.fee_amount " +
                "FROM " +
                "country " +
                "INNER JOIN currency " +
                "ON country.currency_id=currency.id  " +
                "INNER JOIN product " +
                "ON product.country_id = country.id  " +
                "INNER JOIN items " +
                "ON product.item_id = items.id  " +
                "INNER JOIN shop " +
                "ON product.shop_id=shop.id "+
                "INNER JOIN fee " +
                "ON fee.country_id =  product.country_id " +
                "WHERE product.id ='"+productDetailsBody.getProductId()+"'";

        Statement stmt_product = con.createStatement();
        ResultSet rs_product =stmt_product.executeQuery(query_getProduct);

        while(rs_product.next()){
            List<Image> imagesList = new ArrayList<>();
            //get user

            String query_getImages = "SELECT * FROM products_images  WHERE product_id ='"+rs_product.getInt("product_id")+"'";
            Statement stmt_image = con.createStatement();
            ResultSet rs_image =stmt_image.executeQuery(query_getImages);

            while(rs_image.next()){
                Image images = new Image(rs_image.getInt("id"),Values.SERVER_ADDRESS+rs_image.getString("image_url")+Values.IMAGE_FILE_FORMAT);
                imagesList.add(images);
            }

            float price = Float.parseFloat(rs_product.getString("selling_price"))+getFee(productDetailsBody.getCountryId());
            productDetails = new ProductDetailsResponseBody(rs_product.getInt("product_id"),rs_product.getString("item_name"),String.format("%.0f",price),rs_product.getString("fee_amount"),rs_product.getString("currency_abbreviation"),rs_product.getInt("shop_id"),rs_product.getString("shopname"),rs_product.getString("description"),imagesList);
        }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productDetails;
    }


    CartResponseBody getCart(CartBody cartBody){

        List<Cart>cartList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            String query_getCart = "SELECT *, " +
                    "SUM(cart.quantity) as cartsize " +
                    "FROM cart, " +
                    "product " +
                    "INNER JOIN items " +
                    "ON product.item_id=items.id " +
                    "WHERE cart.user_id = '"+cartBody.getUserId()+"' " +
                    "AND product.id = cart.product_id " +
                    "GROUP BY product_id";

            Statement stmt_user = con.createStatement();
            ResultSet rs_cart =stmt_user.executeQuery(query_getCart);

            while(rs_cart.next()){
                List<ImageCart>imageCartList = new ArrayList<>();
                Connection con_images = DatabaseConfiguration.getDatabeConnection();
                try {
                    //get user
                    String query_getImages = "SELECT * FROM products_images  WHERE product_id ='"+rs_cart.getInt("product_id")+"'";

                    Statement stmt_image = con_images.createStatement();
                    ResultSet rs_image =stmt_image.executeQuery(query_getImages);

                    while(rs_image.next()){
                        ImageCart images = new ImageCart(rs_image.getInt("id"),rs_image.getString("image_url")+Values.IMAGE_FILE_FORMAT);
                        imageCartList.add(images);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                float sellingPrice = (Float.parseFloat(rs_cart.getString("cart_selling_price")) * rs_cart.getInt("cartsize"));
                Cart cart = new Cart(rs_cart.getInt("product_id"),rs_cart.getString("item_name"),String.format("%.0f",sellingPrice),rs_cart.getInt("shop_id"),rs_cart.getInt("cartsize"),rs_cart.getString("network_fee"),imageCartList);
                cartList.add(cart);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new CartResponseBody(cartList);
    }

    AddCartItemResponseBody addCart(AddCartItemBody addCartItemBody){
        ResponseMessage responseMessage = null;

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            int stockSize=Values.EMPTY_OFF_VALUE;
            int cartStockSize=Values.EMPTY_OFF_VALUE;
            int aggregateSize=Values.EMPTY_OFF_VALUE;
            String response = Values.EMPY_STRING;
            String fee="0";

            //Find Fee
            String query_getFee = "SELECT * FROM country " +
                    "INNER JOIN fee " +
                    "ON fee.country_id = country.id " +
                    "INNER JOIN user " +
                    "ON user.country_id = country.id " +
                    "WHERE user.id ='"+addCartItemBody.getUserId()+"' AND fee_status = '1'";

            Statement stmt_Fee = con.createStatement();
            ResultSet rs_fee =stmt_Fee.executeQuery(query_getFee);

            while(rs_fee.next()){
                fee = rs_fee.getString("fee_amount");
            }

            //Check if Quantity Available in Stock
            String query_getStockSize = "SELECT quantity AS stocksize FROM product WHERE id='"+addCartItemBody.getProductId()+"'";

            Statement stmt_stockSize = con.createStatement();
            ResultSet rs_stockSize =stmt_stockSize.executeQuery(query_getStockSize);

            while(rs_stockSize.next()){
                stockSize = rs_stockSize.getInt("stocksize");
            }

            //Check if Quantity Available in Stock
            String query_getCartStockSize = "SELECT SUM(quantity) AS cartstocksize FROM cart WHERE product_id='"+addCartItemBody.getProductId()+"' and user_id='"+addCartItemBody.getUserId()+"'";

            Statement stmt_CartStockSize = con.createStatement();
            ResultSet rs_CartStockSize =stmt_CartStockSize.executeQuery(query_getCartStockSize);

            while(rs_CartStockSize.next()){
                cartStockSize = rs_CartStockSize.getInt("cartstocksize");
            }

            aggregateSize = stockSize - cartStockSize;

            if(addCartItemBody.getQuantity()<=aggregateSize) {
                String query_createuser = "INSERT INTO cart " +
                        "(id,product_id,user_id,cart_selling_price,network_fee,quantity) \n" +
                        "VALUES (?,?,?,?,?,?)";

                //save trip
                PreparedStatement preparedStatement = con.prepareStatement(query_createuser);
                preparedStatement.setInt(1, Values.EMPTY_OFF_VALUE);
                preparedStatement.setInt(2, addCartItemBody.getProductId());
                preparedStatement.setInt(3, addCartItemBody.getUserId());
                preparedStatement.setString(4, String.valueOf(addCartItemBody.getSellingPrice()));
                preparedStatement.setString(5, fee);
                preparedStatement.setInt(6, addCartItemBody.getQuantity());
                preparedStatement.execute();

                response = "Item Added to Cart Successfuly";

            }else {
                response = "Quantity Exceeds the available stock";
            }

            responseMessage = new ResponseMessage(response);

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new AddCartItemResponseBody(responseMessage);
    }

    DeleteCartItemResponseBody deleteCart(DeleteCartItemBody deleteCartItemBody){
        ResponseMessage responseMessage = null;
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            String query_deleteCartItem = "DELETE FROM cart  WHERE product_id ='"+deleteCartItemBody.getProductId()+"' AND  user_id ='"+deleteCartItemBody.getUserId()+"'";

            Statement stmt_deleteCartItem = con.createStatement();
            stmt_deleteCartItem.execute(query_deleteCartItem);
            responseMessage = new ResponseMessage("Item Deleted from Cart Successfuly");

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new DeleteCartItemResponseBody(responseMessage);
    }

    int getCartSize(int userId){
        int cartSize=Values.EMPTY_OFF_VALUE;
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try{

        String query_getCartSize = "SELECT SUM(quantity) AS cartsize FROM  cart  WHERE user_id='"+userId+"'";
        Statement stmt_stockSize = con.createStatement();
        ResultSet rs_stockSize =stmt_stockSize.executeQuery(query_getCartSize);

        while(rs_stockSize.next()){
            cartSize = rs_stockSize.getInt("cartsize");
        }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartSize;
    }

    UpdateCartResponseBody updateCart(UpdateCartBody updateCartBody){
        LinkedList<CartProduct> cartProductList = new LinkedList<>();
        ResponseMessage responseMessage = null;

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            String query_getCartProducts = "SELECT * FROM cart WHERE user_id='"+updateCartBody.getUserId()+"' AND product_id='"+updateCartBody.getProductId()+"'";

            Statement stmt_cartProduct = con.createStatement();
            ResultSet rs_cartProduct =stmt_cartProduct.executeQuery(query_getCartProducts);

            while(rs_cartProduct.next()){
                CartProduct product = new CartProduct(rs_cartProduct.getInt("id"),rs_cartProduct.getInt("product_id"),rs_cartProduct.getInt("user_id"),rs_cartProduct.getInt("quantity"));
                cartProductList.add(product);
            }

            String Upprice="0";
            String Upfee="0";

            String query_getCart = "SELECT * FROM cart  WHERE product_id ='"+cartProductList.get(0).getProductId()+"' AND id ='"+cartProductList.get(0).getCartId()+"' AND  user_id= '"+cartProductList.get(0).getUserId()+"'";

            Statement stmt_cart = con.createStatement();
            ResultSet rs_cart =stmt_cart.executeQuery(query_getCart);

            while(rs_cart.next()){
                Upfee = rs_cart.getString("network_fee");
                Upprice = rs_cart.getString("cart_selling_price");
            }

            String query_deleteCartItem = "DELETE FROM cart  WHERE product_id ='"+updateCartBody.getProductId()+"' AND  user_id ='"+updateCartBody.getUserId()+"'";
            Statement stmt_deleteCartItem = con.createStatement();
            stmt_deleteCartItem.execute(query_deleteCartItem);

            //get fee and price

            //insert new value
            String query_updateCart = "INSERT INTO cart " +
                    "(id,product_id,user_id,cart_selling_price,network_fee,quantity) \n" +
                    "VALUES (?,?,?,?,?,?)";

            //save trip
            PreparedStatement preparedStatement = con.prepareStatement(query_updateCart);
            preparedStatement.setInt(1, Values.EMPTY_OFF_VALUE);
            preparedStatement.setInt(2, updateCartBody.getProductId());
            preparedStatement.setInt(3, updateCartBody.getUserId());
            preparedStatement.setString(4, Upprice);
            preparedStatement.setString(5, Upfee);
            preparedStatement.setInt(6, updateCartBody.getUpdateQuantity());
            preparedStatement.execute();

            responseMessage = new ResponseMessage("Updated Successfuly");

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            responseMessage = new ResponseMessage("Failed to update");
        }

        return new UpdateCartResponseBody();
    }

    /**
     * Helper method (Print Linked List)
     * @param cartProducts
     */
    private void printCartList(LinkedList<CartProduct> cartProducts){
        for(int i=0; i<cartProducts.size(); i++){
            CartProduct item = cartProducts.get(i);
            System.out.println("cart Id: "+item.getCartId()+" product Id:"+item.getProductId()+" user Id:"+item.getUserId()+" quantity:"+item.getQuantity());
        }
    }

    SaveAsSoldResponseBody saveAsSold(SaveAsSoldBody saveAsSoldBody){

        DeliveryInformation deliveryInformation = saveAsSoldBody.getDeliveryInformation();
        List<Sold> soldList = saveAsSoldBody.getSold();

        SaveAsSoldResponseMessage responseMessage = null;
        String createdTime = String.valueOf(new AppTimestamp().currentTimeStamp());
        String referenceNumber = new RandomGenerator().getReferenceNumber();
        String deliveryNumber = new RandomGenerator().getVerificationCode();
        String deliveryFee = String.valueOf(deliveryInformation.getDeliveryFee());
        int deliveryStatus = Values.EMPTY_OFF_VALUE;
        int deliveryState = Values.EMPTY_OFF_VALUE;
        int paymentStatus = Values.PAYMENT_NULL;

        String message = Values.EMPY_STRING;

        switch (deliveryInformation.getPaymentTypeCode()){
            case 100200:
                deliveryState = Values.EMPTY_OFF_VALUE;
                paymentStatus = Values.PAYMENT_NULL;
                break;
            case 300400:
                deliveryState = Values.EMPTY_ACTIVE_VALUE;
                paymentStatus = Values.PAYMENT_PENDING;
                break;
            case 500600:
                deliveryState = Values.EMPTY_ACTIVE_VALUE;
                paymentStatus = Values.PAYMENT_PENDING;
                break;
        }

        /**
         * Create Sell & Delivery
         */
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            //Check if Stock Available
            int stockSize=Values.EMPTY_OFF_VALUE;
            int cartStockSize=Values.EMPTY_OFF_VALUE;
            boolean key[]=new boolean[soldList.size()];
            boolean save=true;
            String response = Values.EMPY_STRING;

            for(int i=0; i<soldList.size(); i++){

                Sold sold = soldList.get(i);
                //Check if Quantity Available in Stock
                String query_getStockSize = "SELECT quantity AS stocksize FROM product WHERE id='"+sold.getProductId()+"'";

                Statement stmt_stockSize = con.createStatement();
                ResultSet rs_stockSize =stmt_stockSize.executeQuery(query_getStockSize);

                while(rs_stockSize.next()){
                    stockSize = rs_stockSize.getInt("stocksize");
                }

                System.out.println("product id = "+sold.getProductId()+" quantity = "+sold.getQuantity()+" stock = "+stockSize);
                if(sold.getQuantity()<=stockSize){
                    key[i]= true;
                }else {
                    key[i]= false;
                }
            }

            for(int i=0; i<soldList.size(); i++){
                if(!key[i]){
                    save = false;
                }
            }

            if(save) {

                String query_createsell = "INSERT INTO sells " +
                        "(id,product_id,quantity,created_time,user_id,reference_number,payment_status,payment_time,location_id,address_note,payment_type_id,payment_type_code,delivery_status,delivery_state,delivery_number,selling_price,network_fee,delivery_fee,total_amount) \n" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                //create sells
                PreparedStatement preparedStatementSell = con.prepareStatement(query_createsell);

                //create sells
                for (int i = 0; i < soldList.size(); i++) {
                    Sold sold = soldList.get(i);
                    preparedStatementSell.setInt(1, Values.EMPTY_OFF_VALUE);
                    preparedStatementSell.setInt(2, sold.getProductId());
                    preparedStatementSell.setInt(3, sold.getQuantity());
                    preparedStatementSell.setString(4, createdTime);
                    preparedStatementSell.setInt(5, sold.getUserId());
                    preparedStatementSell.setString(6, referenceNumber);
                    preparedStatementSell.setInt(7, paymentStatus);
                    preparedStatementSell.setString(8, createdTime);
                    preparedStatementSell.setInt(9, deliveryInformation.getLocationId());
                    preparedStatementSell.setString(10, deliveryInformation.getAddressNote());
                    preparedStatementSell.setInt(11, deliveryInformation.getPaymentTypeId());
                    preparedStatementSell.setInt(12, deliveryInformation.getPaymentTypeCode());
                    preparedStatementSell.setInt(13, deliveryStatus);
                    preparedStatementSell.setInt(14, deliveryState);
                    preparedStatementSell.setString(15, deliveryNumber);
                    preparedStatementSell.setString(16, String.valueOf(sold.getSellingPrice()));
                    preparedStatementSell.setString(17, String.valueOf(sold.getNetworkFee()));
                    preparedStatementSell.setString(18, deliveryFee);
                    preparedStatementSell.setString(19, String.valueOf(( (sold.getSellingPrice()+sold.getNetworkFee()) * sold.getQuantity()) + deliveryInformation.getDeliveryFee()));
                    preparedStatementSell.execute();
                }

                /**
                 *Delete Item from cart and Update Stock
                 */
                for (int i = 0; i < soldList.size(); i++) {

                    Sold sold = soldList.get(i);
                    String query_deleteCartItem = "DELETE FROM cart  WHERE product_id ='" + sold.getProductId() + "' AND  user_id ='" + sold.getUserId() + "'";
                    Statement stmt_deleteCartItem = con.createStatement();
                    stmt_deleteCartItem.execute(query_deleteCartItem);

                    int stock=0;
                    //Check if Quantity Available in Stock
                    String query_getStockSize = "SELECT quantity AS stocksize FROM product WHERE id='"+sold.getProductId()+"'";

                    Statement stmt_stockSize = con.createStatement();
                    ResultSet rs_stockSize =stmt_stockSize.executeQuery(query_getStockSize);
                    while(rs_stockSize.next()){
                        stock = rs_stockSize.getInt("stocksize");
                    }

                    //Update Queue
                    String query_updateStock = "UPDATE product " +
                            "   SET quantity = '"+(stock-sold.getQuantity())+"' " +
                            "   WHERE id = '"+sold.getProductId()+"'";
                    Statement st_queueUpdate = con.createStatement();
                    st_queueUpdate.executeUpdate(query_updateStock);

                }

                responseMessage = new SaveAsSoldResponseMessage("Item purchased Successfuly");

            }else {
                responseMessage = new SaveAsSoldResponseMessage("Item out of Stock");
            }


            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new SaveAsSoldResponseBody(responseMessage);
    }


    /**
     * Get delivery list
     */
    DeliveryListResponseBody getDeliveries(DeliveryListBody deliveryListBody){

        List<Delivery> deliveryList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            String query_getDelivery = "SELECT *,sum(sells.selling_price+sells.delivery_fee) as totalprice,sells.quantity as sellsquantity ,locations.delivery_time as deliverytime " +
                    "FROM " +
                    "sells " +
                    "INNER JOIN product " +
                    "ON sells.product_id=product.id " +
                    "INNER JOIN shop " +
                    "ON product.shop_id=shop.id " +
                    "INNER JOIN locations " +
                    "ON sells.location_id = locations.id " +
                    "WHERE sells.payment_status='1' " +
                    "AND sells.delivery_state='1' " +
                    "AND sells.user_id='"+deliveryListBody.getUserId()+"' " +
                    "GROUP BY reference_number ";

            Statement stmt_delivery = con.createStatement();
            ResultSet rs_delivery =stmt_delivery.executeQuery(query_getDelivery);

            while(rs_delivery.next()){

                String deliveryFee;
                String deliveryTime;

                boolean status = false;
                String message = Values.EMPY_STRING;
                int payment_status = rs_delivery.getInt("payment_status");
                int payment_type_code = rs_delivery.getInt("payment_type_code");

                switch (payment_status){
                    case 0:
                        status = false;
                        message = "INVALID";
                        break;
                    case 1:
                        status = false;
                        message = "PENDING";
                        break;
                    case 2:
                        status = true;
                        message = "COMPLETED";
                        break;
                }

                /**
                 * Switch information according to payment types
                 */
                if(payment_type_code==500600){
                    deliveryFee = "0.00";
                    deliveryTime = "Please Visit our Store to pick Your Product";
                }else {
                     deliveryFee = rs_delivery.getString("delivery_fee");
                     deliveryTime = rs_delivery.getString("deliverytime");
                }

                Delivery delivery = new Delivery(
                        rs_delivery.getInt("user_id"),
                        rs_delivery.getString("reference_number"),
                        rs_delivery.getString("created_time"),
                        new PaymentState(status,message),
                        rs_delivery.getString("payment_time"),
                        rs_delivery.getInt("payment_type_id"),
                        rs_delivery.getInt("payment_type_code"),
                        rs_delivery.getInt("delivery_status"),
                        rs_delivery.getInt("delivery_state"),
                        rs_delivery.getInt("delivery_number"),
                        rs_delivery.getString("location_name"),
                        rs_delivery.getString("address_note"),
                        deliveryFee,
                        deliveryTime,
                        rs_delivery.getString("totalprice"),
                        rs_delivery.getString("network_fee"),
                        rs_delivery.getInt("sellsquantity"));
                deliveryList.add(delivery);

            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new DeliveryListResponseBody(deliveryList);
    }


    DeliveryProductResponseBody getDeliveryProductList(DeliveryProductBody deliveryProductBody){

        List<DeliveryProduct> productsList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            productsList.clear();

            String query_getProducts = "SELECT * " +
                    "FROM " +
                    "sells " +
                    "INNER JOIN product " +
                    "ON sells.product_id=product.id " +
                    "INNER JOIN items " +
                    "ON product.item_id = items.id " +
                    "WHERE sells.payment_status='1' AND sells.reference_number='"+deliveryProductBody.getReferenceNumber()+"'" +
                    "AND sells.user_id='"+deliveryProductBody.getUserId()+"'";

            Statement stmt_user = con.createStatement();
            ResultSet rs_product =stmt_user.executeQuery(query_getProducts);

            /**
             * *********************************************************************************************************
             * Load Random Product from shops
             * *********************************************************************************************************
             */
            while(rs_product.next()){
                List<Image> imagesList = new ArrayList<>();
                //get user

                String query_getImages = "SELECT * FROM products_images  WHERE product_id ='"+rs_product.getInt("product_id")+"'";
                Statement stmt_image = con.createStatement();
                ResultSet rs_image =stmt_image.executeQuery(query_getImages);

                while(rs_image.next()){
                    Image images = new Image(rs_image.getInt("id"),Values.SERVER_ADDRESS+rs_image.getString("image_url")+Values.IMAGE_FILE_FORMAT);
                    imagesList.add(images);
                }

                DeliveryProduct product = new DeliveryProduct(rs_product.getInt("product_id"),rs_product.getString("item_name"),imagesList.get(0).getImageUrl());
                productsList.add(product);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new DeliveryProductResponseBody(productsList);
    }



    DeleteDeliveryItemResponseBody deleteDeliveredItem(DeleteDeliveryItemBody deleteDeliveryItemBody){
        DeleteDeliveryResponseMessage responseMessage = null;

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            //get user
            String query_deleteDeliveryItem = "DELETE FROM delivery WHERE user_id ='"+deleteDeliveryItemBody.getUserId()+"' AND  item_reference_number ='"+deleteDeliveryItemBody.getReferenceNumber()+"'";

            Statement stmt_deleteCartItem = con.createStatement();
            stmt_deleteCartItem.execute(query_deleteDeliveryItem);
            responseMessage = new DeleteDeliveryResponseMessage("Delivered Item Deleted Successfuly");

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new DeleteDeliveryItemResponseBody(responseMessage);
    }


    /**
     * Warehouse List
     */
    WarehouseResponseBody getWarehouse(WarehouseBody warehouseBody){
        List<Warehouse> warehouseList = new ArrayList<>();

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            String query_getWarehouse = "SELECT " +
                    "warehouse.id AS warehouse_id, " +
                    "warehouse_name AS warehouse_name, " +
                    "location_name AS warehouse_location, " +
                    "warehouse_address " +
                    "FROM warehouse " +
                    "INNER JOIN locations " +
                    "ON warehouse.location_id = locations.id " +
                    "INNER JOIN user " +
                    "ON user.country_id=locations.country_id " +
                    "WHERE user.id = '"+warehouseBody.getUserId()+"' AND location_id='"+warehouseBody.getLocationId()+"'" ;

            Statement stmt_warehouse = con.createStatement();
            ResultSet rs_warehouse =stmt_warehouse.executeQuery(query_getWarehouse);

            while(rs_warehouse.next()){
                Warehouse warehouse = new Warehouse(rs_warehouse.getInt("warehouse_id"),rs_warehouse.getString("warehouse_name"),rs_warehouse.getString("warehouse_location"),rs_warehouse.getString("warehouse_address"));
                warehouseList.add(warehouse);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new WarehouseResponseBody(warehouseList);
    }



    /**
     * Get Pending Reference list
     */
    PendingReferenceResponseBody getPendingReferenceList(PendingReferenceBody pendingReferenceBody){

        List<PendingReference> pendingReferenceList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            String query_getPending = "SELECT * " +
                    "FROM " +
                    "sells " +
                    "INNER JOIN product " +
                    "ON sells.product_id=product.id\n" +
                    "INNER JOIN shop " +
                    "ON product.shop_id=shop.id " +
                    "WHERE sells.payment_status='1' OR sells.payment_status='0' " +
                    "AND sells.user_id='"+pendingReferenceBody.getUserId()+"' " +
                    "GROUP BY reference_number";

            Statement stmt_delivery = con.createStatement();
            ResultSet rs_pendingReference =stmt_delivery.executeQuery(query_getPending);

            while(rs_pendingReference.next()){
                PendingReference pending = new PendingReference(rs_pendingReference.getString("reference_number"),rs_pendingReference.getString("created_time"),Float.parseFloat(String.format("%.0f",Float.parseFloat(rs_pendingReference.getString("total_amount")))),new PaymentState(false,"PENDING"),rs_pendingReference.getInt("quantity"));
                pendingReferenceList.add(pending);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new PendingReferenceResponseBody(pendingReferenceList);
    }


    /**
     * Get Pending list
     */
    PendingResponseBody getPendingList(PendingBody pendingBody){

        List<Pending> pendingBodyList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            String query_getPending = "SELECT * " +
                    "FROM " +
                    "sells " +
                    "INNER JOIN product " +
                    "ON sells.product_id=product.id " +
                    "INNER JOIN items " +
                    "ON product.item_id=items.id " +
                    "INNER JOIN shop " +
                    "ON product.shop_id=shop.id " +
                    "WHERE user_id ='"+pendingBody.getUserId()+"'  AND payment_status ='0'  OR payment_status='1'  AND  delivery_state = '0'  AND reference_number='"+pendingBody.getReferenceNumber()+"' ";
            Statement stmt_delivery = con.createStatement();
            ResultSet rs_pending =stmt_delivery.executeQuery(query_getPending);

            while(rs_pending.next()){
                Pending pending = new Pending(rs_pending.getInt("product_id"),rs_pending.getString("item_name"),rs_pending.getInt("shop_id"),rs_pending.getString("shopname"),rs_pending.getString("selling_price"),rs_pending.getString("network_fee"),rs_pending.getString("reference_number"),rs_pending.getString("payment_time"),new PaymentState(false,"PENDING"));
                pendingBodyList.add(pending);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new PendingResponseBody(pendingBodyList);
    }


    /**
     * Get Paid (Purchased) Reference list
     */
    PurchasedReferenceResponseBody getPurchasedReferenceList(PurchasedReferenceBody purchasedReferenceBody){

        List<PurchasedReference> purchasedReferenceList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            String query_refPurchased = "select  * " +
                    "FROM sells,locations,product " +
                    "WHERE sells.location_id=locations.id " +
                    "AND  sells.product_id = product.id " +
                    "AND sells.delivery_state ='1' " +
                    "AND sells.user_id = '"+purchasedReferenceBody.getUserId()+"' " +
                    "AND sells.payment_status = '"+Values.PAYMENT_NULL+"' " +
                    "GROUP BY reference_number";

            Statement stmt_delivery = con.createStatement();
            ResultSet rs_pendingReference =stmt_delivery.executeQuery(query_refPurchased);

            while(rs_pendingReference.next()){
                PurchasedReference purchased = new PurchasedReference(rs_pendingReference.getString("reference_number"),rs_pendingReference.getString("created_time"),rs_pendingReference.getString("network_fee"),rs_pendingReference.getString("selling_price"),rs_pendingReference.getString("network_fee"),new PaymentState(true,"COMPLETED"),rs_pendingReference.getInt("quantity"));
                purchasedReferenceList.add(purchased);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new PurchasedReferenceResponseBody(purchasedReferenceList);
    }


    /**
     * Get Purchased list : By reference Number
     */
    PurchasedResponseBody getPurchasedList(PurchasedBody purchasedBody){
        List<Purchased> purchasedList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            String query_purchased = "SELECT * " +
                    "FROM  " +
                    "sells  " +
                    "INNER JOIN product " +
                    "ON sells.product_id=product.id " +
                    "INNER JOIN items " +
                    "ON product.item_id=items.id " +
                    "INNER JOIN shop " +
                    "ON product.shop_id=shop.id " +
                    "WHERE user_id ='"+purchasedBody.getUserId()+"'  AND payment_status ='"+Values.PAYMENT_COMPLETED+"'  AND  delivery_state = '"+Values.EMPTY_ACTIVE_VALUE+"' AND reference_number = '"+purchasedBody.getReferenceNumber()+"'   AND  payment_time = '"+purchasedBody.getPaymentDateAndTime()+"'";

            Statement stmt_delivery = con.createStatement();
            ResultSet rs_pending =stmt_delivery.executeQuery(query_purchased);

            while(rs_pending.next()){
                Purchased pending = new Purchased(rs_pending.getInt("product_id"),rs_pending.getString("item_name"),rs_pending.getInt("shop_id"),rs_pending.getString("shopname"),rs_pending.getString("selling_price"),rs_pending.getString("network_fee"),rs_pending.getString("reference_number"),rs_pending.getString("payment_time"),new PaymentState(true,"COMPLETED"));
                purchasedList.add(pending);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new PurchasedResponseBody(purchasedList);
    }

    /**
     * Get user allpurchased goods
     */
    /**
     * Get Purchased list
     */
    PurchasedResponseBody getAllUserPurchase(PurchasedBody purchasedBody){
        List<Purchased> purchasedList = new ArrayList<>();
        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {

            String query_purchased = "SELECT * " +
                    "FROM  " +
                    "sells  " +
                    "INNER JOIN product " +
                    "ON sells.product_id=product.id " +
                    "INNER JOIN items " +
                    "ON product.item_id=items.id " +
                    "INNER JOIN shop " +
                    "ON product.shop_id=shop.id " +
                    "WHERE user_id ='"+purchasedBody.getUserId()+"'  AND payment_status ='"+Values.PAYMENT_COMPLETED+"'  AND  delivery_state = '"+Values.EMPTY_ACTIVE_VALUE+"' "+LoadMore.getPage(purchasedBody.getPage());

            Statement stmt_delivery = con.createStatement();
            ResultSet rs_pending =stmt_delivery.executeQuery(query_purchased);

            while(rs_pending.next()){
                Purchased pending = new Purchased(rs_pending.getInt("product_id"),rs_pending.getString("item_name"),rs_pending.getInt("shop_id"),rs_pending.getString("shopname"),rs_pending.getString("selling_price"),rs_pending.getString("network_fee"),rs_pending.getString("reference_number"),rs_pending.getString("payment_time"),new PaymentState(true,"COMPLETED"));
                purchasedList.add(pending);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new PurchasedResponseBody(purchasedList);
    }


    /**
     * IPN Listener..
     */
    IpnResponseBody listernIPN(IpnBody ipnBody) {
         /*try {
            String ipnResult = new Pesapal(true).queryIpnListener(ipnBody.getReferenceNumber(),ipnBody.getTransactionId());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /**
         * Change payment Status & Create Network
         */
        /**
         * Create Sell & Delivery
         */

        Connection con = DatabaseConfiguration.getDatabeConnection();
        try {
            int userId = Values.EMPTY_OFF_VALUE;
            int countryId = Values.EMPTY_OFF_VALUE;
            String purchasingFee = Values.EMPY_STRING;
            String paymentTime = String.valueOf(new AppTimestamp().currentTimeStamp());

            //update sells
            String query_updatePayment = "UPDATE sells " +
                    "   SET payment_status = '"+Values.PAYMENT_COMPLETED+"' , delivery_state = '"+Values.EMPTY_ACTIVE_VALUE+"', payment_time = '"+paymentTime+"' , transaction_id = '"+ipnBody.getTransactionId()+"',  created_time = '"+ paymentTime +"'"+
                    "   WHERE reference_number = '"+ipnBody.getReferenceNumber()+"' AND (payment_status = '"+Values.PAYMENT_NULL+"' OR payment_status = '"+Values.PAYMENT_PENDING+"')";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(query_updatePayment);

            //get user  **V1
            String query_getuser = "SELECT * FROM sells  WHERE reference_number =  '"+ipnBody.getReferenceNumber()+"'  AND payment_status = '"+Values.PAYMENT_COMPLETED+"' ";

            //get user and fee **V2
            String query_getUserAndFee = "SELECT *FROM fee " +
                    "INNER JOIN country " +
                    "ON fee.country_id = fee.id " +
                    "INNER JOIN user " +
                    "ON user.country_id = country.id " +
                    "INNER JOIN sells " +
                    "ON sells.user_id = user.id " +
                    "WHERE sells.reference_number = '"+ipnBody.getReferenceNumber()+"'" +
                    "AND sells.payment_status = '"+Values.PAYMENT_COMPLETED+"'" +
                    "AND fee.country_id ='1'" +
                    "AND fee.fee_status = '1' " +
                    "GROUP BY user.id";

            Statement stmt_user = con.createStatement();
            ResultSet rs_user =stmt_user.executeQuery(query_getUserAndFee);

            while(rs_user.next()){
                userId = rs_user.getInt("user_id");
                countryId = rs_user.getInt("country_id");
                purchasingFee = rs_user.getString("fee_amount");
            }

            /**
             * *****************************************************************
             * CREATE NETWORK
             * *****************************************************************
             */

            /**
             * Add All dropped Nodes
             */
            List<DroppedNodes> droppedNodeQueue = new ArrayList<>();
            String query_fetchAllNodes = "SELECT *FROM nodesqueue WHERE state = '"+Values.EMPTY_ACTIVE_VALUE+"'";
            Statement stmt_fetchAllNodes = con.createStatement();
            ResultSet rs_fetchAllNodes = stmt_fetchAllNodes.executeQuery(query_fetchAllNodes);

            while (rs_fetchAllNodes.next()){
                DroppedNodes node = new DroppedNodes(rs_fetchAllNodes.getInt("network_id"), rs_fetchAllNodes.getInt("user_id"),rs_fetchAllNodes.getInt("base"),rs_fetchAllNodes.getInt("state"));
                droppedNodeQueue.add(node);
            }


            /**
             * ************************************************************
             * DROP NODES
             * ************************************************************
             */

            int firstIdDROP = 0;
            int lastIdDROP = 0;
            int creditorIdDROP = 0;
            int prevMilestoneDROP = 0;

            String query_firstId = "SELECT * FROM network LIMIT 1";
            Statement stmt_firstId = con.createStatement();
            ResultSet rs_firstId = stmt_firstId.executeQuery(query_firstId);

            while (rs_firstId.next()) {
                firstIdDROP = rs_firstId.getInt("id");
            }

            String query_lastIdDROP = "SELECT * FROM network  ORDER BY id DESC LIMIT 1";
            Statement stmt_lastDROP = con.createStatement();
            ResultSet rs_LastDROP = stmt_lastDROP.executeQuery(query_lastIdDROP);

            while (rs_LastDROP.next()) {
                lastIdDROP = rs_LastDROP.getInt("id");
            }

            boolean dropKey = false;

            for (int i=0; i<droppedNodeQueue.size(); i++){
                if(droppedNodeQueue.get(i).getBase() == ((lastIdDROP-firstIdDROP)+1) && droppedNodeQueue.get(i).getState()==Values.EMPTY_ACTIVE_VALUE){
                    dropKey=true;
                }
            }

            if(dropKey){
                for(int i=0; i<droppedNodeQueue.size(); i++){
                    DroppedNodes node = droppedNodeQueue.get(i);
                    if(node.getState()==Values.EMPTY_ACTIVE_VALUE){
                        insertDropNode(con, node, prevMilestoneDROP,countryId);
                    }
                }
                createNode(ipnBody, con, userId, countryId, purchasingFee, paymentTime);

            }else {
                createNode(ipnBody, con, userId, countryId, purchasingFee, paymentTime);
            }

            /**
             * Close
             */
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new IpnResponseBody(true);
    }

    private void insertDropNode(Connection con, DroppedNodes node, int prevMilestoneDROP,int countryId) throws SQLException {
        int creditorIdDROP;
        int milestoneStepsDROP = Values.MILESTONE_STEPS;
        int baseLineSizeDROP = Values.BASELINE;
        int baseLineIndexDROP = 0;
        int nodePositionDROP = 0;
        int nodeIndexDROP = 0;
        int insertedIdDROP = 0;
        baseLineIndexDROP = baseLineSizeDROP-1;

        //get exact position value

        /**
         * Select the user
         */
        int userIdLastNode = 0;
        String transactionIdLastNode = Values.EMPY_STRING;
        String joiningTimeLastNode = Values.EMPY_STRING;
        int milestoneStepsLastNode = 0;
        int creditorIdLastNode = 0;
        String creditedTimeLastNode = Values.EMPY_STRING;
        String purchasingFeeLastNode = Values.EMPY_STRING;
        int creditedIdLastNode = 0;
        String creditedAmountLastNode = Values.EMPY_STRING;
        int freeFeeIdLastNode = 0;
        String freeFeeAmountLastNode = Values.EMPY_STRING;
        String baselineCollectionLastNode = Values.EMPY_STRING;
        String baselineBalanceLastNode = Values.EMPY_STRING;
        String totalCollectionLastNode = Values.EMPY_STRING;
        String total_balanceLastNode = Values.EMPY_STRING;
        String nodeStatusLastNode = Values.EMPY_STRING;

        String query_selectLastInsertedNode = "SELECT * FROM network WHERE user_id = '"+node.getUserId()+"' AND id = '"+node.getNetworkId()+"'";
        Statement stmt_lastNode = con.createStatement();
        ResultSet rs_lastNode =stmt_lastNode.executeQuery(query_selectLastInsertedNode);

        while(rs_lastNode.next()){
            userIdLastNode = rs_lastNode.getInt("user_id");
            transactionIdLastNode = rs_lastNode.getString("transaction_id");
            joiningTimeLastNode = rs_lastNode.getString("joining_time");
            milestoneStepsLastNode = rs_lastNode.getInt("milestone_steps");
            creditorIdLastNode = rs_lastNode.getInt("creditor_id");
            creditedTimeLastNode = rs_lastNode.getString("credited_time");
            purchasingFeeLastNode = rs_lastNode.getString("purchasing_fee");
            creditedIdLastNode = rs_lastNode.getInt("credited_id");
            creditedAmountLastNode = rs_lastNode.getString("credited_amount");
            freeFeeIdLastNode = rs_lastNode.getInt("free_fee_id");
            freeFeeAmountLastNode = rs_lastNode.getString("free_fee_amount");
            baselineCollectionLastNode = rs_lastNode.getString("baseline_collection");
            baselineBalanceLastNode = rs_lastNode.getString("baseline_balance");
            totalCollectionLastNode = rs_lastNode.getString("total_collection");
            total_balanceLastNode = rs_lastNode.getString("total_balance");
            nodeStatusLastNode = rs_lastNode.getString("node_status");

        }

        //create multipleinsertion (from que and add last inserted row
        String query_createNewNode = "INSERT INTO network " +
                "(id," +
                "user_id," +
                "transaction_id," +
                "joining_time," +
                "milestone_steps," +
                "creditor_id," +
                "credited_time," +
                "purchasing_fee," +
                "credited_id," +
                "credited_amount," +
                "free_fee_id," +
                "free_fee_amount," +
                "baseline_collection," +
                "baseline_balance," +
                "total_collection," +
                "total_balance, " +
                "node_status) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement createNewNodes = con.prepareStatement(query_createNewNode);


        /**
         * Calculate new Milestome : For dropping node
         */


        createNewNodes.setInt(1, Values.EMPTY_OFF_VALUE);  //id
        createNewNodes.setInt(2,userIdLastNode); //user_id
        createNewNodes.setString(3,transactionIdLastNode); //transaction_id
        createNewNodes.setString(4,joiningTimeLastNode); //joining_time
        createNewNodes.setInt(5,milestoneStepsLastNode); //milestone_steps
        createNewNodes.setInt(6,creditorIdLastNode); //creditor_id
        createNewNodes.setString(7,creditedTimeLastNode); //credited_time
        createNewNodes.setString(8,purchasingFeeLastNode); //purchasing_fee
        createNewNodes.setInt(9,creditedIdLastNode); //credited_id
        createNewNodes.setString(10,creditedAmountLastNode); //credited_amount
        createNewNodes.setInt(11,freeFeeIdLastNode); //free_fee_id
        createNewNodes.setString(12,freeFeeAmountLastNode); //free_fee_amount
        createNewNodes.setString(13,baselineCollectionLastNode); //baseline_collection
        createNewNodes.setString(14,baselineBalanceLastNode); //baseline_balance
        createNewNodes.setString(15,totalCollectionLastNode); //total_collection
        createNewNodes.setString(16,total_balanceLastNode); //total_balance
        createNewNodes.setString(17,nodeStatusLastNode); //node_status


        //Add End BaseLine
        String query_fetchnextbase = "SELECT *FROM base WHERE state = '" + Values.EMPTY_ACTIVE_VALUE + "'";
        Statement stmt_fetchnextbase = con.createStatement();
        ResultSet rs_fetchnextbase = stmt_fetchnextbase.executeQuery(query_fetchnextbase);


        int prevBase = 0;
        while (rs_fetchnextbase.next()) {
            prevBase = rs_fetchnextbase.getInt("nextbase");
        }

        createNewNodes.execute();

        ResultSet droppedResultSet = createNewNodes.getGeneratedKeys();

        while (droppedResultSet.next()) {
            insertedIdDROP = droppedResultSet.getInt(1);
        }


        if (nodePositionDROP == 1) {
            milestoneStepsDROP = Values.MILESTONE_STEPS;
        } else {

            int prevId = insertedIdDROP - 1;
            //select prev row and get milestone + baselineIndex
            String query_prevMilestone = "SELECT * FROM network WHERE  id = '" + prevId + "'";
            Statement stmt_prevMilestone = con.createStatement();
            ResultSet rs_prevMilestone = stmt_prevMilestone.executeQuery(query_prevMilestone);

            while (rs_prevMilestone.next()) {
                prevMilestoneDROP = rs_prevMilestone.getInt("milestone_steps");
            }

            milestoneStepsDROP = prevMilestoneDROP + baseLineIndexDROP;
        }

        //assign creditor Id
        creditorIdDROP = insertedIdDROP + milestoneStepsDROP;

        while (droppedResultSet.next()) {
            insertedIdDROP = droppedResultSet.getInt(1);
        }

        //Update first row and peek from queue
        String query_updateLastInserted = "UPDATE network " +
                "   SET milestone_steps = '"+milestoneStepsDROP+"', " +
                "   creditor_id = '"+creditorIdDROP+"' " +
                "   WHERE id = '"+insertedIdDROP+"'";

        Statement st_nodeUpdate = con.createStatement();
        st_nodeUpdate.executeUpdate(query_updateLastInserted);

        //Update Queue
        String query_updateQueue = "UPDATE nodesqueue " +
                "   SET state = '"+Values.EMPTY_OFF_VALUE+"' " +
                "   WHERE user_id = '"+node.getUserId()+"' AND network_id = '"+node.getNetworkId()+"'";
        Statement st_queueUpdate = con.createStatement();
        st_queueUpdate.executeUpdate(query_updateQueue);


        /**
         *CREDITS
         */
        String creditedAmountDROP = String.valueOf(Values.EMPTY_OFF_VALUE);
        int creditedUserIdDROP = 0;
        int creditedIdDROP = 0;
        int flagDROP= 0;

        String feeFreeAmountDROP = "0";
        String baseLineCollectionDROP = "0";
        String baseLineBalanceDROP = "0";

        //assign credited amount
        String query_creditedAmount = "SELECT * FROM credits WHERE country_id = '" + countryId + "'  AND status='"+Values.EMPTY_ACTIVE_VALUE+"' ";
        Statement stmt_creditedAmount = con.createStatement();
        ResultSet rs_creditedAmount = stmt_creditedAmount.executeQuery(query_creditedAmount);

        while (rs_creditedAmount.next()) {
            creditedAmountDROP = rs_creditedAmount.getString("credit_amount");
        }

        String query_creditedId = "SELECT id, user_id, count(id) as flag FROM network WHERE creditor_id = '" + insertedIdDROP + "'";
        Statement stmt_creditedId = con.createStatement();
        ResultSet rs_creditedId = stmt_creditedId.executeQuery(query_creditedId);

        while (rs_creditedId.next()) {
            creditedIdDROP = rs_creditedId.getInt("id");
            creditedUserIdDROP = rs_creditedId.getInt("user_id");
            flagDROP = rs_creditedId.getInt("flag");
        }

        System.out.println("flag = "+flagDROP+"  inserted id = "+insertedIdDROP+"  credited id ="+creditedIdDROP+"  amount = "+creditedAmountDROP);
        if (flagDROP == 0) {
            creditedUserIdDROP = 0;
            creditedAmountDROP = "0";
            feeFreeAmountDROP = "0";
            baseLineCollectionDROP = "0";
            baseLineBalanceDROP = "0";
        }else {
            //calculate baseline colection
            float baseLineItems[] = new float[baseLineSizeDROP];
            int counter = 0;

            int startId = insertedIdDROP - (baseLineSizeDROP - 1);
            int endId = insertedIdDROP;

            String query_baseLineCollection = "SELECT  id,purchasing_fee FROM network WHERE id BETWEEN '" + startId + "' AND '" + endId + "'";
            Statement stmt_baseLineCollection = con.createStatement();
            ResultSet rs_baseLineCollection = stmt_baseLineCollection.executeQuery(query_baseLineCollection);

            while (rs_baseLineCollection.next()) {
                baseLineItems[counter] = Float.parseFloat(rs_baseLineCollection.getString("purchasing_fee"));
                counter++;
            }

            float sum = 0;
            for (float fee : baseLineItems) {
                sum += fee;
            }

            baseLineCollectionDROP = Float.toString(sum);
            baseLineBalanceDROP = Float.toString(sum - (Float.parseFloat(creditedAmountDROP) + Float.parseFloat(purchasingFeeLastNode)));
        }

        String query_updateLastRowNull = "UPDATE network " +
                "   SET  credited_time = '" + new AppTimestamp().currentTimeStamp() + "'," +
                " credited_id = '" + creditedIdDROP + "', " +
                " credited_amount = '" + creditedAmountDROP + "', " +
                " credited_user_id = '" + creditedUserIdDROP + "', " +
                " free_fee_amount = '" + feeFreeAmountDROP + "', " +
                " baseline_collection = '" + baseLineCollectionDROP + "'," +
                " baseline_balance = '" + baseLineBalanceDROP + "'" +
                "   WHERE id = '" + insertedIdDROP + "'";

        Statement st_updateLastRowNull = con.createStatement();
        st_updateLastRowNull.executeUpdate(query_updateLastRowNull);

    }

    private void createNode(IpnBody ipnBody, Connection con, int userId, int countryId, String purchasingFee, String paymentTime) throws SQLException {
        int milestoneSteps = Values.MILESTONE_STEPS;
        int baseLineSize = Values.BASELINE;
        int baseLineIndex = 0;
        int nodePosition = 0;
        int nodeIndex = 0;

        String query_createuser = "INSERT INTO network " +
                "(id," +
                "user_id," +
                "transaction_id," +
                "joining_time," +
                "milestone_steps," +
                "creditor_id," +
                "credited_time," +
                "purchasing_fee," +
                "credited_id," +
                "credited_amount," +
                "free_fee_id," +
                "free_fee_amount," +
                "baseline_collection," +
                "baseline_balance," +
                "total_collection," +
                "total_balance, " +
                "node_status) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = con.prepareStatement(query_createuser);

        preparedStatement.setInt(1, Values.EMPTY_OFF_VALUE);  //id
        preparedStatement.setInt(2, userId); //user_id
        preparedStatement.setString(3, ipnBody.getTransactionId()); //transaction_id
        preparedStatement.setString(4, paymentTime); //joining_time
        preparedStatement.setInt(5, Values.EMPTY_OFF_VALUE); //milestone_steps
        preparedStatement.setString(6, Values.NODE_PURCHASED); //creditor_id
        preparedStatement.setString(7, paymentTime); //credited_time
        preparedStatement.setString(8, purchasingFee); //purchasing_fee
        preparedStatement.setString(9, Values.EMPY_STRING); //credited_id
        preparedStatement.setString(10, Values.EMPY_STRING); //credited_amount
        preparedStatement.setString(11, Values.EMPY_STRING); //free_fee_id
        preparedStatement.setString(12, Values.EMPY_STRING); //free_fee_amount
        preparedStatement.setString(13, Values.EMPY_STRING); //baseline_collection
        preparedStatement.setString(14, Values.EMPY_STRING); //baseline_balance
        preparedStatement.setString(15, Values.EMPY_STRING); //total_collection
        preparedStatement.setString(16, Values.EMPY_STRING); //total_balance
        preparedStatement.setString(17, Values.EMPY_STRING); //node_status
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        //get exact position value
        int insertedId = 0;
        int firstId = 0;
        int creditorId = 0;
        int creditedId = 0;
        int creditedUserId = 0;
        String creditedAmount = Values.EMPY_STRING;
        int free_fee_id = 0;
        int prevMilestone = 0;
        baseLineIndex = baseLineSize - 1;

        int freeFeeEntrynodePosition = 0;
        String feeFreeAmount = purchasingFee;
        int droppingSteps = 0;
        int droppingId = 0;
        int prevBase = 0;
        int nextEndBase = 0;

        String baseLineCollection = "0";
        String baseLineBalance = "0";


        String query_firstId = "SELECT * FROM network LIMIT  1";
        Statement stmt_firstId = con.createStatement();
        ResultSet rs_firstId = stmt_firstId.executeQuery(query_firstId);

        while (rs_firstId.next()) {
            firstId = rs_firstId.getInt("id");
        }

        while (resultSet.next()) {
            insertedId = resultSet.getInt(1);
        }

        //get exact index value
        nodeIndex = insertedId - firstId;

        //get exact milestone value
        nodePosition = nodeIndex + 1;

        if (nodePosition == 1) {
            milestoneSteps = Values.MILESTONE_STEPS;
        } else {

            int prevId = insertedId - 1;
            //select prev row and get milestone + baselineIndex
            String query_prevMilestone = "SELECT * FROM network WHERE  id = '" + prevId + "'";
            Statement stmt_prevMilestone = con.createStatement();
            ResultSet rs_prevMilestone = stmt_prevMilestone.executeQuery(query_prevMilestone);

            while (rs_prevMilestone.next()) {
                prevMilestone = rs_prevMilestone.getInt("milestone_steps");
            }

            milestoneSteps = prevMilestone + baseLineIndex;
        }

        //assign creditor Id
        creditorId = insertedId + milestoneSteps;

        //assign credited amount
        String query_creditedAmount = "SELECT * FROM credits WHERE country_id = '" + countryId + "'  AND status='"+Values.EMPTY_ACTIVE_VALUE+"' ";
        Statement stmt_creditedAmount = con.createStatement();
        ResultSet rs_creditedAmount = stmt_creditedAmount.executeQuery(query_creditedAmount);

        while (rs_creditedAmount.next()) {
            creditedAmount = rs_creditedAmount.getString("credit_amount");
        }


        //assign credited Id
        creditedId = creditorId - milestoneSteps;

        String query_creditedId = "SELECT id, user_id, count(id) as flag FROM network WHERE creditor_id = '" + insertedId + "'";
        Statement stmt_creditedId = con.createStatement();
        ResultSet rs_creditedId = stmt_creditedId.executeQuery(query_creditedId);

        while (rs_creditedId.next()) {
            creditedId = rs_creditedId.getInt("id");
            creditedUserId = rs_creditedId.getInt("user_id");
            int flag = rs_creditedId.getInt("flag");
            if (flag == 0) {
                creditedId = 0;
                creditedAmount = "0";
                feeFreeAmount = "0";
                baseLineCollection = "0";
                baseLineBalance = "0";
            } else {
             /*freeFeeEntrynodePosition = (insertedId - firstId) + 1;
             droppingSteps = (Values.TOTALNODES) * freeFeeEntrynodePosition;//free_fee_id
             droppingId = insertedId + droppingSteps;//free_fee_id*/

                //calculate baseline colection
                float baseLineItems[] = new float[baseLineSize];
                int counter = 0;

                int startId = insertedId - (baseLineSize - 1);
                int endId = insertedId;

                String query_baseLineCollection = "SELECT  id,purchasing_fee FROM network WHERE id BETWEEN '" + startId + "' AND '" + endId + "'";
                Statement stmt_baseLineCollection = con.createStatement();
                ResultSet rs_baseLineCollection = stmt_baseLineCollection.executeQuery(query_baseLineCollection);

                while (rs_baseLineCollection.next()) {
                    baseLineItems[counter] = Float.parseFloat(rs_baseLineCollection.getString("purchasing_fee"));
                    counter++;
                }

                float sum = 0;
                for (float fee : baseLineItems) {
                    sum += fee;
                }

                baseLineCollection = Float.toString(sum);
                baseLineBalance = Float.toString(sum - (Float.parseFloat(creditedAmount) + Float.parseFloat(purchasingFee)));


                //Add End BaseLine
                String query_fetchnextbase = "SELECT *FROM base WHERE state = '" + Values.EMPTY_ACTIVE_VALUE + "'";
                Statement stmt_fetchnextbase = con.createStatement();
                ResultSet rs_fetchnextbase = stmt_fetchnextbase.executeQuery(query_fetchnextbase);

                while (rs_fetchnextbase.next()) {
                    prevBase = rs_fetchnextbase.getInt("nextbase");
                }

                nextEndBase = (prevBase * 2) + 1;

                //Add Credited Node to Queue
                //create new base (ship height)
                String query_createNodeQueue = "INSERT INTO nodesqueue " +
                        "(id," +
                        "network_id, " +
                        "user_id, " +
                        "state, " +
                        "base) " +
                        "VALUES (?,?,?,?,?)";

                PreparedStatement preparedStatementNodeQueue = con.prepareStatement(query_createNodeQueue);

                preparedStatementNodeQueue.setInt(1, Values.EMPTY_OFF_VALUE);  //id
                preparedStatementNodeQueue.setInt(2, creditedId); //network id :credited
                preparedStatementNodeQueue.setInt(3, creditedUserId); //user id
                preparedStatementNodeQueue.setInt(4, Values.EMPTY_ACTIVE_VALUE); //state
                preparedStatementNodeQueue.setInt(5, Values.EMPTY_OFF_VALUE); //state
                preparedStatementNodeQueue.execute();

                ResultSet droppedResultSet = preparedStatementNodeQueue.getGeneratedKeys();

                int insertedNoteToQueue = 0;
                while (droppedResultSet.next()) {
                     insertedNoteToQueue = droppedResultSet.getInt(1);
                }


                if (prevBase == nodePosition || prevBase == Values.FIRST_BASE_SIZE) {
                    //create new base (ship height)
                    String query_createNextNode = "INSERT INTO base " +
                            "(id," +
                            "nextbase, " +
                            "state) " +
                            "VALUES (?,?,?)";

                    PreparedStatement preparedStatementNextNode = con.prepareStatement(query_createNextNode);

                    preparedStatementNextNode.setInt(1, Values.EMPTY_OFF_VALUE);  //id
                    preparedStatementNextNode.setInt(2, nextEndBase); //nextbase
                    preparedStatementNextNode.setInt(3, 1); //state

                    preparedStatementNextNode.execute();

                    //update used(prev) base
                    String query_updateBase = "UPDATE base " +
                            "   SET state = '" + Values.EMPTY_OFF_VALUE + "' " +
                            "   WHERE nextbase = '" + prevBase + "'";

                    Statement st_updateBase = con.createStatement();
                    st_updateBase.executeUpdate(query_updateBase);

                    String query_updateNextBase = "UPDATE nodesqueue " +
                            "   SET base = '" + prevBase + "' " +
                            "   WHERE id = '" + insertedNoteToQueue + "'";

                    Statement st_updateNextBase = con.createStatement();
                    st_updateNextBase.executeUpdate(query_updateNextBase);

                    //Assign free fee Id
                    //Id = ParentNodeId + nextP
                    //ParentNodeId = Inserted:Creditor - mileStone
                    //nextP = TotalNode * Position
                    int parentId = insertedId - milestoneSteps;
                    int nextPosition = (endId - startId) + 1;
                    droppingId = parentId + nextPosition;

                }

            }
        }

        String query_updateLastRowNull = "UPDATE network " +
                "   SET milestone_steps = '" + milestoneSteps + "', " +
                " creditor_id = '" + creditorId + "' ," +
                " credited_time = '" + paymentTime + "'," +
                " credited_id = '" + creditedId + "', " +
                " credited_amount = '" + creditedAmount + "', " +
                " credited_user_id = '" + creditedUserId + "', " +
                " free_fee_id = '" + droppingId + "', " +
                " free_fee_amount = '" + feeFreeAmount + "', " +
                " credited_id = '" + creditedId + "'," +
                " baseline_collection = '" + baseLineCollection + "'," +
                " baseline_balance = '" + baseLineBalance + "'" +
                "   WHERE id = '" + insertedId + "'";

        Statement st_updateLastRowNull = con.createStatement();
        st_updateLastRowNull.executeUpdate(query_updateLastRowNull);
    }

    
}
