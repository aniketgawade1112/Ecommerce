package com.example.ecommerce_d;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerPageController {

    @FXML
    TextField name, price, sellerid;

    @FXML
    public void AddProduct(MouseEvent e) throws SQLException {

        int productID = 1;
        ResultSet response2 = Main.connection.executeQuery("select max(productId) as productId from product;");
        if (response2.next()) {
            productID = response2.getInt("productId") + 1;
        }
        String query = String.format("Insert into product values(%s, '%s', '%s', '%s')", productID, name.getText(), price.getText(), sellerid.getText());
        int response = Main.connection.executeUpdate(query);
        if (response > 0) {
            System.out.println("New Product is Added");
        }
    }
}
