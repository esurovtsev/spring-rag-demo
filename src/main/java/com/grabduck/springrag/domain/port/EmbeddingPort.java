package com.grabduck.springrag.domain.port;

import com.grabduck.springrag.domain.model.Embedding;

/**
 * Port interface for embedding generation services.
 */
public interface EmbeddingPort {
    Embedding embed(String text);
}
