/**
 * This package contains components responsible for vector storage and retrieval.
 * 
 * <p>The vectorstore components handle interactions with the Qdrant vector database
 * for storing document embeddings and performing semantic similarity searches. This is
 * crucial for the "Retrieval" part of the RAG workflow.</p>
 * 
 * <p>Key components:</p>
 * <ul>
 *   <li>VectorStoreClient: Low-level communication with Qdrant</li>
 *   <li>VectorStoreService: Business logic for storing and retrieving vectors</li>
 *   <li>StoredDocument/SearchResult: Data models for vector storage operations</li>
 * </ul>
 */
package com.grabduck.springrag.vectorstore;
