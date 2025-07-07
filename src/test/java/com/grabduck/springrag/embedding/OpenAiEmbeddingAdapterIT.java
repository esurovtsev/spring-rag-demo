package com.grabduck.springrag.embedding;

import com.grabduck.springrag.domain.model.Embedding;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = {"spring.ai.openai.api-key=${OPENAI_API_KEY:api-key-not-set}"})
class OpenAiEmbeddingAdapterIT {

    @Autowired
    OpenAiEmbeddingAdapter adapter;

    @Test
    @Disabled("Runs against real OpenAI API. Enable manually for demo.")
    void embed_helloWorld_printsVector() {
        String text = "hello world";
        Embedding embedding = adapter.embed(text);
        System.out.println("Embedding vector for '" + text + "':");
        System.out.println(embedding.vector());
        System.out.println("Dimension: " + embedding.getDimension());
    }
}
