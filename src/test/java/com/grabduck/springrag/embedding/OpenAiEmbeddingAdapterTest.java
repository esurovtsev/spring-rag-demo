package com.grabduck.springrag.embedding;

import com.grabduck.springrag.domain.model.Embedding;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ai.openai.OpenAiEmbeddingClient;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OpenAiEmbeddingAdapterTest {

    @Mock
    OpenAiEmbeddingClient embeddingClient;

    @InjectMocks
    OpenAiEmbeddingAdapter adapter;

    @Test
    void embed_returnsEmbeddingWithSourceTextAndVector() {
        String text = "Hello world";
        List<Double> vector = Arrays.asList(0.1, 0.2, 0.3);
        when(embeddingClient.embed("Hello world")).thenReturn(vector);

        Embedding embedding = adapter.embed(text);

        assertThat(embedding.vector()).containsExactlyElementsOf(vector);
        assertThat(embedding.sourceText()).isEqualTo("Hello world");
    }

    @Test
    void embed_trimsInputAndPreservesTrimmedSourceText() {
        String text = "   padded text   ";
        List<Double> vector = Arrays.asList(1.0, 2.0, 3.0);
        when(embeddingClient.embed("padded text")).thenReturn(vector);

        Embedding embedding = adapter.embed(text);

        assertThat(embedding.vector()).containsExactlyElementsOf(vector);
        assertThat(embedding.sourceText()).isEqualTo("padded text");
    }

    @Test
    void embed_throwsOnNullInput() {
        assertThatThrownBy(() -> adapter.embed(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void embed_wrapsIllegalArgumentException() {
        when(embeddingClient.embed("fail"))
                .thenThrow(new IllegalArgumentException("empty embedding"));
        assertThatThrownBy(() -> adapter.embed("fail"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("OpenAI returned an empty embedding response");
    }

    @Test
    void embed_wrapsOtherExceptions() {
        when(embeddingClient.embed("fail"))
                .thenThrow(new RuntimeException("network error"));
        assertThatThrownBy(() -> adapter.embed("fail"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Failed to generate embedding");
    }
}
