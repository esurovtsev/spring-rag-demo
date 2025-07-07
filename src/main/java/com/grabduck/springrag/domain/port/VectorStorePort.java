package com.grabduck.springrag.domain.port;

import java.util.List;
import com.grabduck.springrag.domain.model.Document;
import com.grabduck.springrag.domain.model.Embedding;

/**
 * Port interface for vector database operations.
 */
public interface VectorStorePort {
    void storeDocument(Document document, Embedding embedding);
    List<Document> findSimilar(Embedding embedding, int k);
}
