package Utilities;

import java.util.ArrayList;

public class GetterSetter {

    public static ArrayList<Integer> g_id = new ArrayList<>();

    public static int[] clearanceCondition = {17,18,19,20};
    public static int[] refurbishedCondition = {9,10,15,24};
    public static int[] openBoxCondition = {16,23,26};
    public static int[] preOwnedCondition = {21,22,25};

    public static int[] mobileCategory = {27000,27001,27002,27003,27004};
    public static int[] watchesCategory = {55000,55001,55002,55005,55008,55009,55010,55012,55013};
    public static int[] groceryCategory = {23000,23001,23002,23003,23004,23004,23005,23005,23006,23007,23008,23009,23010,23011,23012};

    public static String category;
    public static int minPrice;
    public static int maxPrice;
    public static String conditions;
    public static String brands;
    public static String PID;
    public static String storeName;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        switch (category) {
            case "27000" -> {
                for (int categoryId : mobileCategory) {
                    g_id.add(categoryId);
                }
                GetterSetter.category = g_id.toString().replaceAll("(^\\[|]$)", "");
            }
            case "55000" -> {
                for (int categoryId : watchesCategory) {
                    g_id.add(categoryId);
                }
                GetterSetter.category = g_id.toString().replaceAll("(^\\[|]$)", "");
            }
            case "23000" -> {
                for (int categoryId : groceryCategory) {
                    g_id.add(categoryId);
                }
                GetterSetter.category = g_id.toString().replaceAll("(^\\[|]$)", "");
            }
            default -> GetterSetter.category = category;
        }

    }

    public int getMinPrice(){
        return minPrice;
    }

    public void setMinPrice(int minPrice){
        GetterSetter.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        GetterSetter.maxPrice = maxPrice;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        switch (conditions) {
            case "Clearance" -> {
                for(int conditionId:clearanceCondition){
                    g_id.add(conditionId);
                }
                GetterSetter.conditions = g_id.toString().replaceAll("(^\\[|]$)","");
            }
            case "Refurbished" -> {
                for(int conditionId:refurbishedCondition){
                    g_id.add(conditionId);
                }
                GetterSetter.conditions = g_id.toString().replaceAll("(^\\[|]$)","");
            }
            case "Open-box" -> {
                for(int conditionId:openBoxCondition){
                    g_id.add(conditionId);
                }
                GetterSetter.conditions = g_id.toString().replaceAll("(^\\[|]$)","");
            }
            case "Pre-owned" -> {
                for(int conditionId:preOwnedCondition){
                    g_id.add(conditionId);
                }
                GetterSetter.conditions = g_id.toString().replaceAll("(^\\[|]$)","");
            }
        }
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        GetterSetter.brands = brands;
    }
    public String getPID(){
        return PID;
    }
    public void setPID(String PID){
        GetterSetter.PID = PID;
    }
    public String getStoreName(){
        return storeName;
    }
    public void setStoreName(String storeName){
        GetterSetter.storeName = storeName;
    }

}
