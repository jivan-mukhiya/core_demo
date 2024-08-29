package com.view;

import com.model.Book;
import com.services.BookService;
import com.services.BookServiceImpl;
import java.util.List;
import java.util.Scanner;

public class BookView {

    private static BookService bookService=new BookServiceImpl();
    private  static Scanner scanner=new Scanner(System.in);


    //add new book on list
    static  void addBooks(){
        char flag='y';

        do {
            System.out.println("Enter Book Title: ");
            scanner.nextLine();
            String bookName=scanner.nextLine();

            System.out.println("Enter Book Author: ");
            String bookAuthor=scanner.nextLine();

            System.out.println("Enter Book Price: ");
            double bookPrice=scanner.nextDouble();

            System.out.println("Enter Book Publisher: ");
            String bookPublisher=scanner.next();

            System.out.println("Enter Book ISBN: ");
            scanner.nextLine();
            String bookISBN=scanner.nextLine();

            bookService.addBook(new Book(bookName,bookAuthor,bookPublisher,bookISBN,bookPrice));

            System.out.println("Do you wish to continue? (y/n)");
            flag=scanner.next().charAt(0);
        }while (flag=='y');
    }


    //delete book from list
    static void deleteBooks(){
        System.out.println("Enter Book Index: ");
      bookService.deleteBook(String.valueOf(scanner.nextInt()));
      getAllBook();
    }


    //get all book
    static void getAllBook(){
       List<Book> bookList= bookService.getAllBooks();

        System.out.println(bookList.toString());
    }

    static void updateBook(){
        Book book=new Book();

        System.out.println("Enter Book ISBN : ");
        scanner.nextLine();
       String bookISBN=scanner.nextLine();

        System.out.println("Enter Book Title: ");
       book.setTitle(scanner.nextLine());

        System.out.println("Enter Book Author: ");
        book.setAuthor(scanner.nextLine());

        System.out.println("Enter Book Price: ");
        book.setPrice(scanner.nextDouble());

        System.out.println("Enter Book Publisher: ");
        scanner.nextLine();
        book.setPublisher(scanner.nextLine());

        bookService.updateBook(book,bookISBN);

    }

    public static void main(String[] args){


        //for display
        boolean flag=true;
        while(flag){
            System.out.println("Enter your choice :");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Get All Books");
            System.out.println("4. Update Book");
            System.out.println("5. Exit");
            int choice=scanner.nextInt();
            switch(choice){
                case 1:
                    addBooks();
                    break;
                case 2:
                    deleteBooks();
                    break;
                case 3:
                    getAllBook();
                    break;

                case 4:
                    updateBook();
                    break;
                case 5:
                    System.out.println("Thank you for using our system");
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
