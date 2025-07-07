package com.grabduck.springrag.domain.port;

import java.util.List;

import com.grabduck.springrag.domain.model.Document;
import com.grabduck.springrag.domain.model.Embedding;

/**
 * Port interface for vector database operations.
 * Implementations store and retrieve documents by their vector embeddings.
 */
public interface VectorStore {

    /**
     * Stores a document with its embedding in the vector store.
     *
     * @param document  The document to store
     * @param embedding The document's vector embedding
     * @throws RuntimeException if the document cannot be stored
     */
    void storeDocument(Document document, Embedding embedding);

    /**
     * Finds similar documents based on a query embedding.
     *
     * @param queryEmbedding The query embedding to find similar documents for
     * @param limit          Maximum number of documents to return
     * @return List of documents similar to the query embedding, ordered by similarity
     */
    List<Document> findSimilar(Embedding queryEmbedding, int limit);
}
