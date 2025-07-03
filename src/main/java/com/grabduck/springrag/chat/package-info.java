/**
 * This package contains components responsible for LLM interaction.
 * 
 * <p>The chat components handle communication with OpenAI's language models
 * to generate responses based on user queries and retrieved context. This is
 * the "Generation" part of the RAG workflow.</p>
 * 
 * <p>Key components:</p>
 * <ul>
 *   <li>ChatClient: Handles communication with OpenAI API</li>
 *   <li>ChatService: Business logic for prompt construction and response generation</li>
 *   <li>ChatRequest/ChatResponse: Data models for chat operations</li>
 * </ul>
 */
package com.grabduck.springrag.chat;
