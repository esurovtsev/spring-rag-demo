package com.grabduck.springrag.domain;

import java.util.List;

/**
 * Port interface for chat/LLM operations.
 * Implementations generate text responses based on user queries and optional context.
 */
public interface ChatClient {

    /**
     * Generates a response for a user query, with optional context documents.
     *
     * @param query    The user query
     * @param context  Optional context documents to use for generation (may be empty)
     * @return The generated response
     */
    String generateResponse(Query query, List<Document> context);
}
