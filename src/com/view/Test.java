package com.view;

import com.model.Product;
import com.services.ProductServiceImpl;
import com.services.ProductServices;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static ProductServices productServices=new ProductServiceImpl();
    private static Scanner scanner=new Scanner(System.in);

    // add product
    static void addBtn(){
        Product product=new Product();
        char flag='Y';

        do {
            System.out.println("Enter product Name:");
            product.setName(scanner.next());

            System.out.println("Enter product Price:");
            product.setPrice(scanner.nextInt());

            product.setCompany("Apple");

            System.out.println("Do you want to add another product (Y/N)");
            flag=scanner.next().charAt(0);

            product.setMdfDate(LocalDate.now());
            product.setExpDate(LocalDate.now().plusYears(5));
            productServices.addProduct(product);
        }while (flag=='y');

}

//get all product
   static void getAllProduct() {
      List<Product> productList= productServices.getAllProducts();
       System.out.println(productList.toString());
    }

    //delete product
    static  void deleteProduct(){

        System.out.println("Enter product ID do you want to delete :");
        productServices.deleteProduct(scanner.nextInt());

    }

    //for product update
    static  void updateProduct() {

        Product product=new Product();
        System.out.println("Enter product ID do you want to update :");
        int id=scanner.nextInt();

        System.out.println("Enter product Name do you want to update :");
        product.setName(scanner.next());


        System.out.println("Enter product Price do you want to update :");
        product.setPrice(scanner.nextInt());

        System.out.println("Enter product Company do you want to update :");
        product.setCompany(scanner.next());

        product.setMdfDate(LocalDate.now());
        product.setExpDate(LocalDate.now().plusYears(5));

        productServices.updateProduct(product,id);
    }

    public static void main(String[] args) {
       boolean flag=true;

       while(flag){
           System.out.println("Enter your choice :");
           System.out.println("1. Add product");
           System.out.println("2. Delete product");
           System.out.println("3. Get All product");
           System.out.println("4. Update product");
           System.out.println("5. Exit");
           int choice=scanner.nextInt();

           switch(choice){
               case 1:
                   addBtn();
                   break;
               case 2:
                   deleteProduct();
                   break;
               case 3:
                   getAllProduct();
                   break;
               case 4:
                   updateProduct();
                   break;
               case 5:
                   System.out.println("Thank you for using our application");
                   flag=false;
                   break;

               default:
                   System.out.println("Invalid choice");
           }

       }

    }
}
