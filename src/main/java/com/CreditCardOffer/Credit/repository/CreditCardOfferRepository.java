package com.CreditCardOffer.Credit.repository;

import com.CreditCardOffer.Credit.model.CreditCardOffer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this interface as a Spring Bean for dependency injection
public interface CreditCardOfferRepository extends MongoRepository<CreditCardOffer, String> {

    // Custom query methods can be added here if needed
}

