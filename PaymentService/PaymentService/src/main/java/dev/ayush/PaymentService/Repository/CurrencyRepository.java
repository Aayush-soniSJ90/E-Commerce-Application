package dev.ayush.PaymentService.Repository;

import dev.ayush.PaymentService.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
}
