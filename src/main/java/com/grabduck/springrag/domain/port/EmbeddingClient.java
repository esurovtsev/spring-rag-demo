package com.grabduck.springrag.domain.port;

import com.grabduck.springrag.domain.model.Embedding;

/**
 * Port interface for embedding generation services.
 * Implementations convert text to vector embeddings.
 */
public interface EmbeddingClient {

    /**
     * Generates an embedding vector for the given text.
     *
     * @param text The text to convert to an embedding vector
     * @return The embedding representation of the text
     */
    Embedding embed(String text);
}
