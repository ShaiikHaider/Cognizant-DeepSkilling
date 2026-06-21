class Product {
    int productId;
    String productName;

    Product(int id, String name) {
        productId = id;
        productName = name;
    }
}

public class EcommerceSearch {

    static int linearSearch(Product[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].productId == id)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop"),
            new Product(102, "Mouse"),
            new Product(103, "Keyboard")
        };

        int result = linearSearch(products, 102);

        if (result != -1)
            System.out.println("Product Found: " +
                products[result].productName);
        else
            System.out.println("Product Not Found");
    }
}