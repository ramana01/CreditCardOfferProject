package com.CreditCardOffer.Credit.Controller;
import com.CreditCardOffer.Credit.model.CreditCardOffer;
import com.CreditCardOffer.Credit.Service.CreditCardOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class CreditCardOfferController {
    @Autowired
    private CreditCardOfferService service;

    // 1. Get all offers
    @GetMapping
    public ResponseEntity<List<CreditCardOffer>> getAllOffers() {
        List<CreditCardOffer> offers = service.getAllOffers();
        return ResponseEntity.ok(offers); // Return HTTP 200 with the offer list
    }

    // 2. Get a specific offer by ID
    @GetMapping("/{id}")
    public ResponseEntity<CreditCardOffer> getOfferById(@PathVariable String id) {
        CreditCardOffer offer = service.getOfferById(id);
        if (offer == null) {
            return ResponseEntity.notFound().build(); // Return HTTP 404 if not found
        }
        return ResponseEntity.ok(offer); // Return HTTP 200 with the offer
    }

    // 3. Create a new offer
    @PostMapping
    public ResponseEntity<CreditCardOffer> createOffer(@RequestBody CreditCardOffer offer) {
        CreditCardOffer savedOffer = service.createOffer(offer);
        return ResponseEntity.status(201).body(savedOffer); // Return HTTP 201 with the created offer
    }

    // 4. Update an existing offer
    @PutMapping("/{id}")
    public ResponseEntity<CreditCardOffer> updateOffer(@PathVariable String id, @RequestBody CreditCardOffer updatedOffer) {
        CreditCardOffer offer = service.updateOffer(id, updatedOffer);
        if (offer == null) {
            return ResponseEntity.notFound().build(); // Return HTTP 404 if not found
        }
        return ResponseEntity.ok(offer); // Return HTTP 200 with the updated offer
    }

    // 5. Delete an offer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable String id) {
        if (service.deleteOffer(id)) {
            return ResponseEntity.noContent().build(); // Return HTTP 204 if deleted
        }
        return ResponseEntity.notFound().build(); // Return HTTP 404 if not found
    }
}

