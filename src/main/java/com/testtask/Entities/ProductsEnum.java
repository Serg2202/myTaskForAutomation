package com.testtask.Entities;

/**
 * Created by Sergio on 30.01.2017.
 */

public enum ProductsEnum {//создали enum с параметрами
    DefaultProduct("30", "64", "0"),
    ProductWithPrice300("30", "320", "300"),
    ProductWithPrice350("30", "416", "350"),
    ProductWithPrice400("30", "512", "400"),
    ProductWithPrice450("30", "640", "450"),
    ProductWithPrice500("30", "768", "500"),
    ProductWithPrice550("30", "896", "550"),
    ProductWithPrice600("30", "1.0", "600"),
    ProductWithPrice650("30", "1.3", "650"),
    ProductWithPrice700("30", "1.7", "700"),
    ProductWithPrice750("30", "2.1", "750"),
    ProductWithPrice800("30", "3.1", "800"),
    ProductWithPrice850("30", "4.1", "850"),
    ProductWithPrice900("30", "5.0", "900"),
    ProductWithPrice950("30", "5.7", "950"),
    ProductWithPrice1000("30", "6.4", "1000"),
    ProductWithPrice1050("30", "7.1", "1050"),
    ProductWithPrice1100("30", "7.8", "1100"),
    ProductWithPrice1150("30", "8.5", "1150"),
    ProductWithPrice1200("30", "9.2", "1200"),
    ProductWithPrice1250("30", "10.0", "1250"),
    ProductWithPrice1300("30", "12.0", "1300"),
    ProductWithPrice1350("30", "15.0", "1350"),
    ProductWithPrice1400("30", "Макс", "1400");


    private ProductsEnum(String durationInDaysOfSelectedProduct, String speedOfSelectedProduct, String priceOfSelectedProduct) {
        this.durationInDaysOfSelectedProduct = durationInDaysOfSelectedProduct;
        this.speedOfSelectedProduct = speedOfSelectedProduct;
        this.priceOfSelectedProduct = priceOfSelectedProduct;
    }

    private String durationInDaysOfSelectedProduct;//создали параметры enuma
    private String speedOfSelectedProduct;
    private String priceOfSelectedProduct;

    public String getPrice() {//создали метод получения цены выбранного продукта
        return priceOfSelectedProduct;
    }


}
