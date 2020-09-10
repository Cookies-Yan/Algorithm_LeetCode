package algorithm.sortAlgorithm;

public class SortStabilization {

    /**
     * 稳定排序
     * @param products
     */
    private static void bubbleSort(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if(products[j].getPrice() < products[j - 1].getPrice()) {
                    Product temp = products[j];
                    products[j] = products[j - 1];
                    products[j - 1] = temp;
                }
            }
        }

        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if(products[j].getSale() < products[j - 1].getSale()) {
                    Product temp = products[j];
                    products[j] = products[j - 1];
                    products[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 不稳定排序
     * @param products
     */
    private static void bubbleSort2(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if(products[j - 1].getPrice() >= products[j].getPrice()) {
                    Product temp = products[j];
                    products[j] = products[j - 1];
                    products[j - 1] = temp;
                }
            }
        }
        //不稳定排序，当值一样的时候也要进行交换
        for(Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println();
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if(products[j - 1].getSale() >= products[j].getSale()) {
                    Product temp = products[j];
                    products[j] = products[j - 1];
                    products[j - 1] = temp;
                }
            }
        }
    }

    private static void bubbleSort3(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = products.length - 1; j > i; j--) {
                if (products[j].compareTo(products[j - 1]) < 0) {
                    Product temp = products[j];
                    products[j] = products[j - 1];
                    products[j - 1] = temp;
                }
            }
        }
    }



    public static void main(String[] args) {

        Product product1 = new Product(3,10);
        Product product2 = new Product(1,9);
        Product product3 = new Product(2,9);
        Product product4 = new Product(0,9);
        Product[] products = new Product[]{product1, product2, product3, product4};
        bubbleSort3(products);
        for(Product product : products) {
            System.out.println(product.toString());
        }


    }
}
