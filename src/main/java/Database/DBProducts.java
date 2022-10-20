package Database;

import Base.BaseDriver;
import Utilities.GetterSetter;

import java.sql.*;

public class DBProducts extends BaseDriver {
    GetterSetter gs = new GetterSetter();

    public String query(String query){
        return "SELECT count(*) from ("+query+") AS subQuery";
    }
    // Return total number of products from DataBase against given min and max prices. //
    public int getCountOnPriceRange() throws SQLException {
        String getGivenPricesProductsCount = "SELECT * FROM fc_items INNER JOIN offer_country ofc ON fc_items.id = ofc.item_id WHERE category_id in ("+gs.getCategory()+") AND price Between "+gs.getMinPrice()+" and "+gs.getMaxPrice()+" AND status = 'publish' AND ofc.country_id = 1 AND (quantity > 0 or (atp_enable = 1 and atp_available_quantity > 0)) Group By fc_items.id";
        String getCount = query(getGivenPricesProductsCount);
        String totalProductsCount = dbQuery(getCount,"count(*)");
        return Integer.parseInt(totalProductsCount);
    }
    // Return total number of products from DataBase against selected condition From Front Store //
    public int getCountOfSelectedConditionFromDB() throws SQLException {
        String getSelectedConditionProductCount = "SELECT * FROM fc_items INNER JOIN offer_country ofc ON fc_items.id = ofc.item_id WHERE category_id in ("+gs.getCategory()+") AND price Between "+gs.getMinPrice()+" and "+gs.getMaxPrice()+" AND grade in ("+gs.getConditions()+") AND status = 'publish' AND ofc.country_id = 1 AND (quantity > 0 or (atp_enable = 1 and atp_available_quantity > 0)) Group By fc_items.id";
        String getCount = query(getSelectedConditionProductCount);
        String totalProductsCount = dbQuery(getCount,"count(*)");
        return Integer.parseInt(totalProductsCount);
    }
    // Return total number of products from DataBase against selected condition and Brand From Front Store //
    public int getCountOfSelectedBrandFromDB() throws SQLException {
        String getSelectedConditionAndBrandProductCount = "SELECT * FROM fc_items INNER JOIN offer_country ofc ON fc_items.id = ofc.item_id WHERE category_id in ("+gs.getCategory()+") AND price Between "+gs.getMinPrice()+" and "+gs.getMaxPrice()+" AND grade in ("+gs.getConditions()+") AND brand_id = "+gs.getBrands()+" AND status = 'publish' AND ofc.country_id = 1 AND (quantity > 0 or (atp_enable = 1 and atp_available_quantity > 0)) Group By fc_items.id";
        String getCount = query(getSelectedConditionAndBrandProductCount);
        String totalProductsCount = dbQuery(getCount,"count(*)");
        return Integer.parseInt(totalProductsCount);
    }
    public int getFeatureOfProduct() throws SQLException {
        String getSelectedProduct = "Select * From fantacy4.fc_items WHERE id = "+gs.getPID()+" ";

        return  Integer.parseInt(dbQuery(getSelectedProduct,"grade"));
    }
    public int getStoreCountryID() throws SQLException {
        String getStoreCountryID =  "SELECT * From fantacy4.fc_shops WHERE shop_name ='"+gs.getStoreName()+"' ";
        return  Integer.parseInt(dbQuery(getStoreCountryID,"country_id"));
    }
    public int getStoreStatus() throws SQLException {
        String getStoreStatus =  "SELECT * From fantacy4.fc_shops WHERE shop_name ='"+gs.getStoreName()+"' ";
        return  Integer.parseInt(dbQuery(getStoreStatus,"in_house"));
    }
    public int getProductCountryID() throws SQLException {
        String getProductCountryID =  "SELECT * From fantacy4.fc_items WHERE id = "+gs.getPID()+" ";
        return  Integer.parseInt(dbQuery(getProductCountryID,"countryid"));
    }
    public int getProductQuantity() throws SQLException {
        String getProductQuantity =  "SELECT * From fantacy4.fc_items WHERE id = "+gs.getPID()+" ";
        return  Integer.parseInt(dbQuery(getProductQuantity,"quantity"));
    }
    public int getMaxBuyAbleProductQuantity() throws SQLException {
        String getMaxBuyAbleProductQuantity =  "SELECT * From fantacy4.fc_items WHERE id = "+gs.getPID()+" ";
        return  Integer.parseInt(dbQuery(getMaxBuyAbleProductQuantity,"max_buyable_quantity"));
    }
}
