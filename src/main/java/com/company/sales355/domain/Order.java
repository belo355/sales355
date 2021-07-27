package com.company.sales355.domain;

public class Order {

    private DocumentIdentification documentIdentification;
    private Bag bag;

    public Order(DocumentIdentification documentIdentification,  Bag bag) {
        this.documentIdentification = documentIdentification;
        this.bag = bag;
    }

    public DocumentIdentification getDocumentIdentification() {
        return this.documentIdentification;
    }

    public Object getBag() {
        return this.bag;
    }
}