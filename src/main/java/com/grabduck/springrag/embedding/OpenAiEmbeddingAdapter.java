package com.grabduck.springrag.embedding;

import java.util.List;

import org.springframework.ai.openai.OpenAiEmbeddingClient;
import org.springframework.stereotype.Component;

import com.grabduck.springrag.domain.model.Embedding;
import com.grabduck.springrag.domain.port.EmbeddingPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OpenAiEmbeddingAdapter implements EmbeddingPort {

    private final OpenAiEmbeddingClient embeddingClient;

    @Override
    public Embedding embed(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text for embedding cannot be null or empty");
        }

        try {
            List<Double> embeddingList = embeddingClient.embed(text);
            return new Embedding(embeddingList);
            
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("OpenAI returned an empty embedding response", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate embedding: " + e.getMessage(), e);
        }
    }
}
