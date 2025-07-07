package com.grabduck.springrag.domain.model;

import java.util.List;

import lombok.NonNull;

/**
 * Represents a vector embedding in the RAG system.
 */
public record Embedding(@NonNull List<Double> vector, @NonNull String sourceText) {
    
    public Embedding {
        vector = List.copyOf(vector);
    }
    
    public int getDimension() {
        return vector.size();
    }
}
