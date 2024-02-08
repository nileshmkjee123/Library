package org.project.library.responsemodels;

import lombok.Data;
import org.project.library.entity.Book;

@Data
public class ShelfCurrentLoansResponse {

    private Book book;
    private int daysLeft;
    public ShelfCurrentLoansResponse(Book book, int daysLeft){
        this.book=book;
        this.daysLeft=daysLeft;
    }
}
