package com.grabduck.springrag.domain.model;

/**
 * Represents a user query in the RAG system.
 */
public record Query(String text, boolean ragEnabled) {
    
    public Query(String text) {
        this(text, true);
    }
}
