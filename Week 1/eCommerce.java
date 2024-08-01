class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

class SearchFunctionality {
    public static int linearSearch(Product[] products, String productId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId().compareTo(productId) == 0) {
                return mid;
            }
            if (products[mid].getProductId().compareTo(productId) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Product1", "Category1"),
            new Product("2", "Product2", "Category2"),
            new Product("3", "Product3", "Category3")
        };

        // Linear search
        int index = linearSearch(products, "2");
        System.out.println("Linear Search: Product found at index " + index);

        // Binary search
        Product[] sortedProducts = {
            new Product("1", "Product1", "Category1"),
            new Product("2", "Product2", "Category2"),
            new Product("3", "Product3", "Category3")
        };
        index = binarySearch(sortedProducts, "2");
        System.out.println("Binary Search: Product found at index " + index);
    }
}
