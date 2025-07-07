/**
 * This package represents the core domain of the RAG application.
 * 
 * <p>The domain package combines rich domain models, ports (interfaces), and orchestration services that
 * form the core of the application. It acts as the central hub that coordinates
 * between the adapter packages (embedding, chat, vectorstore) without them needing
 * to know about each other.</p>
 * 
 * <p>This approach follows hexagonal/clean architecture principles where dependencies
 * flow toward the domain core, and the domain defines ports (interfaces) that are implemented
 * by adapter packages. This ensures that the domain remains isolated from external
 * implementation details.</p>
 * 
 * <p>Key components:</p>
 * <ul>
 *   <li>model: Contains domain model classes (Document, Embedding, Query, Response)</li>
 *   <li>port: Contains interfaces defining what the domain needs from adapters</li>
 *   <li>RagService: Main orchestration service for the RAG workflow</li>
 *   <li>DataInitializer: Service for initializing the vector database</li>
 *   <li>RagConstants: Shared constants for RAG operations</li>
 * </ul>
 */
package com.grabduck.springrag.domain;
