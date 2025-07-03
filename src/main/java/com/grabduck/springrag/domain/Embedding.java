package com.grabduck.springrag.domain;

import java.util.Arrays;

/**
 * Represents a vector embedding in the RAG system.
 */
public record Embedding(float[] vector, String sourceText) {
    
    public Embedding {
        if (vector == null) {
            vector = new float[0];
        } else {
            vector = Arrays.copyOf(vector, vector.length);
        }
    }
    
    public Embedding(float[] vector) {
        this(vector, null);
    }
    
    public float[] getVector() {
        return Arrays.copyOf(vector, vector.length);
    }
    
    public int getDimension() {
        return vector.length;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Embedding embedding = (Embedding) o;
        return Arrays.equals(vector, embedding.vector) && 
               java.util.Objects.equals(sourceText, embedding.sourceText);
    }
    
    @Override
    public int hashCode() {
        int result = java.util.Objects.hash(sourceText);
        result = 31 * result + Arrays.hashCode(vector);
        return result;
    }
}
