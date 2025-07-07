package com.grabduck.springrag.domain.model;

import java.util.List;

/**
 * Represents an AI-generated response in the RAG system.
 */
public record Response(String text, List<Document> sourceDocs, boolean ragEnabled) {
    
    public Response {
        if (sourceDocs == null) {
            sourceDocs = List.of();
        } else {
            sourceDocs = List.copyOf(sourceDocs);
        }
    }
    
    public Response(String text, boolean ragEnabled) {
        this(text, List.of(), ragEnabled);
    }
    

}
