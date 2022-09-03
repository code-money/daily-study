package cn.zyz.juc.cas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-03 20:46
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
class Book {
    private int id;
    private String bookName;
}

public class AtomicStampedDemo {
    public static void main(String[] args) {
        Book book1 = new Book(1, "javaBook");

        AtomicStampedReference<Book> stampedReference = new AtomicStampedReference<>(book1, 1);

        System.out.println(stampedReference.getReference() + "\t" + stampedReference.getStamp());

        Book book2 = new Book(2, "mysqlBook");
        boolean b;
        b = stampedReference.compareAndSet(book1, book2, stampedReference.getStamp(), stampedReference.getStamp() + 1);

        System.out.println(b + "\t" + stampedReference.getReference() + "\t" + stampedReference.getStamp());

        b = stampedReference.compareAndSet(book2, book1, stampedReference.getStamp(), stampedReference.getStamp() + 1);

        System.out.println(b + "\t" + stampedReference.getReference() + "\t" + stampedReference.getStamp());
    }
}

