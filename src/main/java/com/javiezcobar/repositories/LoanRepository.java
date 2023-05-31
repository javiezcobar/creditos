package com.javiezcobar.repositories;

import com.javiezcobar.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
