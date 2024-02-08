package org.project.library.dao;

import org.project.library.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout,Long> {
    Checkout findByUserEmailAndAndBookId(String userEmail,Long bookId);
    List<Checkout> findBooksByUserEmail(String userEmail);
}