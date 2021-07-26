package com.company.sales355.domain;

public class Order {

    private DocumentIdentification documentIdentification;
    private Bag bag;

    public Order(DocumentIdentification documentIdentification,  Bag bag) {
        this.documentIdentification = documentIdentification;
        this.bag = bag;
    }

    public DocumentIdentification getDocumentIdentification() {
        return documentIdentification;
    }
}