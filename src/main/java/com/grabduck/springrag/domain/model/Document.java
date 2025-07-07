package com.grabduck.springrag.domain.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Represents a document in the RAG system.
 */
public record Document(String id, String content, Map<String, String> metadata) {
    
    public Document {
        if (metadata == null) {
            metadata = Map.of();
        } else {
            metadata = Map.copyOf(metadata);
        }
    }
    
    public Document(String content, Map<String, String> metadata) {
        this(UUID.randomUUID().toString(), content, metadata);
    }
    
    public Document(String content) {
        this(content, Map.of());
    }
    
    public Document withMetadata(String key, String value) {
        Map<String, String> newMetadata = new HashMap<>(this.metadata);
        newMetadata.put(key, value);
        return new Document(this.id, this.content, newMetadata);
    }
}
