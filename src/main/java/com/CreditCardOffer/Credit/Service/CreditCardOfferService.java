package com.CreditCardOffer.Credit.Service;
import com.CreditCardOffer.Credit.model.CreditCardOffer;
import com.CreditCardOffer.Credit.repository.CreditCardOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardOfferService {
    @Autowired
    private CreditCardOfferRepository repository;

    // Fetch all credit card offers
    public List<CreditCardOffer> getAllOffers() {
        return repository.findAll();
    }

    // Fetch a specific offer by ID
    public CreditCardOffer getOfferById(String id) {
        Optional<CreditCardOffer> offer = repository.findById(id);
        return offer.orElse(null); // Return offer if present, else return null
    }

    // Create a new offer
    public CreditCardOffer createOffer(CreditCardOffer offer) {
        return repository.save(offer);
    }

    // Update an existing offer
    public CreditCardOffer updateOffer(String id, CreditCardOffer updatedOffer) {
        if (repository.existsById(id)) {
            updatedOffer.setId(id); // Ensure the ID is set to update the correct document
            return repository.save(updatedOffer); // Save the updated offer
        }
        return null; // Return null if the ID does not exist
    }

    // Delete an offer by ID
    public boolean deleteOffer(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true; // Return true if deletion is successful
        }
        return false; // Return false if the ID does not exist
    }
}
